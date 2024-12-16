package org.example;

public class AdvancedProcessorDemo {
    public static void main(String[] args) {
        AdvancedProcessor processor = input -> input.trim().toUpperCase();

        System.out.println("Résultat : "+processor.process("Hello world"));

        processor.print("Hello world");

        AdvancedProcessor.info();
    }
}
