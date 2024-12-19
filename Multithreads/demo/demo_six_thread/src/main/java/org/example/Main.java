package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // avec un simple arraylist
        List<Integer> list = new ArrayList<Integer>();

        // avec une synchronize list
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        // et avec une collection concurrente thread safe
        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();

        System.out.println("Avec la l'arraylist clasique");
        runTest(list);

        System.out.println("avec la collection synchronizedList");
        runTest(synchronizedList);

        System.out.println("avec la collection copyOnWriteList");
        runTest(copyOnWriteList);

    }

    private static void runTest(List<Integer> list) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("List size: " + list.size());
    }

    }