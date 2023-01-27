package ru.itmo.java.client;

import java.io.IOException;

public interface Client {
    public void run(int numberOfArrayElements, int numberOfRequestsPerClient) throws IOException;
}
