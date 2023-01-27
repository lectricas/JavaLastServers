import ru.itmo.java.client.ClientRunner;
import ru.itmo.java.client.SimpleClient;
import ru.itmo.java.server.SimpleServer;

public class RunSimple implements Runner {

    public static void main(String[] args) throws InterruptedException {
        int numberOfClients = 5;
        int numberOfElements = 2;
        int numberOfRequests = 5;
//        new RunNoLock().run(numberOfClients, numberOfRequests, numberOfElements);
    }

    @Override
    public void run(Integer numberOfElements, Integer numberOfClients, Integer delta, Integer numberOfRequests) {
        try {
            Thread server = new Thread(() -> {
                new SimpleServer(numberOfClients, numberOfRequests).run();

            });

            Thread client = new Thread(() ->
                    new ClientRunner(numberOfClients, numberOfElements, numberOfRequests, new SimpleClient()).run()
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
