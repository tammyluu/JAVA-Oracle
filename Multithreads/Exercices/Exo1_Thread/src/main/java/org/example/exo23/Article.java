package org.example.exo23;

public class Article {
private final int id;
private final String name;
private final double price;

public Article(int id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
}

@Override
public String toString() {
    return String.format("Article{id: %d| name:'%s'| price: %.2f}", id, name, price);
}
}



