package ua.ivfr.it.lms.dao;

import ua.ivfr.it.lms.models.Note;
import ua.ivfr.it.lms.models.SharedNotes;
import ua.ivfr.it.lms.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Інтерфесйс, що містить методи для роботи із таблицею sharednotesusers
 */
public interface SharedNotesDao {
    /**
     * Повернути користувачів що розшарюють заміку
     * @param id замітки
     * @return колекція із користувачів, що призначені до замітки яка має значення id
     */
    List<User> getUsersByNoteId(long id);
    List<Note> getNoteByUserId(long id); // Вивід пошириних нотаток
    boolean deleteShareNote(long user_id,int note_id);
    void addSharedNote(long note_id,User user); //
    ArrayList<User> viewUser(int user_id);   //пошук мейла користувача
    ArrayList<SharedNotes> getId(long id); // id- поширеної нотатки

}
