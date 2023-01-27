package ru.itmo.java.message;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Timer {
    public static Queue<Long> sortingTimer = new ConcurrentLinkedQueue<>();
    public static Queue<Long> serverResponseTimer = new ConcurrentLinkedQueue<>();
    public static Queue<Long> clientResponseTimer = new ConcurrentLinkedQueue<>();

    public static void clear() {
        sortingTimer.clear();
        serverResponseTimer.clear();
        clientResponseTimer.clear();
    }
}
