package org.example.exo21;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class VirtualThreadServer {
    public static void main(String[] args) {
           int maxConnections = 1000;
           try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
               System.out.println("Simulation en cours avec " + maxConnections + " connections virtuelles ") ;
               for (int i = 0; i < maxConnections; i++) {
                   int connectedId = i;
                   executor.execute(() -> simulateServer(connectedId));
               }

           }
        System.out.println("Toutes les connexion ont éte simulérs. ");
    }
    private  static  void  simulateServer(int connectionId){

        try {
            System.out.println("Connecxion "  + connectionId + " démarrée");
            Thread.sleep(2000);
            System.out.println("Réponse envoyée pour la connexion: " + connectionId );
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
