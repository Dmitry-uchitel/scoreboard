package ru.dimas.scoreboard.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dimas.scoreboard.hibernate.HibernatePlayers;
import ru.dimas.scoreboard.model.MatchScore;
import ru.dimas.scoreboard.model.Matches;
import ru.dimas.scoreboard.model.Player;
import ru.dimas.scoreboard.model.Point;

import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "selectGameServlet", value = "/selectGameServlet")
public class SelectGameServlet extends HttpServlet {

//    public void init() throws ServletException {
//        // Инициализация Hibernate SessionFactory
//        InitializationDataBase.getSessionFactory();
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/matchScoreServlet get");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("selectGameServlet post");

        Integer selectedID = Integer.parseInt(request.getParameter("dropdown"));
        Matches.setSelectedUUID(selectedID);

        response.sendRedirect("/match-score.jsp");


    }

}
