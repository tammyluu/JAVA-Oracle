package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IndexHorsLimiteException {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        //1
        int number = 0;
        while (!validInput) {
            try {
                System.out.print("Veuillez entrer un entier : ");
                String input = scanner.nextLine();

                // Vérification si l'entrée est bien un entier
                number = Integer.parseInt(input);
                validInput = true;

            } catch (NumberFormatException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
            System.out.println("Votre nombre entier est : " + number);
            scanner.close();

        //2
        double result = 0;
            /* while (!validInput) {
                try {
                    System.out.print("Veuillez entrer un nombre positif: ");
                    String input = scanner.nextLine();
                    int num = Integer.parseInt(input);
                    if (num < 0 ){
                        throw new NumberFormatException("Le nombre ne peut pas être négatif.");
                    }
                    result = Math.sqrt(num);
                    validInput = true;

                }catch (NumberFormatException e){
                    System.out.println("Erreur : La valeur saisie n'est pas un nombre positif. Veuillez réessayer.");
                }catch (IllegalAccessError e){
                    System.out.println("Erreur : " + e.getMessage());
                }*/

       /* while (true) {
            try {
                System.out.print("Veuillez entrer un entier positif : ");
                String userInput = scanner.nextLine();

                int number = Integer.parseInt(userInput);

                if (number < 0) {
                    System.out.println("Erreur : Le nombre ne peut pas être négatif. Veuillez réessayer.");
                    continue;
                }

                result = Math.sqrt(number);
                break; // Sort de la boucle en cas de saisie correcte
            } catch (NumberFormatException e) {
                System.out.println("Erreur : La valeur saisie n'est pas un entier valide. Veuillez réessayer.");
            }
        }
                System.out.println("La racine carré est : " + result);
                scanner.close();*/


        //3
          /*  public int tableau () {

                int[] tab = {1, 2, 3, 4, 5};
         try {
            System.out.println("Accès à l'élement 4 , élément récupéré : "+ tab[4]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erreur : index hors limite");
        }
        try {
            System.out.println("Accès à l'élement 5 , élément récupéré: "+ tab[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erreur : index hors limite " + e.getMessage());
        }*/


    }

}





