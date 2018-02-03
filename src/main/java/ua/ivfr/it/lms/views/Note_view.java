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
                    "                <a id=remove-item href=\"/note/delete?id=" + ob_note.getId() + "\"><span class=\"glyphicon glyphicon-remove\"></span></a>\n" +
                    "                <a id=share-item href=\"#\" data-toggle=\"modal\" data-target=\"#myModall\"><span class=\"glyphicon glyphicon-share-alt\"></span></a>\n" +

                    "                <a href=\"#\" class='onclick'>\n" +
                    "                    <h3>Title #1" + ob_note.getNote_title() + "</h3>\n" +
                    "                    <p>" + ob_note.getNote() + "</p>\n" +
                    "                    \n" +
                    "                </a>\n" +
                    "                <form action=\"/note/edit\" method=\"GET\" class=\"form_size\">\n" +
                    "                    <div class=\"edit_size90\">\n" +
                    "                        <input type=\"text\" class=\"form-control\" value=\"" + ob_note.getNote_title() + "\" name=\"title\">\n" +
                    "                        <input type=\"hidden\" class=\"form-control\" value=\"" + ob_note.getId() + "\" name=\"id\">\n" +
                    "                        <textarea class=\"form-control\" rows=\"3\" name=\"noteText\">" + ob_note.getNote() + "</textarea>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"edit_Note\">\n" +
                    "                        <button class=\"btn btn-default  close\">Закрити</button>\n" +
                    "                        <button type=\"submit\" class=\"btn btn-success\">Зберегти</button>\n" +
                    "                    </div>\n" +
                    "                </form>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>" +
                    "<!-- Modal -->\n" +
                    "<div id=\"myModall\" class=\"modal fade\" role=\"dialog\">\n" +
                    "    <div class=\"modal-dialog\">\n" +
                    "\n" +
                    "        <!-- Modal content-->\n" +
                    "        <div class=\"modal-content\">\n" +
                    "            <div class=\"modal-header\">\n" +
                    "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
                    "                <h4 class=\"modal-title\"> Поширення </h4>\n" +
                    "            </div>\n" +
                    "            <div class=\"modal-body\">\n" +
                    "                <form action=\"/note/shared\" method=\"POST\" class=\"form-horizontal\">\n" +
                    "                <label for=\"email\">Email</label>\n" +
                    "                <input type=\"text\" class=\"form-control\" id=\"email\" name=\"email\">\n" +

                    "                </form>\n" +
                    "            </div>\n" +
                    "            <div class=\"modal-footer\">\n" +
                    "                    <div class=\"col-xs-6 col-xs-offset-5 col-md-3 col-md-offset-5 col-lg-2 col-lg-offset-5\">\n" +
                    "                        <button type=\"submit\" class=\"btn btn-default btn-block\" name=\"note_id\" value=\"" + ob_note.getId() + "\" >Поширити</button>\n" +
                    "                    </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "\n" +
                    "    </div>\n" +
                    "</div>");
        }

        out.println("</div>" +
                "</div><!--/body note-page -->" + "\n"
        );
    }

}
