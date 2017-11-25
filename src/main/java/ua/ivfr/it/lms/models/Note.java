package ua.ivfr.it.lms.models;

public class Note {
    private int id;
    private String note;
    private String note_title;
    private int is_archieve;
    private String date_added;
    private String color;
    private int user_id;

    public Note(int note_id, String note, String note_title, int is_archieve, String date_added, String color, int user_id) {
        this.id = note_id;
        this.note = note;
        this.note_title = note_title;
        this.is_archieve = is_archieve;
        this.date_added = date_added;
        this.color = color;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", note_title='" + note_title + '\'' +
                ", is_archieve=" + is_archieve +
                ", date_added='" + date_added + '\'' +
                ", color='" + color + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note1 = (Note) o;

        if (id != note1.id) return false;
        if (is_archieve != note1.is_archieve) return false;
        if (user_id != note1.user_id) return false;
        if (note != null ? !note.equals(note1.note) : note1.note != null) return false;
        if (note_title != null ? !note_title.equals(note1.note_title) : note1.note_title != null) return false;
        if (date_added != null ? !date_added.equals(note1.date_added) : note1.date_added != null) return false;
        return color != null ? color.equals(note1.color) : note1.color == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (note_title != null ? note_title.hashCode() : 0);
        result = 31 * result + is_archieve;
        result = 31 * result + (date_added != null ? date_added.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + user_id;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public int getIs_archieve() {
        return is_archieve;
    }

    public void setIs_archieve(int is_archieve) {
        this.is_archieve = is_archieve;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
