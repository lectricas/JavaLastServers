package ru.itmo.java.server;

import ru.itmo.java.message.Timer;
import ru.itmo.java.message.simple.MyArray;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ru.itmo.java.message.Constant.PORT;

public class NoLockServer {

    private Selector readSelector;
    private Selector writeSelector;

    Queue<RecieveData> read = new LinkedList<>();

    private final int numberOfRequests;
    private final int numberOfClients;
    private final int numberOfElements;
    private final ExecutorService workers;

    public NoLockServer(int numberOfClients, int numberOfRequests, int numberOfElements) {
        this.numberOfRequests = numberOfRequests;
        this.numberOfClients = numberOfClients;
        this.numberOfElements = numberOfElements;
        this.workers = Executors.newFixedThreadPool(10);
    }

    public void run() throws IOException, InterruptedException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(PORT));
        readSelector = Selector.open();
        writeSelector = Selector.open();

        Thread t1 = new Thread(this::readSelector);
        t1.start();

        Thread t2 = new Thread(this::writeSelector);
        t2.start();

        for (int i = 0; i < numberOfClients; i++) {
            SocketChannel client = serverChannel.accept();
            client.configureBlocking(false);
            read.add(new RecieveData(client));
            readSelector.wakeup();
        }

        t1.join();
        t2.join();
    }


    public void readSelector() {
        int requestsReceived = 0;
        try {
            while (true) {
                readSelector.select();
                Set<SelectionKey> keys = readSelector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                loop1:
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    RecieveData data = (RecieveData) key.attachment();
                    if (key.isReadable()) {
                        if (!data.readHeader) {
                            while (data.header.hasRemaining()) {
                                data.socket.read(data.header);
                            }

                            data.header.flip();
                            data.buffer = ByteBuffer.allocate(data.header.getInt());
                            data.readHeader = true;
                        }

                        int read = data.socket.read(data.buffer);
                        if (!data.buffer.hasRemaining()) {
                            data.buffer.flip();
                            data.before = Instant.now();
                            final MyArray request = MyArray.parseFrom(data.buffer.array());
                            workers.submit(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        final List<Integer> arr = new ArrayList<>(request.getArrayList());
                                        Instant beforeSort = Instant.now();
                                        Sort.bubbleSort(arr);
                                        Instant afterSort = Instant.now();
                                        Timer.sortingTimer.offer(Duration.between(beforeSort, afterSort).toMillis());
                                        var request = MyArray.newBuilder()
                                                .addAllArray(arr)
                                                .build();
                                        data.sortedResponses.add(ByteBuffer.wrap(request.toByteArray()));
                                        SelectionKey keyToRegister = data.socket.register(writeSelector, SelectionKey.OP_WRITE);
                                        keyToRegister.attach(data);
                                        writeSelector.wakeup();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            data.buffer = null;
                            data.header.clear();
                            data.readHeader = false;
                            data.before = null;
                            requestsReceived++;
                            if (requestsReceived == numberOfClients * numberOfRequests) {
                                workers.shutdown();
                                return;
                            }
                        }
                    }
                    iterator.remove();
                }

                if (!read.isEmpty()) {
                    RecieveData c = read.poll();
                    SelectionKey keyToRegister = c.socket.register(readSelector, SelectionKey.OP_READ);
                    keyToRegister.attach(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeSelector() {
        int requestsSend = 0;
        try {
            while (true) {
                writeSelector.select();
                Set<SelectionKey> keys = writeSelector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    RecieveData data = (RecieveData) key.attachment();
                    if (key.isWritable()) {
                        if (!data.sortedResponses.isEmpty()) {
                            ByteBuffer last = data.sortedResponses.peek();
                            if (last.hasRemaining()) {
                                data.socket.write(last);
                            } else {
                                data.sortedResponses.poll();
                            }
                            requestsSend++;
                            if (requestsSend == numberOfClients * numberOfRequests) {
                                return;
                            }

                        } else {
                            key.cancel();
                        }
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    class RecieveData {
        ByteBuffer buffer;
        ByteBuffer header;
        SocketChannel socket;
        boolean readHeader = false;
        ConcurrentLinkedQueue<ByteBuffer> sortedResponses = new ConcurrentLinkedQueue<>();
        Instant before;

        public RecieveData(SocketChannel socket) {
            this.socket = socket;
            this.header = ByteBuffer.allocate(4);
        }
    }
}
