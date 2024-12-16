package org.example;

public class StringProcessorDemo {
    public static void main(String[] args) {
        StringProcessor toUpperCaseProcessor = string -> string.toUpperCase();
//    StringProcessor toUpperCaseProcessor = String::toUpperCase;
        System.out.println("Majuscules : "+toUpperCaseProcessor.process("hello"));

        StringProcessor reverseProcessor = input -> new StringBuilder(input).reverse().toString();
        System.out.println("Inversé : "+reverseProcessor.process("world"));
    }
}
