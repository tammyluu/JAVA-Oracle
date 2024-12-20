package org.example.exo23;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Commande {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private final int id;
    private final List<Article> articles;

    public Commande(List<Article> articles) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.articles = articles;
    }

    @Override
    public String toString() {
        return String.format("Commande{id=%d, articles=%s}", id, articles);
    }
}
