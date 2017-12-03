package ua.ivfr.it.lms.dao;

import ua.ivfr.it.lms.models.Note;
import ua.ivfr.it.lms.models.SharedNotes;
import ua.ivfr.it.lms.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SharedNotesDaoImp implements SharedNotesDao {
    /**
     * Повернути користувачів що розшарюють заміку
     * @param id замітки
     * @return колекція із користувачів, що призначені до замітки яка має значення id
     */
    @Override
    public List<User> getUsersByNoteId(long id) {
        //створює об'єкт для завантаження драйвера
        DataSource dataSource = new DataSource();
        List<User> lstUsers = new ArrayList<>();
        //отримує зв'язок з БД
        try (Connection con = dataSource.createConnection();
             //створює об'єкт для виконання SQL запитів
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.id IN (SELECT user_id FROM shared_notes WHERE shared_notes.notes_id=\"" + id + "\");");) {

            while(rs.next()){
                //створюємо об'єкт класу User на основі даних отриманих із БД
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getInt("role")
                );
                lstUsers.add(user);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return lstUsers;
    }

    @Override
    public List<Note> getNoteByUserId(long id) {
        System.out.println("НУУУІІІІ");
        DataSource dataSource = new DataSource();
        List<Note> lstnote = new ArrayList<>();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs2 = stmt.executeQuery("SELECT * FROM notes WHERE notes.id IN(SELECT shared_notes.notes_id FROM  shared_notes WHERE shared_notes.user_id=\"" +id+"\")");) {
            ArrayList<Note> notes=new ArrayList<>();
            Note note=null;
            if(rs2==null){System.out.println("NOoooo");}

            while (rs2.next()) {
                note = new Note(
                        rs2.getInt("id"),
                        rs2.getString("note"),
                        rs2.getString("note_title"),
                        rs2.getInt("is_archieve"),
                        rs2.getString("date_added"),
                        rs2.getString("color"),
                        rs2.getInt("user_id")
                );
                //notes.add(note);
                //note=null;
                System.out.println(note);
                lstnote.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstnote;
    }
    @Override
    public void addSharedNote(SharedNotes sharedNotes) {
        DataSource dataSource = new DataSource();

        try(
                Connection con = dataSource.createConnection();
                PreparedStatement stmt = (sharedNotes.getId() == 0L) ? con.prepareStatement("INSERT INTO shared_notes (user_id, notes_id) VALUES (?,?)") :
                        con.prepareStatement("UPDATE shared_notes SET user_id=?, notes_id=? WHERE id=" + sharedNotes.getId());
        ){
            stmt.setLong(1, sharedNotes.getUser_id());
            stmt.setLong(2, sharedNotes.getNotes_id());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
