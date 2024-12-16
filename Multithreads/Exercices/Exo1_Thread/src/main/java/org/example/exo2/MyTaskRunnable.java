package org.example.exo2;

public class MyTaskRunnable implements Runnable {
    int num;
    public MyTaskRunnable(int num) {
        this.num = num;
    }
    @Override
    public void run() {

            System.out.println("Le carré de " + num + " est " + num*num);
            try {
                Thread.sleep(300);
            }catch (InterruptedException e) {
                System.out.println("Erreur de thread" + Thread.currentThread().getName());
            }
        }

}
