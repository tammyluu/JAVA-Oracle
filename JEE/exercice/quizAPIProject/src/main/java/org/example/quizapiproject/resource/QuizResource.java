package org.example.quizapiproject.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.quizapiproject.model.Quiz;
import org.example.quizapiproject.service.QuizService;

import java.util.List;

@Path("/quizzes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuizResource {

    private QuizService quizService;

    @Inject
    public QuizResource(QuizService quizService) {
        this.quizService = quizService;
    }


    @GET
    public List<Quiz> getAllQuizzes(){
        return quizService.getAllQuiz();
    }

    @GET
    @Path("/{id}")
    public Quiz getQuizById(@PathParam("id") Long id) {
        return quizService.getQuizById(id);
    }

    @POST
    public Response createQuiz(Quiz quiz) {
        Quiz newQuiz = quizService.addQuiz(quiz);
        return Response.status(Response.Status.CREATED).entity(newQuiz).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteQuiz(@PathParam("id") Long id) {
        quizService.deleteQuizById(id);
        return Response.noContent().build();
    }


}
