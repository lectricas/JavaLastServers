package ru.itmo.java.client;

import java.io.IOException;
import java.net.Socket;
import ru.itmo.java.message.Constant;
import ru.itmo.java.message.simple.Request;
import ru.itmo.java.message.simple.Response;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", Constant.PORT)) {
            var request = Request.newBuilder()
                .setId(1)
                .build();
            request.writeDelimitedTo(socket.getOutputStream());

            var response = Response.parseDelimitedFrom(socket.getInputStream());
            var person = response.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getEmail());
        }
    }
}
