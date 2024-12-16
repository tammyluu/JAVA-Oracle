package org.example.filtresservlet.controller;

import org.example.filtresservlet.model.Astronomy;
import org.example.filtresservlet.model.Observation;
import org.example.filtresservlet.repository.AstronomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/astronomy")
public class AstronomyController {

    @Autowired
    private AstronomyRepository repository;

    private List<Astronomy> astronomies = new ArrayList<Astronomy>();
    private List<Observation> obs = new ArrayList<>();
    @GetMapping("/list")
    public List<Astronomy> getAllAstronomy() {
        return repository.getAll();
    }

    @PostMapping("/add")
    public Observation addAstronomy(@RequestBody Observation observation) {
        obs.add(observation);
        return observation;

    }

    @GetMapping("/search")
    public List<Observation> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "-1") Integer date,
            @RequestParam(required = false) String username) {

        return obs.stream()
                .filter(obs -> (name == null || obs.getUsername().equalsIgnoreCase(name)) &&
                        (date == -1 || obs.getDate().equals(date)) &&
                        (username == null || obs.getUsername().equalsIgnoreCase(username)))
                .toList();
    }


}
