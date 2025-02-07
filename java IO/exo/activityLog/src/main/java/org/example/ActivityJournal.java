package org.example;

import javax.imageio.IIOException;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ActivityJournal {

    public static final String TEXT_FILE = "journal.txt";
    public static final String BINARY_FILE = "journal_backup.dat";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static Scanner sc = new Scanner(System.in);

    public static void checkFileIsExisted (String filePath){
        File file = new File(filePath);
        try {
            if (!file.exists()){
                file.createNewFile();
                System.out.println( filePath + " : this file was created");
            }
        }catch (IOException e){
            System.out.println("File could not be created: " + filePath);
        }
    }

    public static  void  addActivity (){
        System.out.print("Entrez une description de l'activité : ");
        String activity = sc.nextLine();
        String time = LocalDateTime.now().format(DATE_FORMATTER);
        String entry = time + " - " + activity;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEXT_FILE, true))){
            writer.write(entry);
            writer.newLine();
            System.out.println("Activité ajoutée avec succès!");

        } catch (IOException e) {
            System.out.println("Erreur lors de l'ajout de l'activité: " + e.getMessage());
        }
    }

    public static void showActivities() {
        System.out.println("\n----- Journal des Activités ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des activités : " + e.getMessage());
        }
    }

    public static void saveToBinaryFile() {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE));

                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(BINARY_FILE))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {

                bos.write(line.getBytes());
                bos.write("\n".getBytes());
                System.out.println("Journal sauvegardé en binaire dans : " + BINARY_FILE);
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de sauvegarde en binaire : " + e.getMessage());
        }
    }


    public static void readFromBinaryFile() {
        System.out.println("\n---------- Contenu du Fichier Binaire ----------------");
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(BINARY_FILE))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                String content = new String(buffer, 0, bytesRead);
                System.out.print(content);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier binaire : " + e.getMessage());
        }
    }




}
