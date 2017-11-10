package ua.ivfr.it.lms.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NoteServlet",urlPatterns = {"/note/*"})
public class NoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        switch (request.getPathInfo()) {
            case "/new":
                out.write("<H1>New Note!</H1>");
                break;
            case "/edit":
                out.write("<H1>Edit Note!</H1>");
                break;

            case "/delete":
                out.write("<H1>Delete Note!</H1>");
                break;
            case "/view":
                out.write("<H1>View Note!</H1>");
                break;
        }

    }
}
