package org.example.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.example.entity.Command;


@Path("api/command")
public class CommandController {


    @GET
    @Path("/{id}")
    public Command getCommand(@PathParam("id") long id) {

    }
}
