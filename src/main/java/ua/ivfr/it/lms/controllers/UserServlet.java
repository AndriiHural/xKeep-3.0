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
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        indexView.outUser(out);
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
        }

    }
}
