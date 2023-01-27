import ru.itmo.java.client.AsyncClient;
import ru.itmo.java.client.ClientRunner;
import ru.itmo.java.server.AsyncServer;

import java.io.IOException;

public class RunAsync implements Runner {
    public static void main(String[] args) throws InterruptedException {
        int numberOfClients = 2; // CLIENTS
        int numberOfElements = 500000; // ELEMENTS
        int numberOfRequests = 2; // REQUESTS
    }

    @Override
    public void run(Integer numberOfElements, Integer numberOfClients, Integer delta, Integer numberOfRequests) {
        try {
            Thread server = new Thread(() -> {
                try {
                    new AsyncServer(numberOfClients, numberOfRequests, numberOfElements).run();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread client = new Thread(() -> {
                new ClientRunner(numberOfClients, numberOfElements, numberOfRequests, new AsyncClient()).run();
            }
            );

            server.start();
            client.start();
            server.join();
            client.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
