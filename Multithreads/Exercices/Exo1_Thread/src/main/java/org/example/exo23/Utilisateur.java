package org.example.exo23;

import java.util.List;
import java.util.Random;

public class Utilisateur implements Runnable {
    private final int id;
    private final Panier panier;
    private final ECommercePlatform platform;

    public Utilisateur(int id, ECommercePlatform platform) {
        this.id = id;
        this.panier = new Panier();
        this.platform = platform;
    }

    @Override
    public void run() {
        List<Article> catalogue = platform.getCatalogue();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            Article article = catalogue.get(random.nextInt(catalogue.size()));
            panier.addArticle(article);
        }

        System.out.println("Utilisateur " + id + " a rempli son panier: " + panier.getArticles());
        platform.passerCommande(panier);

    }
}
