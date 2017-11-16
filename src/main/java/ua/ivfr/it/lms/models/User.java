package ua.ivfr.it.lms.models;

import java.util.Arrays;

/**
 * Клас який описує блокнот в якому уже будуть нотатки
 */
public class User {

    private long id;
    private String email;
    private String password;
    private String name;
    private String data_registered;
    private int role;


    public User(long id, String email, String password, String name, String data_registered, int role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.data_registered = data_registered;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = email;
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


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", data_registered='" + data_registered + '\'' +
                ", role=" + role +
                '}';
    }
}
