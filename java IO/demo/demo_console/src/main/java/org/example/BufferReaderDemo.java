package org.example;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderDemo {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the your name: ");
            String name = br.readLine();
            System.out.print("Enter the your age: ");
            int age = Integer.parseInt(br.readLine());
            System.out.println("Welcome " + name + "! You're " + age + " years old.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
