package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.dao.NoteDaoImpl;
import ua.ivfr.it.lms.dao.SharedNotesDao;
import ua.ivfr.it.lms.dao.SharedNotesDaoImp;
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

        String fieldNote = request.getParameter("fieldNote");
        User user = (User) session.getAttribute("user");
        Note note = null;

        switch (request.getPathInfo()) {
            case "/new":
                NoteDaoImpl noteDao = new NoteDaoImpl();
                // створення нової закладки при натисканні на кнопку New
                noteDao.UpdateNote(new Note(
                        0, fieldNote, "Title2",
                        0, null, "RED", (int) user.getId()
                ));
                response.sendRedirect("/note/");
                break;
            case "/edit":

                break;
            case "/shared":

                response.sendRedirect("/note/");
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


        switch (request.getPathInfo()) {
            case "/new":
                break;
            case "/edit":
                out.write("<H1>Edit Note!</H1>");
                Note editNote = new Note(2, "Edit", "Title2", 0, null, "RED", 1);
                Note n2 = note.UpdateNote(editNote);
                if (n2 != null) {
                    out.println(n2);
                } else {
                    out.println("Error Edit");
                }
                break;

            case "/delete":
                int id = Integer.parseInt(request.getParameter("id"));
                note.deleteNote(id);
                System.out.println(id);
                response.sendRedirect("/note/");
                break;
            case "/view":
                break;
            case "/shared":
                SharedNotesDaoImp sharedNotesDaoImp = new SharedNotesDaoImp();

                sharedNotesDaoImp.addSharedNote(new SharedNotes(9,1,1
                ));
                response.sendRedirect("/note/");
                break;
            default:
                Note_view note_view=new Note_view();
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");
                List<Note> notes = note.viewNotes((int) user.getId());
                note_view.outNotePage(out,notes);
                break;
        }
    }
}
