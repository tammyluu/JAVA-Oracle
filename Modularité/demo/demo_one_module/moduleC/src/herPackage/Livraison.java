package herPackage;

public class Livraison {
    private String expediteur;
    private String Destinateur;

    public Livraison(String expediteur, String destinataire) {
        this.expediteur = expediteur;
        Destinateur = destinataire;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getDestinateur() {
        return Destinateur;
    }

    public void setDestinateur(String destinateur) {
        Destinateur = destinateur;
    }

    @Override
    public String toString() {
        return "Livraison{" +
                "expediteur='" + expediteur + '\'' +
                ", Destinateur='" + Destinateur + '\'' +
                '}';
    }
}
