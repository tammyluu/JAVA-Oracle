package org.example.exo23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Panier {

        private final List<Article> articles = Collections.synchronizedList(new ArrayList<>());

        public void addArticle(Article article) {
            articles.add(article);
        }

        public List<Article> getArticles() {
            return new ArrayList<>(articles);
        }

}
