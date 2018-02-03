package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.dao.NoteDaoImpl;
import ua.ivfr.it.lms.dao.SharedNotesDao;
import ua.ivfr.it.lms.dao.SharedNotesDaoImp;
import ua.ivfr.it.lms.dao.UserDaoImpl;
import ua.ivfr.it.lms.models.Note;
import ua.ivfr.it.lms.models.SharedNotes;
import ua.ivfr.it.lms.models.User;
import ua.ivfr.it.lms.views.IndexView;
import ua.ivfr.it.lms.views.Note_view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NoteServlet", urlPatterns = {"/note/*"})
public class NoteServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();


        String email = request.getParameter("email");
        long note_id = Long.parseLong(request.getParameter("note_id"));


        User user = (User) session.getAttribute("user");
        System.out.println("NoteServlet POST\t" + request.getPathInfo());
        NoteDaoImpl noteDao = new NoteDaoImpl();
        switch (request.getPathInfo()) {
            case "/new":

                break;
            case "/edit":
                // створення нової закладки при натисканні на кнопку New
                System.out.println("NoteServlet edit");
                int id = Integer.parseInt(request.getParameter("id"));
                String noteText = request.getParameter("noteText");
                String title = request.getParameter("title");
                System.out.println("NoteServlet edit\t" + id + "\t" + noteText + "\t" + title);
                noteDao.UpdateNote(new Note(
                        id, noteText, title, 0, null, "RED", (int) user.getId()
                ));
                response.sendRedirect("/note/");
                break;
            case "/shared":
                if (email != null) {
                    SharedNotesDaoImp sharedNotesDaoImp = new SharedNotesDaoImp();
                    UserDaoImpl userDao = new UserDaoImpl();
                    sharedNotesDaoImp.addSharedNote(note_id, userDao.findUserByEmail(email));
                    response.sendRedirect("/note/");
                }
                break;
            case "/delete":
                break;
            case "/view":
                break;
            default:
                response.sendRedirect("/note/");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        NoteDaoImpl note = new NoteDaoImpl();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String fieldNote = request.getParameter("fieldNote");
        System.out.println("NoteServlet GET\t" + request.getPathInfo());
        switch (request.getPathInfo()) {
            case "/new":
                // створення нової закладки при натисканні на кнопку New

                System.out.println("NoteServlet new\t" + request.getPathInfo());
                note.UpdateNote(new Note(
                        0, fieldNote, "Title2",
                        0, null, "RED", (int) user.getId()
                ));
                response.sendRedirect("/note/");
                break;
            case "/edit":
                System.out.println("NoteServlet edit");
                int id = Integer.parseInt(request.getParameter("id"));
                String noteText = request.getParameter("noteText");
                String title = request.getParameter("title");
                System.out.println("NoteServlet edit\t" + id + "\t" + noteText + "\t" + title);
                note.UpdateNote(new Note(
                        id, noteText, title, 0, null, "RED", (int) user.getId()
                ));
                response.sendRedirect("/note/");
                break;

            case "/delete":
                int id_del = Integer.parseInt(request.getParameter("id"));
                note.deleteNote(id_del);
                response.sendRedirect("/note/");
                break;
            case "/view":
                break;
            case "/shared":

                break;
            default:
                Note_view note_view = new Note_view();
                List<Note> notes = note.viewNotes((int) user.getId());
                note_view.outNotePage(out, notes);
                break;
        }
    }
}
