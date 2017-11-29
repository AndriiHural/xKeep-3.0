package ua.ivfr.it.lms.views;

import ua.ivfr.it.lms.models.Note;

import java.io.PrintWriter;
import java.util.List;

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

    public void doShareNotes(PrintWriter out){
        out.println(pathHtmlSingleton.getDoshare());
    }

    public void doPostShareNotes(PrintWriter out){
        out.println(pathHtmlSingleton.getPostshare());
    }
    // виводить поле для вводу тексту нотатки/заголовка
    // і список всіх створених користувачем нотаток

}


