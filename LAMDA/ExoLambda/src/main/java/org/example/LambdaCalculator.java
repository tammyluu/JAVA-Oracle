package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class LambdaCalculator {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, Calculator> operations = new HashMap<>();

        operations.put("addition", (a, b) -> a + b);
        operations.put("subtraction", (a, b) -> a - b);
        operations.put("multiplication", (a, b) -> a * b);
        operations.put("division", (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        });

        //comsumer pour affichage
        Consumer<String> shown = System.out::println;

        shown.accept("Welcome to Lambda calculator!!!!");

        String operation = getValidOperation( shown, operations);


        if (!operations.containsKey(operation)) {
            shown.accept("Invalid operation. Please try again.");
            return;
        }

        try {
            shown.accept("Enter your first number: ");
            double num1 = sc.nextDouble();
            shown.accept("Enter your second number: ");
            double num2 = sc.nextDouble();

            // Récupérer l'opération depuis la Map et l'exécuter
            Calculator calc = operations.get(operation);
            double result = calc.operate(num1, num2);
            shown.accept("Your result is :\n" + num1 + "  " + operation + " " + num2 + " " + " = " + result);
        } catch (ArithmeticException e) {
            shown.accept("Error : " + e.getMessage());
        } catch (Exception e) {
            shown.accept("An unexpected error has occurred. : " + e.getMessage());
        } finally {
            sc.close();
        }

    }

    /**
     * Méthode pour obtenir une opération valide.
     * @param shown      Consumer pour afficher des messages
     * @param operations Map des opérations disponibles
     * @return une chaîne valide correspondant à une opération
     */
    private static String getValidOperation( Consumer<String> shown, Map<String, Calculator> operations) {
        String operation;
        while (true) {
            shown.accept("Enter your operation (addition, subtraction, multiplication, division):");
            operation = sc.nextLine().toLowerCase();
            if (operations.containsKey(operation)) {
                break; // Sortir de la boucle si l'opération est valide
            } else {
                shown.accept("Invalid operation. Please try again.");
            }
        }
        return operation;
    }

}
