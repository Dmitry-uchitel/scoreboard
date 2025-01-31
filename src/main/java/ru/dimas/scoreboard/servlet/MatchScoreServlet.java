package ru.dimas.scoreboard.servlet;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dimas.scoreboard.hibernate.HibernateMatchResult;
import ru.dimas.scoreboard.hibernate.HibernatePlayers;
import ru.dimas.scoreboard.model.*;

import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "matchScoreServlet", value = "/matchScoreServlet")
public class MatchScoreServlet extends HttpServlet {

//    public void init() throws ServletException {
//        // Инициализация Hibernate SessionFactory
//        InitializationDataBase.getSessionFactory();
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/matchScoreServlet get");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/matchScoreServlet post");
        String nameOne = request.getParameter("playerOne");
        String nameTwo = request.getParameter("playerTwo");

        Integer UUID = Matches.getSelectedUUID();
        System.out.println(UUID);
        if (Matches.getMatchScoreMap().get(UUID)==null){
            response.sendRedirect("/matches");
            return;
        }
        if (!(nameOne==null)){
            Matches.getMatchScoreMap().get(UUID).matchStep(Point.ONE);
        }
        if (!(nameTwo==null)){
            Matches.getMatchScoreMap().get(UUID).matchStep(Point.TWO);
        }
        if (Matches.getMatchScoreMap().get(UUID).getEndMatch()){
            HibernateMatchResult.saveSelectedMatchResult(nameOne);
            if (Matches.getMatchScoreMap()!=null){
                for (Integer ID:Matches.getMatchScoreMap().keySet()){
                    Matches.setSelectedUUID(ID);
                    break;
                }
            }
            else {
                response.sendRedirect("/");
                return;
            }
            response.sendRedirect("/matches");
            return;
        }
        response.sendRedirect("/match-score");
    }
}