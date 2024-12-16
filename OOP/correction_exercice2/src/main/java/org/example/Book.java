package org.example;

public final class Book extends LibraryItem{
    private String author;
    private String genre;

    public Book(int id, String title, int publicationYear, String author,String genre) {
        super(id, title, publicationYear);
        this.author = author;
        this.genre = genre;
    }


    @Override
    public String getDetails() {
        return "Livre : [Titre : "+ getTitle() + ", Auteur : "+ author +", Genre : "+
                 genre + ", Année : "+ getPublicationYear() + "]";
    }
}
