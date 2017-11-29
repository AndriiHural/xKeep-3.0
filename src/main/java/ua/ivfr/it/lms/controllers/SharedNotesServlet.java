package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.dao.SharedNotesDao;
import ua.ivfr.it.lms.dao.SharedNotesDaoImp;
import ua.ivfr.it.lms.models.Note;
import ua.ivfr.it.lms.models.User;
import ua.ivfr.it.lms.views.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SharedNotesServlet", urlPatterns = {"/shared-notes"})
public class SharedNotesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        IndexView indexView = new IndexView();
       // indexView.outLogin(out);

        //switch (request.getPathInfo()) {
          //  case "/shared-notes":
                User user = (User) session.getAttribute("user");
               // Note note = (Note) session.getAttribute("notes");


        if (user != null) {
                    //створюємо об'єкт для роботи із базою даних
                    SharedNotesDao sharedNotesUserDao = new SharedNotesDaoImp();

                    //обробляємо отриманий набір об'єктів класу User через агрегатні операції
                    String row = sharedNotesUserDao.getNoteByUserId(user.getId()).stream()
                            //для кожного об'єкту класу User створюємо новий об'єкт класу String
                            .map(e -> "<div id=replaceID class=\"col-xs-4  col-md-3 col-lg-3 col-sm-12 \">\n" +
                                    "    <div class=\"bg-note-1 note-size remove-hover\">\n" +
                                    "        <a href=\"#\">\n" +
                                    "            <p>"+ e.toString()+"</p>\n" +
                                    "        </a>\n" +
                                    "\n" +
                                    "    </div>\n" +
                                    "</div>")
                            //об'єднуємо всі об'єкти класу String в один об'єкт
                            .collect(Collectors.joining(" "));


                    //виводимо в браузер інформацію у вигляді HTML
                    //TODO вивід потрібно зробити в класах пакету view (вигляд)
                    //indexView.doShareNotes(out);
                    out.println(row );
                   // indexView.doPostShareNotes(out);
                } else {
                    out.println("<h3>Ви не маєте доступу, будь-ласка, залогінтесь!</h3>");
                }
         //       break;
        }
    }
//}
