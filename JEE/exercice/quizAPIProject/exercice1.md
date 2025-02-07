# QuizAPIProject

## Sujet

### Objectif

Créer une API REST qui permet de :

1. **Ajouter des quiz** avec des questions et des options de réponse.
2. **Jouer à ces quiz** en soumettant des réponses.


### Exemple de Endpoints

| Méthode | Endpoint                     | Description                                                       |
|---------|------------------------------|-------------------------------------------------------------------|
| **POST**   | `/quizzes`                  | Ajouter un nouveau quiz avec ses questions et options.            |
| **GET**    | `/quizzes`                  | Récupérer la liste de tous les quiz.                              |
| **GET**    | `/quizzes/{id}`             | Récupérer un quiz spécifique avec toutes ses questions.           |
| **POST**   | `/quizzes/{id}/play`        | Jouer à un quiz en soumettant des réponses.                       |
| **GET**    | `/quizzes/{id}/results`     | Récupérer le score d’un joueur pour un quiz donné.                |
| **GET**    | `/players/{id}/history`     | Récupérer l'historique des parties jouées par un joueur donné.    |
| **DELETE** | `/quizzes/{id}`             | Supprimer un quiz et toutes ses questions associées.              |

### Instructions

1. Configurez un serveur Java EE compatible (WildFly, Payara...).
2. Déployez le projet et utilisez Postman pour tester les endpoints.