package org.example.personjsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/person")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Lady", "Gaga", 46));
        persons.add(new Person("Julia", "Robert", 54));
        persons.add(new Person("Mary", "Smith", 32));
        req.setAttribute("persons", persons);

        // Transférer la requête vers la page JSP
        req.getRequestDispatcher("/index.jsp").forward(req,res);

    }

}
