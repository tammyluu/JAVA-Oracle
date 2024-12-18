package org.example.exo12;

import java.util.ArrayList;
import java.util.List;

class SharedResource {
    private final List<Integer> list = new ArrayList<>();
    private final Object lock = new Object();


    // Ajouter un élément avec synchronisation
    public void addElement(int element) {
        synchronized (lock) {
            list.add(element);
            System.out.println(Thread.currentThread().getName() + " a ajouté " + element);
        }
    }

    // Supprimer un élément avec synchronisation
    public void removeElement() {
        synchronized (lock) {
            if (!list.isEmpty()) {
                int removed = list.remove(0);
                System.out.println(Thread.currentThread().getName() + " a supprimé " + removed);
            } else {
                System.out.println(Thread.currentThread().getName() + " n'a rien à supprimer.");
            }
        }
    }

   /* // Obtenir une copie de l'état de la liste
    public List<Integer> getList() {
        synchronized (lock) {
            return new ArrayList<>(list);
        }*/
   public static void main(String[] args) throws InterruptedException {
       SharedResource sharedResource = new SharedResource();
       Runnable add = ()->{
           for (int i = 0; i < 5; i++) {
               sharedResource.addElement(i);
           }
   };
       Runnable remove = ()->{
           for (int i = 0; i < 5; i++) {
               sharedResource.removeElement();
           }
       };
       Thread thread1 = new Thread(add, "Thread -1");
       Thread thread2 = new Thread(remove, "Thread -2");

       thread1.start();
       thread2.start();
       thread1.join();
       thread2.join();

       System.out.println("Liste final : " + sharedResource.list);

    }
}