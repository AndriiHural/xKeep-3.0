package ua.ivfr.it.lms.views;

import ua.ivfr.it.lms.models.Note;

import java.io.PrintWriter;
import java.util.List;

public class Note_view {

    private PathHtmlSingleton pathHtmlSingleton;

    public Note_view() {
        pathHtmlSingleton = PathHtmlSingleton.getInstance();
    }

    //TODO добавити вивід нотаток розшарених іншими користувачати
    public void outNotePage(PrintWriter out, List<Note> notes) {
        out.println(pathHtmlSingleton.getNote_page());
        //при створенні нотатки в посилання іконки "видалити(х)" передаємо пареметер
        // id створеної нотатки
        for (Note ob_note : notes) {
            //TODO bg-note-? створити класи для кожного кольру
            out.println("<div id=replaceID class=\"col-xs-4  col-md-3 col-lg-3 col-sm-12 note-merg\">\n" +
                    "    <div class=\"bg-note-1 note-size remove-hover\">\n" +
                    "        <a id=remove-item href=\"/note/delete?id="+ob_note.getId()+"\"><span class=\"glyphicon glyphicon-remove\"></span></a>\n" +
                    "        <a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
                    "            <h2>Title #1 "+ob_note.getNote_title()+"</h2>\n" +
                    "            <p>"+ob_note.getNote()+"</p>\n" +
                    "        </a>\n" +
                    "\n" +
                    "    </div>\n" +
                    "</div>");
        }
        out.println("</div>" +
                "</div><!--/body note-page -->");
    }

}
