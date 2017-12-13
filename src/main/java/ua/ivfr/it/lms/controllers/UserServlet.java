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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        UserDaoImpl userDao =new UserDaoImpl();
        User user = (User) session.getAttribute("user");

        String name = request.getParameter("inputName");
        String password = request.getParameter("inputPassword");
        String passwordNew = request.getParameter("inputPasswordNew");
        String passwordNew2 = request.getParameter("inputPasswordNew2");

        if(name!=null){
            userDao.editNameUser(user.getEmail(),name);
            user.setName(name);
        }

        if(password!=null&&passwordNew!=null&&passwordNew.equals(passwordNew2)){
            userDao.editPasswordUser(user,password,passwordNew);
            out.write("<H1>Пароль змінено</H1>");
            user.setPassword(passwordNew);
        }
        else{}

        response.sendRedirect("/user/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        out.write("<h2>Ваше ім'я: "+user.getName()+"</h2>");
        out.write("<h2>Ваш email: "+user.getEmail()+"</h2>");


        IndexView indexView = new IndexView();
        UserDaoImpl userDao=new UserDaoImpl();
        indexView.outUser(out);

        switch (request.getPathInfo()) {
            case"/edit/password":
                out.write("<H1>kffhk</H1>");
                break;
            case "/delete":
                userDao.deleteUser(user.getEmail());
                session.removeValue("user");
                response.sendRedirect("/");
                break;
            case "/out":
                session.removeValue("user");
                response.sendRedirect("/");
                break;
        }

    }
}
