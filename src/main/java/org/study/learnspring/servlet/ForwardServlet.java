package org.study.learnspring.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/forward", name = "forwardServlet")
public class ForwardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getServletContext()
            .getRequestDispatcher("/user");
        requestDispatcher.forward(req, res);
    }
}
