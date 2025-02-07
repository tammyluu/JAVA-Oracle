package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
      // pour les fichiers texte
      /*  TextFileHandle textFileHandle = new TextFileHandle();
        textFileHandle.demoTextFileOperation();*/

        // pour les fichiers binaires

        BinaryFileHandler bfh = new BinaryFileHandler();
        bfh.demoBinaryFileOperations();
    }
}