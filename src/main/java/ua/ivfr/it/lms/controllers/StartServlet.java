package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import ua.ivfr.it.lms.views.PathHtmlSingleton;

@WebServlet(name = "StartServlet", urlPatterns = {"/"})
public class StartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if (user == null) {
            out.write("<H1>Ввійдіть або зареєструйтесь</H1>");
        }else {
            out.write("<h2>You "+user.toString()+"</h2>");
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        PathHtmlSingleton pathHTML = PathHtmlSingleton.getInstance();
        if (pathHTML.getPath().equals("")) {
            pathHTML.setPath(getServletContext().getRealPath("/html/"));
        }
        pathHTML.setTop("top.html");
        pathHTML.setMenu("menu.html");
        pathHTML.setMenu_login("menu_login.html");
        pathHTML.setBottom("bottom.html");
        pathHTML.setLogin("login.html");
        pathHTML.setRegistration("registration.html");
        pathHTML.setUser("user.html");
        pathHTML.setNote_page("notePage.html");
        pathHTML.setNote("note.html");
        System.out.println("Path\t" + pathHTML.getPath());
    }
}
