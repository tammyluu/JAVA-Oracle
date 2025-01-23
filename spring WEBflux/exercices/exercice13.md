### **Exercice 13 : Validation de flux réactifs avec `StepVerifier`**
**Contexte :**
Une société de streaming audio souhaite valider le comportement de son service qui génère des playlists de manière réactive.

#### **Instructions** :
1. Implémentez un service réactif `PlaylistService` qui:
    - Retourne un flux de titres pour une playlist:
      ```java
      Flux<String> getPlaylist(String genre);
      ```
      Exemple de genres et titres :
        - `rock` : ["Bohemian Rhapsody", "Hotel California", "Stairway to Heaven"].
        - `pop` : ["Thriller", "Like a Virgin", "Billie Jean"].
        - Pour un genre non supporté, renvoie une erreur `IllegalArgumentException`.

2. Écrivez des tests avec `StepVerifier` pour valider:
    - Que la playlist correspond au genre demandé.
    - Que le flux se termine correctement (`verifyComplete`).
    - Que l’erreur est correctement générée pour un genre non supporté.

#### **Critères de réussite** :
- Tests avec plusieurs genres valides.
- Test de gestion d’erreur pour un genre non valide.