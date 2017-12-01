package ua.ivfr.it.lms.views;

import ua.ivfr.it.lms.dao.SharedNotesDao;
import ua.ivfr.it.lms.dao.SharedNotesDaoImp;
import ua.ivfr.it.lms.models.Note;
import ua.ivfr.it.lms.models.User;

import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Виводить HTML сторінку bootstrap
 */
public class IndexView {

    private PathHtmlSingleton pathHtmlSingleton;

    public IndexView() {
        pathHtmlSingleton = PathHtmlSingleton.getInstance();
    }

    public void outTopPage(PrintWriter out) {
        out.println(pathHtmlSingleton.getTop());
    }

    public void outBottomPage(PrintWriter out) {
        out.println(pathHtmlSingleton.getBottom());
    }

    public void outMenu(PrintWriter out) {
        out.println(pathHtmlSingleton.getMenu());
    }

    public void outMenu_Login(PrintWriter out) {
        out.println(pathHtmlSingleton.getMenu_login());
    }

    public void outLogin(PrintWriter out) {
        out.println(pathHtmlSingleton.getLogin());
    }

    public void outRegistration(PrintWriter out) {
        out.println(pathHtmlSingleton.getRegistration());
    }

    public void outUser(PrintWriter out) {
        out.println(pathHtmlSingleton.getUser());
    }

    public void doShareNotes(PrintWriter out) {
        out.println(pathHtmlSingleton.getDoshare());
    }

    public void doPostShareNotes(PrintWriter out) {
        out.println(pathHtmlSingleton.getPostshare());
    }

    // виводить поле для вводу тексту нотатки/заголовка
    // і список всіх створених користувачем нотаток
    public void outNotePage(PrintWriter out, List<Note> notes) {
        out.println(pathHtmlSingleton.getNote_page());
        //при створенні нотатки в посилання іконки "видалити(х)" передаємо пареметер
        // id створеної нотатки
        for (Note ob_note : notes) {
            //TODO bg-note-? створити класи для кожного кольру
            out.println("<div id=replaceID class=\"col-xs-4  col-md-3 col-lg-3 col-sm-12 note-merg\">\n" +
                    "    <div class=\"bg-note-1 note-size remove-hover\">\n" +
                    "        <a id=remove-item href=\"/note/delete?id=" + ob_note.getId() + "\"><span class=\"glyphicon glyphicon-remove\"></span></a>\n" +
                    "        <a id=share-item href=\"/note/share?id=" + ob_note.getId() + "\"><span class=\"glyphicon glyphicon-share-alt\"></span></a>\n" +
                    "        <a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
                    "            <h2>Title #1 " + ob_note.getNote_title() + "</h2>\n" +
                    "            <p>" + ob_note.getNote() + "</p>\n" +
                    "        </a>\n" +
                    "\n" +
                    "    </div>\n" +
                    "</div>");
        }
        out.println("</div>" +
                "</div><!--/body note-page -->");
    }


}


