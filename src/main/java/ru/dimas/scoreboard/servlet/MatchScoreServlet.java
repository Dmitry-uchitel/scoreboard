package ru.dimas.scoreboard.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dimas.scoreboard.hibernate.HibernatePlayers;
import ru.dimas.scoreboard.model.Player;
import ru.dimas.scoreboard.repository.InitializationDataBase;
import ru.dimas.scoreboard.repository.PlayersDatabase;

import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "matchScoreServlet", value = "/match-score")
public class MatchScoreServlet extends HttpServlet {

//    public void init() throws ServletException {
//        // Инициализация Hibernate SessionFactory
//        InitializationDataBase.getSessionFactory();
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/match-score get");
//        response.setContentType("text/html");

//        String path = "/new-match.jsp";
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
//        requestDispatcher.forward(request, response);
        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/match-score post");
        HibernatePlayers.saveUser(request.getParameter("playerOne"));
        HibernatePlayers.saveUser(request.getParameter("playerTwo"));

        for (Player pl:HibernatePlayers.getUserList()){
            System.out.println(pl);
        }
//        Configuration configuration = new Configuration().addAnnotatedClass(Player.class);
//
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//
//        try {
//            session.beginTransaction();
//            Player player1 = new Player(request.getParameter("playerTwo"));
//            Player player2 = new Player(request.getParameter("playerTwo"));
//
//            session.persist(player1);
//            session.persist(player2);
//            session.getTransaction().commit();
//        }
//        finally {
//            sessionFactory.close();
//        }
        response.sendRedirect("match-score.jsp");

    }

}