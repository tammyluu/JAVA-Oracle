package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<LibraryItem> items = new ArrayList<>();
    private final List<LibraryItem> borrowedItems = new ArrayList<>();

    public void addItem(LibraryItem item){
        items.add(item);
    }

    public void listAvailableItems(){
        for (LibraryItem item : items){
            if(!borrowedItems.contains(item)){
                System.out.println(" - "+ item.getDetails());
            }
        }
    }

    public void listBorrowedItems(){
        for (LibraryItem item : borrowedItems){
            System.out.println("- "+item.getDetails());
        }
    }

    public BorrowRecord borrowItem(int id, String borrowerName, String borrowDate){
        for (LibraryItem item : items){
            if(item.getId() == id && !borrowedItems.contains(item)) {
                borrowedItems.add(item);
                return new BorrowRecord(id,borrowerName,borrowDate);
            }
        }
        throw new IllegalArgumentException("Element introuvable ou déja emprunté");
    }



}
