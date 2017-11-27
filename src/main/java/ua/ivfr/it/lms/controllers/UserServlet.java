package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.dao.UserDaoImpl;
import ua.ivfr.it.lms.models.User;
import ua.ivfr.it.lms.views.IndexView;
import ua.ivfr.it.lms.views.UserView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

@WebServlet(name = "UserServlet", urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        out.write("<h2>Ваше ім'я: "+user.getName()+"</h2>");;
        out.write("<h2>Ваш email: "+user.getEmail()+"</h2>");;


        IndexView indexView = new IndexView();
        UserDaoImpl userDao=new UserDaoImpl();


        switch (request.getPathInfo()) {
            case "/new":
                out.write("<H1>New User!</H1>");
                break;
            case "/edit":
                out.write("<H1>Edit User!</H1>");
                break;
            case "/delete":
                out.write("<H1>Delete User!</H1>");
                break;
            case "/view":
                out.write("<H1>"+userDao.allUser()+"</H1>");
                break;
            case "/seach":
                out.write("<H1>"+userDao.findUserByEmail("sasha19970808@com.ua")+"</H1>");
                break;
            case "/out":
                session.removeValue("user");
                response.sendRedirect("/");
                break;
        }

    }
}
