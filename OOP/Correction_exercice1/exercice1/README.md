
# Liste de Contacts

## Description

Cette application console en Java permet de gérer une liste de contacts. Elle a été développée en réponse au sujet disponible ici :  
- [Sujet](./sujet.md)

## Prérequis

Pour tester cette application Java, il est recommandé d'avoir :  
- Le JDK 21 installé : [Télécharger JDK 21](https://www.oracle.com/fr/java/technologies/downloads/#java21)

## Code source de l'application

Le code source est disponible dans le dossier `src`.

## Compilation et exécution de l'application

### Compilation (bytecode)

Pour compiler l'application, placez-vous au même niveau que le dossier `src`, puis exécutez la commande suivante :  
```bash
javac -d bin src/*.java
```

### Exécution

Une fois la compilation terminée, testez l'application avec la commande :  
```bash
java -cp bin Main
```

## Création d'un fichier JAR

### Préparation du fichier `MANIFEST.MF`

Créez un fichier `MANIFEST.MF` contenant la classe principale de l'application (point d'entrée). Exemple :  
```plaintext
Main-Class: Main
```

⚠️ **N'oubliez pas de terminer ce fichier par un saut de ligne**.

### Création de l'archive JAR

Pour générer l'archive JAR, exécutez la commande suivante :  
```bash
jar cfm contactList.jar ./src/MANIFEST.MF -C bin .
```

### Vérification du contenu du JAR

Vous pouvez vérifier le contenu du fichier JAR avec la commande suivante :  
```bash
jar tf contactList.jar
```

### Test du fichier JAR

Pour exécuter le fichier JAR :  
```bash
java -jar contactList.jar
```

## Utilisation du JAR dans un autre projet

Vous pouvez utiliser le fichier JAR dans un autre projet. Placez le fichier `contactList.jar` à la racine du projet, puis utilisez les classes `Person` et `Directory`.  

### Exemple d'utilisation

Structure d'exemple :  
- Dossier : `otherProject`  
- Fichier : `TestDirectory.java`

### Compilation et exécution avec le fichier JAR

Compilez et exécutez le fichier en spécifiant le JAR dans le classpath :  
```bash
javac -cp .\contactList.jar .\TestDirectory.java
java -cp "contactList.jar;." TestDirectory
```
