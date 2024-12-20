package yourApp;
import herPackage.Livraison;
import yourPackage.Cadeaux;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Cadeaux> cadeau = new ArrayList<Cadeaux>();
    private static List<Livraison> livraisons = new ArrayList<Livraison>();

    public static void main(String[] args) {

        cadeau = new ArrayList(List.of(new Cadeaux("Livre", " etudes"), new Cadeaux("Iphone ", "Communication")));
        for (Cadeaux c : cadeau) {
            System.out.println(c);
        }

        livraisons = new ArrayList(List.of(new Livraison("Toto", "Tata"), new Livraison("Bob", "Bobby")));
        for (Livraison l : livraisons) {
            System.out.println(l);
        }
    }
}
