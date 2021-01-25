package dao;

import data.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL    = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN  = "postgres";
    private static final String PASS   = "postgres";

    private Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Error load driver;");
            e.printStackTrace();
        }
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, LOGIN, PASS);
        } catch (Exception e) {
            System.out.println("Error get connection;");
            e.printStackTrace();
        }
        return c;
    }

    public User getByLogin(String login) {
        try (Connection c = getConnection(); Statement st = c.createStatement();) {
            ResultSet rs = st.executeQuery("SELECT * FROM user WHERE login='"+login+'\'');
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("pass"),
                        rs.getInt("age"),
                        rs.getString("phone"));
            } else return null;
        } catch (Exception e) {
            System.out.println("Error save user;");
            e.printStackTrace();
            return null;
        }
    }

    public boolean add(User u) {
        if (getByLogin(u.getLogin()) != null) {
            return false;
        } else {
            int count = 0;
            try (Connection c = getConnection(); Statement st = c.createStatement();) {
                count = st.executeUpdate("INSERT INTO user VALUES("+u.getId()+", '"+u.getLogin()+"', '"+u.getPass()+"', "+u.getAge()+", '"+u.getPhone()+"')");
            } catch (Exception e) {
                System.out.println("Error save user;");
                e.printStackTrace();
            }
            return count > 0;
        }
    }
}
