package mainApp;


import selectivePackage.House;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<House> houses;

    public static void main(String[] args) {

        houses = new ArrayList<House>(List.of(new House("maison 1","manoir")));

        for (House h : houses) {
            System.out.println(h);
        }

    }
}