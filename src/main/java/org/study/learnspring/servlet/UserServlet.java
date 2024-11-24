package org.study.learnspring.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user", name = "userServlet")
public class UserServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) {
        System.out.println("UserServlet.init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setHeader("hitCount", (String) req.getAttribute("hitCount"));
        res.setHeader("user", "admin");
        PrintWriter writer = res.getWriter();
        writer.print("username=hi");
        writer.flush();
        writer.close();
    }

    @Override
    public void destroy() {
        System.out.println("UserServlet.destroy");
    }
}
