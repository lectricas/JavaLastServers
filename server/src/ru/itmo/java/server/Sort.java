package ru.itmo.java.server;

import java.util.List;

public class Sort {
    static void bubbleSort(List<Integer> arr) {
        int n = arr.size();
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr.get(j - 1) > arr.get(j)) {
                    temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                }

            }
        }
    }
}
