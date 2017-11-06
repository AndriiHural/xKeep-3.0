package ua.ivfr.it.lms.models;

import java.util.Arrays;

/**
 * Клас який описує блокнот в якому уже будуть нотатки
 */
public class User {
    public class NoteBook {
        long id_noteBook;                    //id блокноту
        long in_user;        //id користувача (коли користувач надає доступ іншим користувачам щоб вони не мали права стерти твою закладку)
        long[] id_note;        //спосок id нотаток цього болкнота
        String noteBookTitle;              //заголовок нотатки
        String noteBookDate;              //дата створення даної нотатки

        public NoteBook() {
        }

        public NoteBook(long id_noteBook, long in_user, long[] id_note, String noteBookTitle, String noteBookDate) {

            this.id_noteBook = id_noteBook;
            this.in_user = in_user;
            this.id_note = id_note;
            this.noteBookTitle = noteBookTitle;
            this.noteBookDate = noteBookDate;
        }

        public long getId_noteBook() {
            return id_noteBook;
        }

        public void setId_noteBook(long id_noteBook) {
            this.id_noteBook = id_noteBook;
        }

        public long getIn_user() {
            return in_user;
        }

        public void setIn_user(long in_user) {
            this.in_user = in_user;
        }

        public long[] getId_note() {
            return id_note;
        }

        public void setId_note(long[] id_note) {
            this.id_note = id_note;
        }

        public String getNoteBookTitle() {
            return noteBookTitle;
        }

        public void setNoteBookTitle(String noteBookTitle) {
            this.noteBookTitle = noteBookTitle;
        }

        public String getNoteBookDate() {
            return noteBookDate;
        }

        public void setNoteBookDate(String noteBookDate) {
            this.noteBookDate = noteBookDate;
        }

        @Override
        public String toString() {
            return "NoteBook{" +
                    "id_noteBook=" + id_noteBook +
                    ", in_user=" + in_user +
                    ", id_note=" + Arrays.toString(id_note) +
                    ", noteBookTitle='" + noteBookTitle + '\'' +
                    ", noteBookDate='" + noteBookDate + '\'' +
                    '}';
        }
    }
}