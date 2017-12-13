package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.dao.UserDaoImpl;
import ua.ivfr.it.lms.models.User;
import ua.ivfr.it.lms.views.IndexView;
import ua.ivfr.it.lms.views.ViewLoginServlet;
import ua.ivfr.it.lms.views.ViewStartServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        String email = request.getParameter("emailLogin");
        String password = request.getParameter("loginPassword");


        HttpSession session = request.getSession();
        UserDaoImpl userDao = new UserDaoImpl();

        User user = userDao.findUserByEmailPassword(email,password);
        //якщо емейл є в БД, змінна user буде посилатись на об'єкт класу User, інакше дорівнюватиме null
        if(user != null) {
            //записав об'єкт користувача в сесію, щоб перевіряти в інших сервлетах чи зареєстрований користувач
            session.setAttribute("user", user);
            out.write("<div class=\"panel panel-default\">\n" +
                    "  <!-- Default panel contents -->\n" +
                    "  <div class=\"panel-heading\">Заголовок панелі</div>\n" +
                    "\n" +
                    "  <!-- Table -->\n" +
                    "  <table class=\"table\">\n" +
                    "    <tr>\n" +
                    "    <th>Firstname</th>\n" +
                    "    <th>Lastname</th> \n" +
                    "    <th>Age</th>\n" +
                    "  </tr>\n" +
                    "  </table>\n" +
                    "</div>");
            response.sendRedirect("/note/");
        }
        else {
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        indexView.outLogin(out);
    }
}
