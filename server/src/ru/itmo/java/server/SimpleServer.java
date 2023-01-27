package ru.itmo.java.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import ru.itmo.java.message.Constant;
import ru.itmo.java.message.Loger;
import ru.itmo.java.message.Timer;
import ru.itmo.java.message.simple.*;

public class SimpleServer {
    private final ExecutorService readers;
    private final ExecutorService writers;
    private final ExecutorService workers;

    private final int numberOfRequestsPerClient;
    private final int numberOfClients;

    private final int numberOfRequestTotal;

    final AtomicInteger counter = new AtomicInteger(0);

    public SimpleServer(int numberOfClients, int numberOfRequestsPerClient) {
        this.numberOfRequestsPerClient = numberOfRequestsPerClient;
        this.numberOfClients = numberOfClients;
        numberOfRequestTotal = numberOfClients * numberOfRequestsPerClient;
        readers = Executors.newFixedThreadPool(numberOfClients);
        writers = Executors.newFixedThreadPool(numberOfClients);
        workers = Executors.newFixedThreadPool(10);
    }

    public void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(Constant.PORT);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        for (int i = 0; i < numberOfClients; i++) {
            final Socket socket;
            try {
                socket = serverSocket.accept();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            readers.submit(() -> {
                for (int j = 0; j < numberOfRequestsPerClient; j++) {
                    final MyArray request;
                    try {
                        request = MyArray.parseDelimitedFrom(socket.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new IllegalStateException(e);
                    }
                    final Instant beforeRequest = Instant.now();
                    workers.submit(() -> {
                        final List<Integer> arr = new ArrayList<>(request.getArrayList());
                        Instant beforeSort = Instant.now();
                        Sort.bubbleSort(arr);
                        Instant afterSort = Instant.now();
                        Timer.sortingTimer.offer(Duration.between(beforeSort, afterSort).toMillis());
                        var response = MyArray.newBuilder().addAllArray(arr).build();
                        writers.submit(() -> {
                            try {
                                final Instant afterRequest = Instant.now();
                                Timer.serverResponseTimer.add(Duration.between(beforeRequest, afterRequest).toMillis());
                                response.writeDelimitedTo(socket.getOutputStream());
                                counter.getAndIncrement();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    });
                }
            });
        }
        while (counter.get() < numberOfRequestTotal) {
            //wait
        }

        try {
            writers.shutdown();
            workers.shutdown();
            serverSocket.close();
            readers.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
