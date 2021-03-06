package ua.ivfr.it.lms.views;

import ua.ivfr.it.lms.dao.NoteDaoImpl;
import ua.ivfr.it.lms.dao.SharedNotesDao;
import ua.ivfr.it.lms.dao.SharedNotesDaoImp;
import ua.ivfr.it.lms.dao.UserDaoImpl;
import ua.ivfr.it.lms.models.Note;
import ua.ivfr.it.lms.models.SharedNotes;
import ua.ivfr.it.lms.models.User;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SharedNotesView {
    private PathHtmlSingleton pathHtmlSingleton;

    public SharedNotesView() {
        pathHtmlSingleton = PathHtmlSingleton.getInstance();
    }

    //Вивід розшариних нотаток
    public void outPageNoteShare(PrintWriter out, User user) {
        SharedNotesDaoImp sharedNotesDao = new SharedNotesDaoImp();
        SharedNotes sharedNotes = new SharedNotes();
        List<User> lstUsers = new ArrayList<>();
        UserDaoImpl userDao = new UserDaoImpl();
        //User user1 = new User();
        NoteDaoImpl noteDao = new NoteDaoImpl();
       // System.out.println(lstUsers.get(1));
        //обробляємо отриманий набір об'єктів класу note через агрегатні операції
        String row = sharedNotesDao.getNoteByUserId(user.getId()).stream()
                //для кожного об'єкту класу Note створюємо новий об'єкт класу String
//                .map((Note e) -> "<div id=replaceID class=\"col-xs-4  col-md-3 col-lg-3 col-sm-12 note-merg\">\n" +
//                        "    <div class=\"bg-note-1 note-size remove-hover\">\n" +
//                        "        <a id=remove-item href=\"/shared-notes/delete?id=" + e.getId() + "\"><span class=\"glyphicon glyphicon-remove\"></span></a>\n" +
//                        "        <a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
//                        "            <h4>Поширив: " + userDao.fintUserById(e.getUser_id()) + "</h4>\n" +
//                        "            <h2>Title #1 " + e.getNote_title() + "</h2>\n" +
//                        "            <p>" + e.getNote() + "</p>\n" +
//                        "        </a>\n" +
//                        "\n" +
//                        "    </div>\n" +
//                        "</div>")
                .map((Note e)->"<div id=replaceID class=\"col-xs-12 rotate col-md-3 col-lg-3 col-sm-3\">\n" +
                        "        <div class=\"note-merg\">\n" +
                        "            <div class=\"bg-note-1 note-size merg-color remove-hover\">\n" +
                        "                <a id=remove-item href=\"/note/delete?id="+e.getId()+"\"><span class=\"glyphicon glyphicon-remove\"></span></a>\n" +
                        "                <a href=\"#\" class='onclick'>\n" +
                        "                    <h4>Поширив: " + userDao.fintUserById(e.getUser_id()) + "</h4>\n" +
                        "                    <h3>Title #1"+e.getNote_title()+"</h3>\n" +
                        "                    <p>"+e.getNote()+"</p>\n" +
                        "                    \n" +
                        "                </a>\n" +
                        "                <form action=\"/note/edit\" method=\"GET\" class=\"form_size\">\n" +
                        "                    <div class=\"edit_size90\">\n" +
                        "                        <input type=\"text\" class=\"form-control\" value=\""+e.getNote_title()+"\" name=\"title\">\n" +
                        "                        <input type=\"hidden\" class=\"form-control\" value=\""+e.getId()+"\" name=\"id\">\n" +
                        "                        <textarea class=\"form-control\" rows=\"3\" name=\"noteText\">"+e.getNote()+"</textarea>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"edit_Note\">\n" +
                        "                        <button class=\"btn btn-default  close\">Закрити</button>\n" +
                        "                        <button type=\"submit\" class=\"btn btn-success\">Зберегти2</button>\n" +
                        "                    </div>\n" +
                        "                </form>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>")
                //об'єднуємо всі об'єкти класу String в один об'єкт
                .collect(Collectors.joining(" "));
        out.println();
        out.println(pathHtmlSingleton.getNote_page());
        out.println(row);
        out.println("</div>" +
                "</div><!--/body note-page -->");
    }
}
