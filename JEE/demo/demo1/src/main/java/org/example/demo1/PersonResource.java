package org.example.demo1;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonService personService;

    @Inject
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }
    //http://localhost:8080/demo1_war_exploded/api/person
    @GET
    public Person getPerson() {
        return new Person("toto", 42, 11);
    }

    //http://localhost:8080/demo1_war_exploded/api/person/user
    @GET
    @Path("/user")
    public Person getPersonService() {
        return personService.save(12,"tata", 18);
    }

    //http://localhost:8080/demo1_war_exploded/api/person/user2?id=15&name=titi&age=99
    @GET
    @Path("/user2")
    public Person getPersonService2(@QueryParam("id") int id,
                                    @QueryParam("name") String name,
                                    @QueryParam("age")int age) {
        return personService.save(id,name,age);
    }

    @POST
    public Person createPerson(Person person) {
        return person;
    }

    @PUT
    @Path("{name}")
    public Person updatePerson(@PathParam("name") String name) {
        return new Person(name, 42, 11);
    }


}
