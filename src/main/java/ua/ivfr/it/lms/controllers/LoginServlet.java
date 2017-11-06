package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.views.ViewLoginServlet;
import ua.ivfr.it.lms.views.ViewStartServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println(ViewStartServlet.getTopPage());
            out.println(ViewStartServlet.getMenu());
            out.println(ViewLoginServlet.getLogin());

            out.write("<H1></H1>");
            out.println(ViewStartServlet.getBootomPage());
            ;
        } finally {
            out.close();
        }
    }
}