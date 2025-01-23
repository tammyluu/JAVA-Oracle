### **Exercice 15 : Optimiser les performances avec des métriques**
**Contexte :**
Une API de gestion de tâches connaît des problèmes de performances sous forte charge. L’équipe veut surveiller les métriques pour identifier les goulots d’étranglement.

#### **Instructions** :
1. Implémentez un endpoint `GET /api/tasks/stream` qui:
    - Retourne un flux infini de tâches (simulées avec des noms "Task 1", "Task 2", ...).
    - Chaque élément est émis toutes les 500 ms.

2. Activez les métriques avec Spring Boot Actuator et configurez Prometheus pour surveiller:
    - Le nombre de requêtes HTTP.
    - La durée moyenne des requêtes HTTP.
    - Le nombre d'abonnements aux flux réactifs.

3. Ajoutez un pool de connexions dans `WebClient` pour limiter les ressources utilisées lors d'appels sortants.

#### **Critères de réussite** :
- Les métriques sont accessibles via `/actuator/metrics`.
- Le pool de connexions est correctement configuré et utilisé.