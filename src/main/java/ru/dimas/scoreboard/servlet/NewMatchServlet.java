package ru.dimas.scoreboard.servlet;

import ru.dimas.scoreboard.hibernate.HibernateMatchResult;
import ru.dimas.scoreboard.hibernate.HibernatePlayers;
import ru.dimas.scoreboard.model.MatchScore;
import ru.dimas.scoreboard.model.Matches;
import ru.dimas.scoreboard.model.Player;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "newMatchServlet", value = "/NewMatchServlet")
public class NewMatchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/new-match get");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/new-match post");

        String nameOne = request.getParameter("playerOne");
        String nameTwo = request.getParameter("playerTwo");
        HibernatePlayers.savePlayer(nameOne);
        HibernatePlayers.savePlayer(nameTwo);
        MatchScore matchScore = new MatchScore(nameOne, nameTwo);
        Integer ID = Matches.addNewMatch(matchScore);

        response.sendRedirect("match-score");



    }
}