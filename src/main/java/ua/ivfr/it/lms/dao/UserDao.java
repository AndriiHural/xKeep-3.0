package ua.ivfr.it.lms.dao;

import ua.ivfr.it.lms.models.User;

import java.util.ArrayList;

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
    ArrayList<User> allUser();
    User creatUser(String email,String password,String name);
    User deleteUser(String email);
    User editNameUser(String email,String name);
    User editPasswordUser(User user,String password, String passwordNew);
    String fintUserById(long id);
    User findUserByIdUser(long id);
    void editRoleForId(User user,long id);
    void editEmailPasswordNameForId(User user,String email,String password,String name);
}
