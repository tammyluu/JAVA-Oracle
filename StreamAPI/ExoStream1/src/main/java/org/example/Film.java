package org.example;

public class Film {
    private String titre;
    private String genre;
    private int annee;
    private String auteur;
    private String date;

    // Constructeur
    public Film(String titre,String date, String auteur,String genre, int annee   ) {
        this.titre = titre;
        this.genre = genre;
        this.annee = annee;
        this.auteur = auteur;
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Film |" +
                "titre '" + titre + '\'' +
                "| genre '" + genre + '\'' +
                "| annee " + annee +
                "| auteur '" + auteur + '\'' +
                "| date '" + date + '\'' +
                '|';
    }
}

