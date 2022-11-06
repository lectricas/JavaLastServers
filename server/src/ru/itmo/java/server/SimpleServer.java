package ru.itmo.java.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.itmo.java.message.Constant;
import ru.itmo.java.message.simple.Person;
import ru.itmo.java.message.simple.Request;
import ru.itmo.java.message.simple.Response;

public class SimpleServer {
    private final ExecutorService pool = Executors.newCachedThreadPool();
    private final ConcurrentHashMap<Integer, Person> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        new SimpleServer().run();
    }

    public void run() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(Constant.PORT)) {
            while (true) {
                var socket = serverSocket.accept();
                System.out.println("Client accepted");
                pool.submit(new Worker(socket));
            }
        }
    }

    private class Worker implements Runnable {
        private final Socket socket;

        public Worker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket socket = this.socket) {
                var request = Request.parseDelimitedFrom(socket.getInputStream());
                var person = map.computeIfAbsent(
                    request.getId(),
                    (key) -> Person.newBuilder()
                        .setName("John Doe")
                        .setEmail("john@qqq.com")
                        .setId(key)
                        .build()
                    );
                Response.newBuilder().setPerson(person).build().writeDelimitedTo(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
