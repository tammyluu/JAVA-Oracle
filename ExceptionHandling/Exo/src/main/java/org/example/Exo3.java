package org.example;

public class Exo3 {
    public static void main(String[] args) {

        int[] tableau = {1, 2, 3, 4, 5};

        try {
            accederElement(tableau, 4);
            accederElement(tableau, 5);
        } catch (IndexHorsLimiteException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void accederElement(int[] tableau, int index) throws IndexHorsLimiteException {
        if (index < 0 || index >= tableau.length) {
            throw new IndexHorsLimiteException("Index " + index + " hors limites du tableau.");
        }
        System.out.println("Accès à l'élément " + index + " : Élément récupéré : " + tableau[index]);
    }

}
