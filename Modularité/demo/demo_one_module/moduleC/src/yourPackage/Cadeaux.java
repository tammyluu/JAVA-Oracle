package yourPackage;

public class Cadeaux {
    private String titre;
    private String description;

    public Cadeaux(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cadeaux{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
