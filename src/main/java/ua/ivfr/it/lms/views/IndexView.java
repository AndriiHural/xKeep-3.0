package ua.ivfr.it.lms.views;

import java.io.PrintWriter;

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
}


