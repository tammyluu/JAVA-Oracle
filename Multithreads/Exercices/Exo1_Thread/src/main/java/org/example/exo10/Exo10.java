package org.example.exo10;

import java.util.concurrent.atomic.AtomicLong;

public class Exo10 {
    public static void main(String[] args) {
        AtomicLong sharedValue = new AtomicLong(1);
        int numThreads = 5;
        long[] multiplicators = {2,3,4,5,6};
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            final int index = i;

        }

    }
}
