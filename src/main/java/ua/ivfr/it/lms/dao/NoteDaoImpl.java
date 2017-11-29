package ua.ivfr.it.lms.dao;

import ua.ivfr.it.lms.models.Note;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Клас що реалізує методи інтерфейсу NoteDao
 */
public class NoteDaoImpl implements NoteDao {
    @Override
    public Note UpdateNote(Note note) {
        DataSource dataSource = new DataSource();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String data = dtf.format(localDate); //2016/11/16
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
//            stmt=con.prepareStatement("INSERT INTO test(text)VALUE ('BBBBBB')");
//            stmt.execute();
            if (note.getId() != 0) {
                stmt = con.prepareStatement("UPDATE notes" +
                        " SET note=?,note_title=?,date_added=?,color=? WHERE id=?;");

                stmt.setString(1, note.getNote());
                stmt.setString(2, note.getNote_title());
                stmt.setString(3, data);
                stmt.setString(4, note.getColor());
                stmt.setInt(5,note.getId());
                stmt.execute();

            } else {
                stmt = con.prepareStatement("INSERT INTO notes(notes.note,note_title,is_archieve," +
                        "date_added,color,user_id)" +
                        " VALUE ('" + note.getNote() + "','" + note.getNote_title() + "',0,'" + data + "','"
                        + note.getColor() + "'," + note.getUser_id() + ");");
                stmt.execute();
            }
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM notes WHERE id="+note.getId()+";");
            if (rs2.next()) {
                Note note1 = new Note(
                        rs2.getInt("id"),
                        rs2.getString("note"),
                        rs2.getString("note_title"),
                        rs2.getInt("is_archieve"),
                        rs2.getString("date_added"),
                        rs2.getString("color"),
                        rs2.getInt("user_id")
                );
                return note1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteNote(int note_id) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()){
            stmt = con.prepareStatement(
                    "DELETE FROM notes WHERE id=?");
            stmt.setInt(1, note_id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Note> viewNotes(int user_id) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs2 = stmt.executeQuery("SELECT * FROM notes WHERE user_id="+user_id+";");
        ) {
            ArrayList<Note> notes=new ArrayList<>();
            while (rs2.next()) {
                Note note = new Note(
                        rs2.getInt("id"),
                        rs2.getString("note"),
                        rs2.getString("note_title"),
                        rs2.getInt("is_archieve"),
                        rs2.getString("date_added"),
                        rs2.getString("color"),
                        rs2.getInt("user_id")
                );
                notes.add(note);
            }
            return notes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
