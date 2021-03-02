package dao;

import data.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoImpl extends PostgreSqlDao implements UserDao {

    @Override
    public User getByLogin(String login) {
        try (Connection c = getConnection(); Statement st = c.createStatement();) {
//            st.executeUpdate("CREATE TABLE public.user (id int PRIMARY KEY," +
//                    "login varchar(50) NOT NULL," +
//                    "pass varchar(1024) NOT NULL," +
//                    "age int," +
//                    "phone varchar(50))");
            ResultSet rs = st.executeQuery("SELECT * FROM public.user WHERE login=\'"+login+"\'");
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("pass"),
                        rs.getInt("age"),
                        rs.getString("phone"));
            } else return null;
        } catch (Exception e) {
            System.out.println("Error login user;");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean add(User u) {
        if (getByLogin(u.getLogin()) != null) {
            return false;
        } else {
            int count = 0;
            try (Connection c = getConnection(); Statement st = c.createStatement();) {
                count = st.executeUpdate("INSERT INTO public.user VALUES("+u.getId()+", \'"+u.getLogin()+"\', \'"+u.getPass()+"\', "+u.getAge()+", \'"+u.getPhone()+"\')");
            } catch (Exception e) {
                System.out.println("Error save user;");
                e.printStackTrace();
            }
            return count > 0;
        }
    }
}
