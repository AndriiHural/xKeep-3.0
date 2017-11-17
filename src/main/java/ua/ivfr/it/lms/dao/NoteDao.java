package ua.ivfr.it.lms.dao;


import ua.ivfr.it.lms.models.Note;

/**
 * Інтерфейс, що задає методи для роботи із типом даних Note. Цей тип даних зберігається в таблиці бази даних note
 * Коли дані зчитують із таблиці, їх поміщають в об'єкт класу Note
 */

public interface NoteDao {
    /**
     * if id =0 create new Note in table
     *    id >0 update existing Note
     * */
    Note UpdateNote(Note note);
    boolean deleteNote(int note_id);
    Note viewNote(int note_id);
}
