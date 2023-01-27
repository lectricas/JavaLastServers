package ru.itmo.java.server;

import ru.itmo.java.message.simple.MyArray;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.itmo.java.message.Constant.PORT;

public class AsyncServer {

    private final int numberOfRequests;
    private final int numberOfClients;
    private final int numberOfElements;
    private final ExecutorService workers;
    private final ExecutorService sender;

    AtomicInteger numberOfJobsSend = new AtomicInteger(0);
    AtomicInteger numberOfClientsConnected = new AtomicInteger(0);

    public AsyncServer(int numberOfClients, int numberOfRequests, int numberOfElements) {
        this.numberOfRequests = numberOfRequests;
        this.numberOfClients = numberOfClients;
        this.numberOfElements = numberOfElements;
        this.workers = Executors.newFixedThreadPool(10);
        this.sender = Executors.newSingleThreadExecutor();
    }

    public void run() throws IOException, InterruptedException {
        runReader();
    }

    private void runReader() {
        try {
            final AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open();
            assc.bind(new InetSocketAddress(PORT));
            assc.accept(null, new CompletionHandler<>() {
                @Override
                public void completed(AsynchronousSocketChannel asc, Object _unused) {

                    if (numberOfClientsConnected.incrementAndGet() < numberOfClients) {
                        assc.accept(null, this);
                    }

                    AsyncClientData data = new AsyncClientData(asc);
                    asc.read(data.header, data, new CompletionHandler<>() {
                        @Override
                        public void completed(Integer resultSize, AsyncClientData attach) {
                            try {
                                if (!attach.readHeader) {
                                    if (attach.header.hasRemaining()) {
                                        attach.asc.read(attach.header, attach, this);
                                    } else {
                                        attach.header.flip();
                                        attach.buffer = ByteBuffer.allocate(attach.header.getInt());
                                        attach.readHeader = true;
                                        attach.asc.read(attach.buffer, attach, this);
                                    }
                                } else {
                                    if (!attach.buffer.hasRemaining()) {
                                        attach.buffer.flip();
                                        final MyArray request = MyArray.parseFrom(attach.buffer.array());
                                        submitToWorker(request, attach, this);
                                    } else {
                                        attach.asc.read(attach.buffer, attach, this);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void failed(Throwable exc, AsyncClientData attachment) {
                            exc.printStackTrace();
                        }
                    });
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    exc.printStackTrace();
                }
            });

            while (numberOfJobsSend.get() < numberOfClients * numberOfRequests) {
                //pass
            }
            System.out.println("shutdown");
            workers.shutdown();
            sender.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitToWorker(
            MyArray request,
            AsyncClientData attachR,
            CompletionHandler<Integer, AsyncClientData> readerHandler
    ) {
        workers.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    final List<Integer> arr = new ArrayList<>(request.getArrayList());
//                                                    Sort.bubbleSort(arr);
                    var request = MyArray.newBuilder()
                            .addAllArray(arr)
                            .build();
                    final ByteBuffer writeBuffer = ByteBuffer.wrap(request.toByteArray());
                    submitToSender(writeBuffer, attachR, readerHandler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void submitToSender(
            ByteBuffer writeBuffer,
            AsyncClientData attachR,
            CompletionHandler<Integer, AsyncClientData> readerHandler) {
        sender.submit(new Runnable() {
            @Override
            public void run() {
                attachR.asc.write(writeBuffer, attachR, new CompletionHandler<>() {
                    @Override
                    public void completed(Integer result, AsyncClientData attachW) {
                        if (writeBuffer.hasRemaining()) {
                            attachW.asc.write(writeBuffer, attachW, this);
                        } else {
                            attachW.buffer = null;
                            attachW.header.clear();
                            attachW.readHeader = false;

                            numberOfJobsSend.incrementAndGet();
                            if (attachW.numberOfRequests.incrementAndGet() < numberOfRequests) {
                                attachW.asc.read(attachW.header, attachW, readerHandler);
                            }
                        }
                    }

                    @Override
                    public void failed(Throwable exc, AsyncClientData attachment) {
                        exc.printStackTrace();
                    }
                });
            }
        });
    }

    class AsyncClientData {
        ByteBuffer buffer;
        ByteBuffer header;
        boolean readHeader = false;
        AtomicInteger numberOfRequests = new AtomicInteger(0);
        AsynchronousSocketChannel asc;

        public AsyncClientData(AsynchronousSocketChannel asc) {
            this.header = ByteBuffer.allocate(4);
            this.asc = asc;
        }
    }
}
