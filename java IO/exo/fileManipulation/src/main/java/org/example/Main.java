package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        String inputFilePath = "inputData.txt";
        String outputFilePath = "result.txt";

        String[] lines = {
                "Hello JAVA!",
                "Java is amazing.",
                "This line has no keyword.",
                "Learn java today!"
        };
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFilePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Fichier créé et texte écrit avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }

        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("java")) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        //write
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))){
            bw.write("Nombre de lignes contenant le mot 'Java' : " + count);
            System.out.println("Résultat écrit dans le fichier result.txt. ");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}