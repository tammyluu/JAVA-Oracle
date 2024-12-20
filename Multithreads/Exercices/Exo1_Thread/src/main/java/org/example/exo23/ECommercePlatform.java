package org.example.exo23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ECommercePlatform {
    private final List<Article> catalogue = new ArrayList<Article>();
    private final List<Commande> commandes = Collections.synchronizedList(new ArrayList<>());

    public void initCatalogue() {
        catalogue.add(new Article(1, "Iphone", 1200.99));
        catalogue.add(new Article(2, "Samsung", 799.49));
        catalogue.add(new Article(3, "Samsung PC Tablet", 1299.99));
        catalogue.add(new Article(4, "Mac Book", 1399.99));
    }
    //renvoyer une vue non modifiable du catalogue d'articles
    List<Article> getCatalogue() {
        return Collections.unmodifiableList(catalogue);
    }
    public void passerCommande( Panier panier ) {
        commandes.add(new Commande(panier.getArticles()));
    }
    public void traiteCommande() {
        synchronized (commandes) {
            System.out.println("Traitement des commandes : " + commandes.size());
            commandes.forEach(System.out::println);
            commandes.clear();
        }
    }
}
