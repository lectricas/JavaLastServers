import ru.itmo.java.client.ClientRunner;
import ru.itmo.java.client.NoLockClient;
import ru.itmo.java.server.NoLockServer;

import java.io.IOException;

public class RunNoLock implements Runner {

    public static void main(String[] args) throws InterruptedException {
        new RunNoLock().run(10, 10, 0, 50);
    }

    @Override
    public void run(Integer numberOfElements, Integer numberOfClients, Integer delta, Integer numberOfRequests) {
        try {
            Thread server = new Thread(() -> {
                try {
                    new NoLockServer(numberOfClients, numberOfRequests, numberOfElements).run();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread client = new Thread(() ->
                    new ClientRunner(numberOfClients, numberOfElements, numberOfRequests, new NoLockClient()).run()
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
