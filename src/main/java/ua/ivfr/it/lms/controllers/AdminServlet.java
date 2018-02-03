package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.dao.UserDaoImpl;
import ua.ivfr.it.lms.models.User;
import ua.ivfr.it.lms.views.AuxiliaryView;
import ua.ivfr.it.lms.views.IndexView;
import ua.ivfr.it.lms.views.UserView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin/*")
public class AdminServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        UserDaoImpl userDao = new UserDaoImpl();
        long id = Long.parseLong(request.getParameter("id"));

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        User user = new User();
        if (id != 0) {
            user = userDao.findUserByIdUser(id);
        }
        if (user != null)
            if (email.equals(user.getEmail()) && password.equals(user.getPassword()) && name.equals(user.getName())) {
                userDao.editRoleForId(user, id);
                response.sendRedirect("/admin");
            } else {
                userDao.editEmailPasswordNameForId(user, email, password, name);
                response.sendRedirect("/admin");
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        indexView.outAdmin(out);

        UserView userView = new UserView();
        UserDaoImpl userDao = new UserDaoImpl();
        userView.outUsertable(out, userDao.allUser());
        AuxiliaryView auxiliaryView = new AuxiliaryView();
        auxiliaryView.outCloseTable(out);

    }
}
