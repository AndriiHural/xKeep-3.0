package ua.ivfr.it.lms.models;

/**
 * Клас який описує репост нотатки
 */
public class Labels {
    private int id;
    private int user_id;
    private int notes_id;
    private char name;


    public Labels(int id, int user_id, int notes_id, char name) {
        this.id = id;
        this.user_id = user_id;
        this.notes_id = notes_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNotes_id() {
        return notes_id;
    }

    public void setNotes_id(int notes_id) {
        this.notes_id = notes_id;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Labels{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", notes_id=" + notes_id +
                ", name=" + name +
                '}';
    }
}