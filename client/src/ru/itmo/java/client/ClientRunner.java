package ru.itmo.java.client;

import ru.itmo.java.message.Timer;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientRunner {
    private final ExecutorService clientsPool;

    private final int numberOfArrayElements;
    private final int numberOfRequestsPerClient;
    private final int numberOfClients;
    private final Client client;

    private final AtomicInteger clientCount = new AtomicInteger(0);

    public ClientRunner(int numberOfClients, int numberOfElements, int numberOfRequests, Client client) {
        this.numberOfArrayElements = numberOfElements;
        this.numberOfRequestsPerClient = numberOfRequests;
        this.client = client;
        this.numberOfClients = numberOfClients;
        clientsPool = Executors.newFixedThreadPool(numberOfClients);
    }

    public void run() {

        for (int i = 0; i < numberOfClients; i++) {
            clientsPool.submit(() -> {
                try {
                    Instant before = Instant.now();
                    client.run(numberOfArrayElements, numberOfRequestsPerClient);
                    Instant after = Instant.now();
                    Timer.clientResponseTimer.add(Duration.between(before, after).toMillis());
                    clientCount.incrementAndGet();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        while (clientCount.get() < numberOfClients) {

        }
        clientsPool.shutdown();
    }
}
