package org.example;

import java.io.*;

public class BinaryFileHandler {

    public void demoBinaryFileOperations(){
        System.out.println("Demo Binary File Operations");
        String srcFilePath = "source.dat";
        String destFilePath = "dest.dat";

        // création du fichier binaire
        try (FileOutputStream out = new FileOutputStream(srcFilePath)){
            out.write(new byte[]{1,2,3,4,5,6,7,8,9});
            System.out.println("Fichier bianire crée !!!!");

        }catch (IOException e){
            e.printStackTrace();
        }

        // copie du fichier binaire
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFilePath));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destFilePath))){
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1){
                out.write(buffer, 0, bytesRead);
            }
        }catch (IOException e){
            // e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }
}
