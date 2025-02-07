package org.example;

import java.util.concurrent.Executors;

public class VirtualThreadDemo {
    public static void main(String[] args) {
      int threadCount = 10_000;
      long startTime = System.currentTimeMillis();

      try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
          for (int i = 0; i < threadCount; i++) {
              executor.execute(() -> {
                  try {
                      Thread.sleep(1000); //simule une tâche
                  }catch (InterruptedException e) {
                      Thread.currentThread().interrupt();
                  }
              });
               long endTime = System.currentTimeMillis();
              System.out.println( " total exectution time : " +( endTime - startTime) + " ms");
          }
      }

    }
}