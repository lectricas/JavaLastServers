//package ru.itmo.java.client;
//
//import ru.itmo.java.message.Constant;
//import ru.itmo.java.message.simple.MyArray;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.nio.ByteBuffer;
//import java.nio.channels.AsynchronousServerSocketChannel;
//import java.nio.channels.AsynchronousSocketChannel;
//import java.nio.channels.CompletionHandler;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import static ru.itmo.java.message.Constant.PORT;
//
//public class NewAsyncClient {
//    public void run(int numberOfClients, int numberOfArrayElements, int numberOfRequestsPerClient) throws IOException {
//
//        Socket socket = new Socket("localhost", Constant.PORT);
//
//    }
//
//    private void runReader() {
//        try {
//            final AsynchronousSocketChannel assc = AsynchronousSocketChannel.open();
//            assc.bind(new InetSocketAddress("localhost", PORT));
//
//            assc.accept(null, new CompletionHandler<>() {
//                @Override
//                public void completed(AsynchronousSocketChannel asc, Object _unused) {
//
//                    if (numberOfClientsConnected.incrementAndGet() < numberOfClients) {
//                        assc.accept(null, this);
//                    }
//
//                    AsyncClientData data = new AsyncClientData(asc);
//                    asc.read(data.header, data, new CompletionHandler<>() {
//                        @Override
//                        public void completed(Integer resultSize, AsyncClientData attach) {
//                            try {
//                                if (!attach.readHeader) {
//                                    if (attach.header.hasRemaining()) {
//                                        attach.asc.read(attach.header, attach, this);
//                                    } else {
//                                        attach.header.flip();
//                                        attach.buffer = ByteBuffer.allocate(attach.header.getInt());
//                                        attach.readHeader = true;
//                                        attach.asc.read(attach.buffer, attach, this);
//                                    }
//                                } else {
//                                    if (!attach.buffer.hasRemaining()) {
//                                        attach.buffer.flip();
//                                        final MyArray request = MyArray.parseFrom(attach.buffer.array());
//                                        submitToWorker(request, attach, this);
//                                    } else {
//                                        attach.asc.read(attach.buffer, attach, this);
//                                    }
//                                }
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                        @Override
//                        public void failed(Throwable exc, AsyncClientData attachment) {
//                            exc.printStackTrace();
//                        }
//                    });
//                }
//
//                @Override
//                public void failed(Throwable exc, Object attachment) {
//                    exc.printStackTrace();
//                }
//            });
//
//            while (numberOfJobsSend.get() < numberOfClients * numberOfRequests) {
//                //pass
//            }
//            System.out.println("shutdown");
//            workers.shutdown();
//            sender.shutdown();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
