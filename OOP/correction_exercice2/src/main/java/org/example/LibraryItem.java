package org.example;


public sealed abstract class LibraryItem permits Book,Magazine{

    private final int id;
    private final String title;
    private final int publicationYear;

    public LibraryItem(int id, String title, int publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public abstract String getDetails();

}
