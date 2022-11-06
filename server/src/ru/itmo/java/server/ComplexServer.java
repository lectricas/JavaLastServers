package ru.itmo.java.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.itmo.java.message.Constant;
import ru.itmo.java.message.WriteTask;
import ru.itmo.java.message.complex.BaseRequest;
import ru.itmo.java.message.complex.BaseResponse;
import ru.itmo.java.message.complex.CalculationRequest;
import ru.itmo.java.message.complex.CalculationRequest.Operation;
import ru.itmo.java.message.complex.CalculationResponse;
import ru.itmo.java.message.complex.EchoRequest;
import ru.itmo.java.message.complex.EchoResponse;

public class ComplexServer {
    private final ExecutorService pool = Executors.newCachedThreadPool();
    private final ExecutorService workerPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        new ComplexServer().run();
    }

    public void run() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(Constant.PORT)) {
            while (true) {
                var socket = serverSocket.accept();
                System.out.println("Client accepted");
                pool.submit(new Worker(socket));
            }
        } finally {
            pool.shutdown();
            workerPool.shutdown();
        }
    }

    private class Worker implements Runnable {
        private final Socket socket;
        private final ExecutorService writePool = Executors.newSingleThreadExecutor();

        public Worker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket socket = this.socket) {
                System.out.println("Client connected");
                while (true) {
                    var baseRequest = BaseRequest.parseDelimitedFrom(socket.getInputStream());
                    if (baseRequest.hasEchoRequest()) {
                        handle(baseRequest.getEchoRequest());
                    } else if (baseRequest.hasCalculationRequest()) {
                        handle(baseRequest.getCalculationRequest());
                    } else {
                        System.out.println("Bad request");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client disconnected");
            writePool.shutdown();
        }

        private void handle(EchoRequest request) throws IOException {
            var response = BaseResponse.newBuilder()
                .setEchoResponse(
                    EchoResponse.newBuilder().setMessage(request.getMessage())
                )
                .build();
            executeWriteTask(() -> response.writeDelimitedTo(socket.getOutputStream()));
        }

        private void handle(CalculationRequest request) throws IOException {
            workerPool.submit(() -> {
                int x = request.getX();
                int y = request.getY();
                Operation operation = request.getOperation();
                int result = 0;
                switch (operation) {
                    case Add -> {
                        result = x + y;
                    }
                    case Sub -> {
                        result = x - y;
                    }
                    case Mul -> {
                        result = x * y;
                    }
                    case Div -> {
                        result = x / y;
                    }
                    case UNRECOGNIZED -> {
                        System.out.println("Unrecognized operation");
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}

                var calcResponse = CalculationResponse.newBuilder().setResult(result).build();
                var response = BaseResponse.newBuilder().setCalculationResponse(calcResponse).build();
                executeWriteTask(() -> response.writeDelimitedTo(socket.getOutputStream()));
            });
        }

        private void executeWriteTask(WriteTask task) {
            writePool.submit(() -> {
                try {
                    task.run();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
