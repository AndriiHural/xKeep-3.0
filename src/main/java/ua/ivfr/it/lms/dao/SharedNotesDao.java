package ua.ivfr.it.lms.dao;

import ua.ivfr.it.lms.models.User;

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
}
