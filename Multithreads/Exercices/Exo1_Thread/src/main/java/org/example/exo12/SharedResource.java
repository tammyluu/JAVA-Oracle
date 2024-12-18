package org.example.exo12;

import java.util.ArrayList;
import java.util.List;

class SharedResource {
    private final List<Integer> list = new ArrayList<>();

    // Ajouter un élément avec synchronisation
    public void addElement(int element) {
        synchronized (list) {
            list.add(element);
            System.out.println(Thread.currentThread().getName() + " a ajouté " + element);
        }
    }

    // Supprimer un élément avec synchronisation
    public void removeElement() {
        synchronized (list) {
            if (!list.isEmpty()) {
                int removed = list.remove(0);
                System.out.println(Thread.currentThread().getName() + " a supprimé " + removed);
            } else {
                System.out.println(Thread.currentThread().getName() + " n'a rien à supprimer.");
            }
        }
    }

    // Obtenir une copie de l'état de la liste
    public List<Integer> getList() {
        synchronized (list) {
            return new ArrayList<>(list);
        }
    }
}