### **Création d'une application console en Java pour gérer des contacts**

---

#### **Objectif**
Créer une application Java de type console permettant de gérer une liste de contacts. Cette application devra être conçue pour être utilisée sans outil d'assistance comme un IDE (ex. : IntelliJ IDEA, Eclipse). L'objectif est de travailler avec un simple éditeur de texte et les outils de compilation et d'exécution de Java, tout en produisant un programme structuré, prêt à être distribué et réutilisé.

---

#### **Spécifications de l'application**
1. **Fonctionnalités de base** :
   - L'application doit permettre d'ajouter, de lister et de rechercher des contacts.
   - Chaque contact doit comporter au minimum un nom et un numéro de téléphone.

2. **Structure des classes** :
   - **`Personne`** : Une classe représentant un contact, avec ses attributs (nom, numéro de téléphone) et les méthodes nécessaires (accesseurs, modificateurs, etc.).
   - **`Annuaire`** : Une classe qui gère une collection de contacts, avec des méthodes pour ajouter, lister et rechercher des contacts.

3. **Interactivité** :
   - L'utilisateur doit pouvoir interagir avec l'application via des options présentées dans la console. Par exemple :
     ```
     1. Ajouter un contact
     2. Lister les contacts
     3. Quitter
     ```
   - Un simple choix de numéro doit déclencher la fonctionnalité correspondante.

4. **Réutilisabilité** :
   - Les classes `Personnne` et `Annuaire` doivent être conçues de manière à pouvoir être utilisées dans d'autres applications. Cela implique que leur code doit être autonome et bien structuré.
   - Un second programme doit exploiter directement les classes Personne et Annuaire packagées pour implémenter les fonctionnalités décrites ci-dessus.

---

#### **Exigences supplémentaires**
- Le programme devra être compilé et exécuté en ligne de commande, sans utiliser d'environnement de développement intégré (IDE). Cela inclut l'utilisation d'outils de base fournis avec Java.
- Une fois l'application fonctionnelle, elle devra être packagée de manière à pouvoir être facilement partagée et utilisée par d'autres.
- Documentez les étapes nécessaires à l'exécution de l'application une fois terminée, comme si elle devait être utilisée par une personne sans connaissance approfondie de Java.

---

#### **Livrables**
1. **Code source** : Toutes les classes nécessaires (`Personne`, `Annuaire`, etc.) au fonctionnement de l'application.
2. **Instructions** : Une documentation claire expliquant comment compiler, exécuter et utiliser le programme.
3. (Optionnel) Un fichier contenant quelques exemples de contacts pour tester facilement l'application.

---

#### **Consignes particulières**
1. Essayez de réaliser cet exercice avec un simple éditeur de texte et en utilisant uniquement les outils fournis par le JDK.
2. Limitez autant que possible l'utilisation de logiciels ou d'extensions qui automatisent la compilation ou l'exécution.
3. La structure du code et la documentation doivent refléter une approche professionnelle, comme si ce programme devait être distribué à d'autres utilisateurs.

---

#### **Objectif pédagogique**
- Comprendre et appliquer les bases de la programmation orientée objet (POO) en Java.
- Manipuler les outils fondamentaux du langage Java, comme la compilation et l'exécution en ligne de commande.
- Concevoir un programme réutilisable, prêt pour une intégration ou une distribution. 

Bon courage !