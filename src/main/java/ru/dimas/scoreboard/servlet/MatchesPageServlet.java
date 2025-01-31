package ru.dimas.scoreboard.servlet;

import ru.dimas.scoreboard.hibernate.HibernateMatchResult;
import ru.dimas.scoreboard.model.Matches;
import ru.dimas.scoreboard.model.Point;
import ru.dimas.scoreboard.service.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "matchesPageServlet", value = "/matchesPageServlet")
public class MatchesPageServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/matchesPageServlet get");
        Pagination.setCurrentPage(Integer.parseInt(request.getParameter("page")));
        response.sendRedirect("/matches");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/matchesPageServlet post");


    }
}


