package org.example;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addItem(new Book(1,"tom tom et nana",1990,"toto","Enfants"));
        library.addItem(new Magazine(2,"toto et tata",2012,42));


        // Liste de element dispo
        System.out.println("Liste des elements disponible");
        library.listAvailableItems();

        // emprunter un élement
        System.out.println("Emprunt d'un element ...");
        BorrowRecord record = library.borrowItem(1,"Titi","2024-12-03");
        System.out.println(record);

        // lister des elements empruntes
        System.out.println("listes de elements empruntés");
        library.listBorrowedItems();

        // Liste de element dispo
        System.out.println("Liste des elements disponible");
        library.listAvailableItems();


    }
}