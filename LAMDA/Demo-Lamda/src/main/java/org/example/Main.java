package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "banana");
        fruits.sort(String::compareTo);
        System.out.println("sort list: " + fruits);

        //Function
        Function<String,Integer> stringIntergerFunction = str -> str.length();

        String input = "Hello World";
        int length = stringIntergerFunction.apply(input);
        System.out.println("length of : \n" +input+"\n"+ length);

        //Consumer
        Consumer<String> printMessage = message ->{
            System.out.println("Message : "+message);
        };
        printMessage.accept("Ceci est un test");

        //Predicate
        Predicate<Integer> isEvent = number -> number % 2 == 0;


        //supplier
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        System.out.println("Random numbers: " + randomSupplier.get());

        int testNumber = 5;
        if(isEvent.test(testNumber)){
            printMessage.accept(testNumber + " is even.");
        }else {
            printMessage.accept(testNumber + " is odd.");
        }

    }
}