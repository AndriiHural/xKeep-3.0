package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.dao.SharedNotesDaoImp;
import ua.ivfr.it.lms.dao.UserDaoImpl;
import ua.ivfr.it.lms.models.User;
import ua.ivfr.it.lms.views.SharedNotesView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SharedNotesServlet", urlPatterns = {"/shared-notes/*"})
public class SharedNotesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        switch (request.getPathInfo()) {
            case "/edit":
                break;

            case "/delete":
                break;
            case "/view":
                break;
            default:
                response.sendRedirect("/shared-notes/");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        SharedNotesView sharedNotesView = new SharedNotesView();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        SharedNotesDaoImp sharedNotesDao = new SharedNotesDaoImp();
        UserDaoImpl userDao = new UserDaoImpl();
        if (user != null) {
            sharedNotesView.outPageNoteShare(out, user);
            //  userDao.fintUserById(user.getId());
        }
        switch (request.getPathInfo()) {
            case "/delete":
                int id = Integer.parseInt(request.getParameter("id"));
                sharedNotesDao.deleteShareNote(user.getId(), id);
                response.sendRedirect("/shared-notes/");
                break;
            default:

                break;
        }

    }
}

