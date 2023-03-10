package ru.itmo.java.client;

import ru.itmo.java.message.Constant;
import ru.itmo.java.message.Loger;
import ru.itmo.java.message.simple.MyArray;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleClient implements Client {

    public void run(int numberOfArrayElements, int numberOfRequestsPerClient) throws IOException {
        Socket socket = new Socket("localhost", Constant.PORT);
        for (int i = 0; i < numberOfRequestsPerClient; i++) {
            List<Integer> arr = new ArrayList<>();
            Random r = new Random();
            for (int j = 0; j < numberOfArrayElements; j++) {
                arr.add(r.nextInt());
            }
            var request = MyArray.newBuilder()
                    .addAllArray(arr)
                    .build();
            request.writeDelimitedTo(socket.getOutputStream());
            var response = MyArray.parseDelimitedFrom(socket.getInputStream());
        }
        socket.close();
    }
}
