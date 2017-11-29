package ua.ivfr.it.lms.dao;

import ua.ivfr.it.lms.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Клас, що реалізує методи інтерфейсу UserDao
 */
public class UserDaoImpl implements UserDao {
    /**
     * Шукає користувача за email
     * @param email має бути із форми логіна
     * @return claas User or null
     */
    @Override
    public User findUserByEmail(String email) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.email=\"" + email + "\";");) {
            if(rs.next()){
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getInt("role")
                );
                return user;
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public User findUserByEmailPassword(String email,String password) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();

             ResultSet rs = stmt.executeQuery("SELECT * FROM xkeep.users where email=\""+email+"\" and password=\""+password+"\";");) {
            if(rs.next()){
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getInt("role")
                );

                return user;

            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public String allUser() {
        DataSource dataSource = new DataSource();
        String all="";
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users ");) {
            while(rs.next()){
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getInt("role")
                );
                all=all+user.toString()+"       ";
            }
            return all;


        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
