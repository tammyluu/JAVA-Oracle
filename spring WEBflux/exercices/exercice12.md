### **Exercice 12 : Gestion d'erreurs dans une API de gestion d'inventaire**

**Contexte** :  
Une entreprise de commerce en ligne souhaite une API réactive pour gérer son inventaire. Chaque produit a un identifiant unique, un nom, une quantité et un prix.

---

#### **Instructions** :

1. **Créer un endpoint `GET /api/inventory/{id}`** :
   - Retourne les détails d’un produit donné (exemple de réponse: `{ "id": 1, "name": "Laptop", "quantity": 5, "price": 1200.50 }`).
   - Retourne une erreur HTTP si le produit n’existe pas, sans message personnalisé.

2. **Créer un endpoint `POST /api/inventory`** :
   - Ajoute un nouveau produit.
   - Retourne une erreur HTTP si les données fournies sont invalides (exemple : nom manquant ou prix négatif).

3. **Créer un endpoint `GET /api/inventory/price/{maxPrice}`** :
   - Retourne tous les produits dont le prix est inférieur ou égal au `maxPrice`.
   - Si `maxPrice` est négatif, déclenche une erreur HTTP capturée par le gestionnaire global

4. **Implémenter un gestionnaire d’erreurs global avec `ErrorWebExceptionHandler`** :
   - Gérer toutes les erreurs non prévues et renvoyer une réponse HTTP 500 avec un message générique.
