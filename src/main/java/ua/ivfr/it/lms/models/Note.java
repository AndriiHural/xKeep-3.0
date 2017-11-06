package ua.ivfr.it.lms.models;

/**
 * Клас який описує нотатку, зберігає дані нотатки,такі як текст, шрифт, розмір
 */
public class Note {
    long id_note;        //id нотатки
    long in_user;        //id користувача (коли користувач надає доступ іншим користувачам щоб вони не мали право стерти твою закладку)
    String noteTitle;    //заголовок нотатки
    String noteText;     //текст нотатки
    String noteColor;    //колір нотатки
    String noteDate;     //дата створення даної нотатки

    public Note(long id_note, long in_user, String noteTitle, String noteText, String noteColor, String noteDate) {
        this.id_note = id_note;
        this.in_user = in_user;
        this.noteTitle = noteTitle;
        this.noteText = noteText;
        this.noteColor = noteColor;
        this.noteDate = noteDate;
    }

    public Note() {
    }

    public long getId_note() {
        return id_note;
    }

    public void setId_note(long id_note) {
        this.id_note = id_note;
    }

    public long getIn_user() {
        return in_user;
    }

    public void setIn_user(long in_user) {
        this.in_user = in_user;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNoteColor() {
        return noteColor;
    }

    public void setNoteColor(String noteColor) {
        this.noteColor = noteColor;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id_note=" + id_note +
                ", in_user=" + in_user +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteText='" + noteText + '\'' +
                ", noteColor='" + noteColor + '\'' +
                ", noteDate='" + noteDate + '\'' +
                '}';
    }
}
