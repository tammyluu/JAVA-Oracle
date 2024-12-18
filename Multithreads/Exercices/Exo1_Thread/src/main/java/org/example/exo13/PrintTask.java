package org.example.exo13;

public class PrintTask implements Runnable {
    private final Printer printer;

    public PrintTask(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print(Thread.currentThread().getName());
    }
}
