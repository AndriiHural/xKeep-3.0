package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.dao.NoteDaoImpl;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NoteServlet", urlPatterns = {"/note/*"})
public class NoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String fieldNote = request.getParameter("fieldNote");
        User user = (User) session.getAttribute("user");

        NoteDaoImpl noteDao = new NoteDaoImpl();
        // створення нової закладки при натисканні на кнопку New
        noteDao.UpdateNote(new Note(
                0, fieldNote, "Title2",
                0, null, "RED", (int) user.getId()
                ));
        response.sendRedirect("/note/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        NoteDaoImpl note = new NoteDaoImpl();

        switch (request.getPathInfo()) {
            case "/new":
                out.write("<H1>New Note!</H1>");
                Note newNote = new Note(0, "New", "Title2", 0, null, "RED", 2);
                Note n = note.UpdateNote(newNote);
                if (n != null) {
                    out.println(n);
                } else {
                    out.println("Error New");
                }
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
                int id= Integer.parseInt(request.getParameter("id"));
                note.deleteNote(id);
                response.sendRedirect("/note/");
                break;
            case "/view":
                out.write("<H1>View Note!</H1>");
//                Note note_view=note.viewNote(1);
//                if(note_view!=null){
//                    out.println("<H2>"+note_view+"</H2>");
//                }else {
//                    out.println("Error View");
//                }
                break;
            default:
                IndexView indexView = new IndexView();


                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");
                List<Note> notes = note.viewNote((int) user.getId());

                indexView.outNotePage(out, notes);
                break;
        }
    }
}
