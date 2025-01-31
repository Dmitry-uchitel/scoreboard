package ru.dimas.scoreboard.servlet;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "matchesServlet", value = "/matchesServlet")
public class MatchesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/matches get");
//        System.out.println(request.getParameter("playerName"));

        if (request.getParameter("playerName").equals("") || request.getParameter("playerName").isEmpty()){

        }






    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/matches post");
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/match-score.jsp");
//        requestDispatcher.forward(request, response);

    }

}