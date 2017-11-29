package ua.ivfr.it.lms.dao;

import ua.ivfr.it.lms.models.User;

/**
 * Інтерфейс, що задає методи для роботи із типом даних User. Цей тип даних зберігається в таблиці бази даних users
 * Коли дані зчитують із таблиці, їх поміщають в об'єкт класу User
 */
public interface UserDao {
    /**
     * Шукає користувача за email
     * @param email має бути із форми логіна
     * @return class User or null
     */
    User findUserByEmail(String email);
    User findUserByEmailPassword(String email,String password);
    String allUser();
}
