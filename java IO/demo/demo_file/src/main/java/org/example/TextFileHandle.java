package org.example;

import java.io.*;

public class TextFileHandle {

    public void demoTextFileOperation(){
        System.out.println("This is a demo text file operations");
        String filePath = "demo.txt";

        // Ecriture . Il va créer un fichier à la racine du projet
        try (BufferedWriter writer =new BufferedWriter(new FileWriter(filePath))){
            writer.write("Ligne 1 : Hello World !!!\n");
            writer.write("Ligne 2 : Welcome to java !!! ");

        }catch (IOException e){
            e.printStackTrace();
        }

        //Lecture
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
           while ((line = reader.readLine()) != null){
               System.out.println("Lign lue : " + line);
           }

        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
