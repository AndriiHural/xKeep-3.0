package ua.ivfr.it.lms.models;

/**
 *  Клас який описує репост нотатки
 */
public class SharedNotes {
    private int id;         // id
    private int user_id;    // id користувача
    private int notes_id;   // id нотатки

    public SharedNotes(int id, int user_id, int notes_id) {
        this.id = id;
        this.user_id = user_id;
        this.notes_id = notes_id;
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

    @Override
    public String toString() {
        return "SharedNotes{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", notes_id=" + notes_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SharedNotes that = (SharedNotes) o;

        if (id != that.id) return false;
        if (user_id != that.user_id) return false;
        return notes_id == that.notes_id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user_id;
        result = 31 * result + notes_id;
        return result;
    }
}
