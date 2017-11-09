package ua.ivfr.it.lms.models;

import java.util.Arrays;

/**
 * Клас який описує блокнот в якому уже будуть нотатки
 */
public class User {

    private long id;
    private String name;
    private String username;
    private String password;
    private String data_registered;
    private boolean admin = false;


    public User(long id, String name, String username, String password, String data_registered) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.data_registered = data_registered;
        this.admin = admin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData_registered_() {
        return data_registered;
    }

    public void setData_registered_(String data_registered_) {
        this.data_registered = data_registered_;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", data_registered_='" + data_registered + '\'' +
                ", admin=" + admin +
                '}';
    }
}
