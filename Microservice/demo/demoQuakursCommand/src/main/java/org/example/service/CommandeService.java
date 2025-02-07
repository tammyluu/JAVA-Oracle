package org.example.service;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.entity.Command;
import org.example.repository.CommandRepository;

@ApplicationScoped
public class CommandeService {

    @Inject
    CommandRepository commandRepository;

    public Command getCommandById (long id) {
        return PanacheEntityBase.findById(id);
    }
}
