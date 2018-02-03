package ua.ivfr.it.lms.dao;

import ua.ivfr.it.lms.models.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Клас, що реалізує методи інтерфейсу UserDao
 */
public class UserDaoImpl implements UserDao {
    /**
     * Шукає користувача за email
     *
     * @param email має бути із форми логіна
     * @return claas User or null
     */
    @Override
    public User findUserByEmail(String email) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.email=\"" + email + "\";");) {
            if (rs.next()) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User findUserByIdUser(long id) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.id=\"" + id + "\";");) {
            if (rs.next()) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User findUserByEmailPassword(String email, String password) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM xkeep.users where email=\"" + email + "\" and password=\"" + password + "\";");) {
            if (rs.next()) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public ArrayList<User> allUser() {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users ;");
        ) {
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
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
    public User creatUser(String email, String password, String name) {
        DataSource dataSource = new DataSource();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String data = dtf.format(localDate); //2016/11/16
        PreparedStatement stmt = null;

        try (Connection con = dataSource.createConnection()) {
//            stmt=con.prepareStatement("INSERT INTO test(text)VALUE ('BBBBBB')");
//            stmt.execute();


            stmt = con.prepareStatement("INSERT INTO users(users.email,users.password,users.name," +
                    "users.date,users.role)" +
                    " VALUE ('" + email + "','" + password + "','" + name + "','"
                    + data + "'," + "2" + ");");
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User deleteUser(String email) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement(
                    "DELETE FROM users WHERE users.email=\"" + email + "\";");
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User editNameUser(String email, String name) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("UPDATE users" +
                    " SET users.name=\"" + name + "\" WHERE users.email=\"" + email + "\";");

            stmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User editPasswordUser(User user, String password, String passwordNew) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("UPDATE users" +
                    " SET users.password=\"" + passwordNew + "\" WHERE users.password=\"" + password + "\";");

            stmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fintUserById(long user_id) {
        DataSource dataSource = new DataSource();
        //PreparedStatement stmt = null;
        String all = "  ";
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=\"" + user_id + "\";");) {
            while (rs.next()) {
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getInt("role")
                );
                all = all + user.getEmail() + "    ";
            }

            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void editRoleForId(User user, long id) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        if (user.getRole() != 3) {
            try (Connection con = dataSource.createConnection()) {
                stmt = con.prepareStatement("UPDATE users" +
                        " SET users.role=\"" + "3" + "\" WHERE users.id=\"" + id + "\";");

                stmt.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (user.getRole() == 3) {
            try (Connection con = dataSource.createConnection()) {
                stmt = con.prepareStatement("UPDATE users" +
                        " SET users.role=\"" + "2" + "\" WHERE users.id=\"" + id + "\";");

                stmt.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editEmailPasswordNameForId(User user, String email, String password, String name) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("UPDATE users" +
                    " SET users.email=\"" + email + "\",users.password=\"" + password + "\",users.name=\"" + name + "\" WHERE users.email=\"" + user.getEmail() + "\";");

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}