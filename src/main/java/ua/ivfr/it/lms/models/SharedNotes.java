package ua.ivfr.it.lms.models;

/**
 *  Клас який описує репост нотатки
 */
public class SharedNotes {
    private long id;         // id
    private long user_id;    // id користувача
    private long notes_id;   // id нотатки

    public SharedNotes() {
    }

    public SharedNotes(long id, long user_id, long notes_id) {
        this.id = id;
        this.user_id = user_id;
        this.notes_id = notes_id;
    }
    public SharedNotes(long user_id, long notes_id) {
        this.id = 0L;
        this.user_id = user_id;
        this.notes_id = notes_id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getNotes_id() {
        return notes_id;
    }

    public void setNotes_id(long notes_id) {
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
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (user_id ^ (user_id >>> 32));
        result = 31 * result + (int) (notes_id ^ (notes_id >>> 32));
        return result;
    }
}
