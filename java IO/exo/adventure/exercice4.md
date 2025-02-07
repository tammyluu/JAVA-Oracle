## **Exercice : Aventure Textuelle avec Sérialisation**

### **Objectif**
Créer un jeu textuel où :
1. Les personnages sont sérialisés et enregistrés dans des fichiers binaires.
2. Les péripéties et façons de les surmonter sont définies dans un fichier texte facile à modifier.
3. L'utilisateur crée son personnage et parcourt une aventure basée sur des choix et des événements aléatoires.
4. À la fin de la partie, un journal des événements est généré dans un fichier texte pour raconter l'histoire.

---

### **Spécifications**
1. **Création de personnages et monstres** :
    - Les personnages et monstres sont des objets sérialisables avec des propriétés comme `nom`, `force`, `santé`.
    - Ils sont enregistrés dans des fichiers binaires (`characters.dat` pour les personnages, `monsters.txt` pour les monstres).
2. **Fichier des péripéties** :
    - Un fichier texte (`events.txt`) contient une liste de péripéties.
    - Chaque ligne représente un événement aléatoire qui peut survenir.
3. **Mécanique de jeu** :
    - L'utilisateur choisit ou crée un personnage.
    - Le jeu génère aléatoirement des événements.
    - Les résultats des choix sont déterminés par des calculs simples (par exemple, la force du joueur contre celle d’un monstre).
4. **Journal de l’aventure** :
    - À la fin de la partie, un fichier texte (`journal.txt`) est généré pour résumer l’aventure du joueur.

---

### **Exemple de Résultat Attendu**
```plaintext
--- Bienvenue dans le jeu d'aventure textuelle ! ---
1. Créer un nouveau personnage
2. Charger un personnage existant
Choisissez une option : 1

Entrez le nom de votre héros : Aragon
Entrez la force (1-100) : 80
Entrez la santé (1-100) : 90
Personnage créé avec succès et sauvegardé.

--- Début de l'aventure ---
Événement : Vous rencontrez un monstre dans la forêt.
Action : Combat
Résultat : Vous avez battu le monstre !

Événement : Vous trouvez un coffre mystérieux.
Action : Ouvrir
Résultat : Le coffre était piégé ! Vous perdez 10 points de santé.

--- Fin de l'aventure ---
Votre santé restante : 80
Un journal de votre aventure a été généré : journal.txt
```
