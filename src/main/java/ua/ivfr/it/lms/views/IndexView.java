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

    public void outNotePage(PrintWriter out, List<Note> notes) {
        String page = pathHtmlSingleton.getNote_page();
        String note = pathHtmlSingleton.getNote();
        for (Note ob_note : notes) {
            //System.out.println("Before "+note);
            note = note.replace("setcolor", "1");
            note = note.replace("Text_Content", ob_note.getNote());
            //System.out.println("After "+note);
            System.out.println("Before "+page);
            page=page.replace("<!--newNote-->", note);
            System.out.println("After "+page);
        }

        out.println(page);
    }
}


