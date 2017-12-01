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
            out.println("<div id=replaceID class=\"col-xs-12 rotate col-md-3 col-lg-3 col-sm-3\">\n" +
                    "        <div class=\"note-merg\">\n" +
                    "            <div class=\"bg-note-1 note-size merg-color remove-hover\">\n" +
                    "                <a id=remove-item href=\"/note/delete?id="+ob_note.getId()+"\"><span class=\"glyphicon glyphicon-remove\"></span></a>\n" +
                    "                <a href=\"#\" class='onclick'>\n" +
                    "                    <h3>Title #1"+ob_note.getNote_title()+"</h3>\n" +
                    "                    <p>"+ob_note.getNote()+"</p>\n" +
                    "                    \n" +
                    "                </a>\n" +
                    "                <form action=\"#\" method=\"POST\" class=\"form_size\">\n" +
                    "                    <div class=\"edit_size90\">\n" +
                    "                        <input type=\"text\" class=\"form-control\" placeholder=\""+ob_note.getNote_title()+"\" name=\"\">\n" +
                    "                        <textarea class=\"form-control\" rows=\"3\">"+ob_note.getNote()+"</textarea>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"edit_Note\">\n" +
                    "                        <button class=\"btn btn-default  close\">Закрити</button>\n" +
                    "                        <a type=\"button\" href=\"/note/edit\" class=\"btn btn-success\">Зберегти</a>\n" +
                    "                    </div>\n" +
                    "                </form>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>");
        }

        out.println("</div>" +
                "</div><!--/body note-page -->");
    }

}
