package ru.dimas.scoreboard.servlet;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "newMatchServlet", value = "/new-match")
public class NewMatchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/new-match post");
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
        System.out.println("/new-match post");
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/match-score.jsp");
//        requestDispatcher.forward(request, response);

    }


}