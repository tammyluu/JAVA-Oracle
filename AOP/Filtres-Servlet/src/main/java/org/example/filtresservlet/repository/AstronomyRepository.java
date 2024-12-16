package org.example.filtresservlet.repository;

import org.example.filtresservlet.model.Astronomy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AstronomyRepository {
    private  List<Astronomy> list = new ArrayList<>();
    public AstronomyRepository() {
        list.add(new Astronomy(1, "Jupiter"));
        list.add(new Astronomy(2, "Mars"));
        list.add(new Astronomy(3, "Saturn"));
        list.add(new Astronomy(4, "Uranus"));
        list.add(new Astronomy(5, "Neptune"));
        list.add(new Astronomy(6, "Earth"));
        list.add(new Astronomy(7, "Mercury"));

    }
    public List<Astronomy> getAll() {
        return list;
    }
    public Astronomy getAstronomyById(int id) {
        return list.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
        }
    public void addAstronomy(Astronomy astronomy) {
        list.add(astronomy);
    }
}
