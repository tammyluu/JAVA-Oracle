package org.example;

import java.util.concurrent.*;

public class CalculatorCallable implements Callable<String> {
    private int num;
    public CalculatorCallable(int num) {
        this.num = num;
    }

    @Override
    public String call() throws Exception {
        int cube = num * num * num;
        return "Le cube de " + num + " est " + cube;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 5; i++) {
                CalculatorCallable calculatorCallable = new CalculatorCallable(i);
                Future<String> future = executor.submit(calculatorCallable);
                System.out.println(future.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        } finally {
            executor.shutdown();
        }

    }
}
