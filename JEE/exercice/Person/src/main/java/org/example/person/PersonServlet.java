package org.example.person;

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

    private  List<Person>persons;

    @Override
    public void init() throws ServletException {
        persons = new ArrayList<>();
        persons.add(new Person("Lady", "Gaga", 46));
        persons.add(new Person("Julia", "Robert", 54));
        persons.add(new Person("Mary", "Smith", 32));
        System.out.println("passage par la methode init: ......");
    }

      protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          System.out.println("passage par la methode doGet: ......");

            // (key, obj)
          req.setAttribute("persons", persons);

        // Transférer la requête vers la page JSP :
          // ("index.jsp")corresponds le dossier à la racine webapp,
          // .forward : passe intermédiare
        //req.getRequestDispatcher("index.jsp").forward(req,res);
          getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);

    }

}
