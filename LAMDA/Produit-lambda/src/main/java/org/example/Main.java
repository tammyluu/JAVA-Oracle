package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String ANSI_YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";

        List<Product> products = new ArrayList<>();
        products.add(new Product("Iphone 16", 1300, 10));
        products.add(new Product("Iphone 15", 1000, 5));
        products.add(new Product("Iphone 14", 800, 0));
        products.add(new Product("Samsung S24", 1090, 8));
        products.add(new Product("Samsung S23 Ultra", 1200, 4));

        // 1. Filtre pour les produits en stock
        FilterProduct inStock = product -> product.getQuantity() > 0;

        // 2. Filtre pour les produits par nom
        FilterProduct byTitle = product -> product.getTitle().toLowerCase().contains("s");

        // 3. Transformation pour augmenter le prix des produits (10%)
        TransformationProduct increasePrice10Percent = product -> {
            product.setPrice(product.getPrice() * 1.1);
            return String.valueOf(product);
        };

        // 4. Transformation pour diminuer le prix des produits (15%)
        TransformationProduct decreasePrice15Percent = product -> {
            product.setPrice(product.getPrice() * 0.85);
            return String.valueOf(product);
        };

        // 5. Transformation pour restocker un produit (+1)
        TransformationProduct restockProduct = product -> {
            product.setQuantity(product.getQuantity() + 1);
            return String.valueOf(product);
        };

        // 6. Transformation pour diminuer le stock (-1)
        TransformationProduct reduceStock = product -> {
            product.setQuantity(product.getQuantity() - 1);
            return String.valueOf(product);
        };

        // 7. Série d'opérations successives : diminuer le prix (20%) puis marquer comme promotion
        OperationProduct applyPromotion = product -> {
            product.setPrice(product.getPrice() * 0.8); // Réduction de 20%
            product.setTitle(ANSI_YELLOW+ "*** Big sale *** - " + RESET + product.getTitle());
            return product;
        };

        // Test des opérations et affichage
        System.out.println("1. Products in stock:");
        products.stream().filter(inStock::test).forEach(System.out::println);

        System.out.println("\n2. Products with title containing 'S ':");
        products.stream().filter(byTitle::test).forEach(System.out::println);

        System.out.println("\n3. Increased price by 10% for all products:");
        products.stream().map(increasePrice10Percent::transform).forEach(System.out::println);

        System.out.println("\n4. Decreased price by 15% for all products:");
        products.stream().map(decreasePrice15Percent::transform).forEach(System.out::println);

        System.out.println("\n5. Restocking all products:");
        products.stream().map(restockProduct::transform).forEach(System.out::println);

        System.out.println("\n6. Reducing stock for all products:");
        products.stream().map(reduceStock::transform).forEach(System.out::println);

        System.out.println("\n7. Applying promotion to all products:");
        products.stream().map(applyPromotion::apply).forEach(System.out::println);
    }
}
