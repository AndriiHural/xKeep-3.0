package ua.ivfr.it.lms.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Має змінні String, які містять html файли. Реалізує патерн Singleton
 */
public class PathHtmlSingleton {

    /**
     * Шлях до папки HTML із файлами
     */
    private String path = "";
    /**
     * Змінні, що містять значення відповідних файлів з папки HTML
     */
    private String top;
    private String menu;
    private String menu_login;
    private String menu_admin;
    private String bottom;
    private String login;
    private String registration;
    private String user;
    private String note_page;
    private String doshare;
    private String postshare;
    private String admin;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = getPartialHtml(admin);
    }

    public String getMenu_admin() {
        return menu_admin;
    }

    public void setMenu_admin(String menu_admin) {
        this.menu_admin = getPartialHtml(menu_admin);
    }

    public String getMenu_login() {
        return menu_login;
    }

    public void setMenu_login(String menu_login) {
        this.menu_login = getPartialHtml(menu_login);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = getPartialHtml(note);
    }
    private String note;


    public String getNote_page() {
        return note_page;
    }
    public void setNote_page(String note_page) {
        this.note_page = getPartialHtml(note_page);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = getPartialHtml(user);
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = getPartialHtml(registration);
    }

    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = getPartialHtml(login);
    }

    private static PathHtmlSingleton ourInstance = new PathHtmlSingleton();

    public static PathHtmlSingleton getInstance() {
        return ourInstance;
    }

    private PathHtmlSingleton() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = getPartialHtml(top);
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = getPartialHtml(menu);
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = getPartialHtml(bottom);
    }

    public String getDoshare() {
        return doshare;
    }

    public void setDoshare(String doshare) {
        this.doshare = getPartialHtml(doshare);
    }

    public String getPostshare() {
        return postshare;
    }

    public void setPostshare(String postshare) {
        this.postshare = getPartialHtml(postshare);
    }

    /**
     * Зчитує файл
     *
     * @param filename назва  файлу
     * @return вміст зчитаного файлу
     */
    private String getPartialHtml(String filename) {
        StringBuilder strb = new StringBuilder();
        Path file = Paths.get(this.path + filename);
        Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                strb.append(line).append("\n");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return strb.toString();
    }
}