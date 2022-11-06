package ru.itmo.java.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
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

public class ComplexClient implements AutoCloseable {
    private final Socket socket;
    private final Scanner scanner;

    private final ExecutorService readPool = Executors.newSingleThreadExecutor();
    private final ExecutorService writePool = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws IOException {
        try (
            Socket socket = new Socket("localhost", Constant.PORT);
            Scanner scanner = new Scanner(System.in);
            var client = new ComplexClient(socket, scanner)
        ) {
            client.run();
        }
    }

    public void run() {
        ComplexClient client = new ComplexClient(socket, scanner);
        while (true) {
            System.out.print(">> ");
            String command = scanner.next();
            if (command.equals("exit")) return;
            client.processCommand(command);
        }
    }

    public ComplexClient(Socket socket, Scanner scanner) {
        this.socket = socket;
        this.scanner = scanner;
    }

    public void processCommand(String command) {
        try {
            switch (command) {
                case "echo":
                    processEcho();
                    break;
                case "calc":
                    processCalc();
                    break;
                default:
                    System.out.println("  Incorrect command");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processCalc() throws IOException {
        int x = scanner.nextInt();
        Operation operation = Operation.valueOf(scanner.next());
        int y = scanner.nextInt();
        CalculationRequest request = CalculationRequest.newBuilder()
            .setX(x)
            .setY(y)
            .setOperation(operation)
            .build();
        executeWriteTask(() -> {
            BaseRequest.newBuilder().setCalculationRequest(request).build().writeDelimitedTo(socket.getOutputStream());
            executeReadTask(this::handleResponse);
        });
    }

    private void processEcho() throws IOException {
        String message = scanner.next();
        EchoRequest request = EchoRequest.newBuilder().setMessage(message).build();
        executeWriteTask(() -> {
            BaseRequest.newBuilder().setEchoRequest(request).build().writeDelimitedTo(socket.getOutputStream());
            executeReadTask(this::handleResponse);
        });
    }

    private void handleResponse() throws IOException {
        BaseResponse response = BaseResponse.parseDelimitedFrom(socket.getInputStream());
        if (response.hasEchoResponse()) {
            EchoResponse echoResponse = response.getEchoResponse();
            System.out.println("message: " + echoResponse.getMessage());
        } else if (response.hasCalculationResponse()) {
            CalculationResponse calculationResponse = response.getCalculationResponse();
            System.out.println("result: " + calculationResponse.getResult());
        } else {
            System.out.println("Invalid response");
        }
    }

    private void executeWriteTask(WriteTask task) {
        writePool.submit(() -> {
            try {
                task.run();
            } catch (IOException e) {}
        });
    }

    private void executeReadTask(WriteTask task) {
        readPool.submit(() -> {
            try {
                task.run();
            } catch (IOException e) {}
        });
    }

    @Override
    public void close() {
        readPool.shutdown();
        writePool.shutdown();
    }
}
