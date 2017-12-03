package ua.ivfr.it.lms.views;

import ua.ivfr.it.lms.dao.SharedNotesDao;
import ua.ivfr.it.lms.dao.SharedNotesDaoImp;
import ua.ivfr.it.lms.models.User;

import java.io.PrintWriter;
import java.util.stream.Collectors;

public class SharedNotesView {
    private PathHtmlSingleton pathHtmlSingleton;
    //Вивід розшариних нотаток
    public void outPageNoteShare(PrintWriter out, User user) {

        SharedNotesDao sharedNotesDao = new SharedNotesDaoImp();
        //обробляємо отриманий набір об'єктів класу note через агрегатні операції
        String row = sharedNotesDao.getNoteByUserId(user.getId()).stream()
                //для кожного об'єкту класу Note створюємо новий об'єкт класу String
                .map(e -> "<div id=replaceID class=\"col-xs-4  col-md-3 col-lg-3 col-sm-12 note-merg\">\n" +
                        "    <div class=\"bg-note-1 note-size remove-hover\">\n" +
                        "        <a id=remove-item href=\"/note/delete?id=" + e.getId() + "\"><span class=\"glyphicon glyphicon-remove\"></span></a>\n" +
                        "        <a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
                        "            <h4>Поширив: " + e.getUser_id() + "</h4>\n" +
                        "            <h2>Title #1 " + e.getNote_title() + "</h2>\n" +
                        "            <p>" + e.getNote() + "</p>\n" +
                        "        </a>\n" +
                        "\n" +
                        "    </div>\n" +
                        "</div>")
                //об'єднуємо всі об'єкти класу String в один об'єкт
                .collect(Collectors.joining(" "));
        out.println(row);
    }
}
