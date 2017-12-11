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
     *
     * @param id замітки
     * @return колекція із користувачів, що призначені до замітки яка має значення id
     */
  /*  public ArrayList<User> viewUser(long user_id) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs2 = stmt.executeQuery("SELECT * FROM notes WHERE user_id=" + user_id + ";");
        ) {
            ArrayList<User> notes = new ArrayList<>();
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
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    @Override
    public ArrayList<User> getUsersByNoteId(long id) {
        //створює об'єкт для завантаження драйвера
        DataSource dataSource = new DataSource();
        // List<User> lstUsers = new ArrayList<>();
        //отримує зв'язок з БД
        try (Connection con = dataSource.createConnection();
             //створює об'єкт для виконання SQL запитів
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + id + ";");) {
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                //створюємо об'єкт класу User на основі даних отриманих із БД
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getInt("role")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> viewUser(int user_id) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT* FROM users WHERE id=" + user_id + ";");
        ) {
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getInt("role")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<SharedNotes> getId(long id) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
        Statement stmt= con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT* FROM shared_notes WHERE user_id=" + id + ";")
        ){
            ArrayList<SharedNotes> sharedNotess = new ArrayList<>();
            while (rs.next()) {
                SharedNotes sharedNotes = new SharedNotes(
                        rs.getLong("id"),
                        rs.getInt("user_id"),
                        rs.getLong("notes_id")
                );

                sharedNotess.add(sharedNotes);
            }
            return sharedNotess;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public long getId1(long id) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt= con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT* FROM shared_notes WHERE user_id=" + id + ";")
        ){

            SharedNotes sharedNotes = new SharedNotes(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getLong("notes_id"));
            return sharedNotes.getId();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<Note> getNoteByUserId(long id) {
        DataSource dataSource = new DataSource();
        List<Note> lstnote = new ArrayList<>();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs2 = stmt.executeQuery("SELECT * FROM notes WHERE notes.id IN(SELECT shared_notes.notes_id FROM  shared_notes WHERE shared_notes.user_id=\"" + id + "\")");) {
            ArrayList<Note> notes = new ArrayList<>();
            Note note = null;
            if (rs2 == null) {
                System.out.println("NOoooo");
            }

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
                lstnote.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstnote;
    }


    @Override
    public boolean deleteShareNote(long user_id,int notes_id) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement(
                    "DELETE FROM shared_notes WHERE user_id=? and notes_id=?");
            stmt.setLong(1, user_id);
            stmt.setInt(2,notes_id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addSharedNote(SharedNotes sharedNotes) {
        DataSource dataSource = new DataSource();

        try (
                Connection con = dataSource.createConnection();
                PreparedStatement stmt = (sharedNotes.getId() == 0L) ? con.prepareStatement("INSERT INTO shared_notes (user_id, notes_id) VALUES (?,?)") :
                        con.prepareStatement("UPDATE shared_notes SET user_id=?, notes_id=? WHERE id=" + sharedNotes.getId());
        ) {
            stmt.setLong(1, sharedNotes.getUser_id());
            stmt.setLong(2, sharedNotes.getNotes_id());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
