package service;

import dao.HibernateUserDao;
import dao.UserDAO;
import data.User;

import java.util.Random;

public class UserService {
    private HibernateUserDao uDao = new HibernateUserDao();

    public User addNewUser(String login, String pass) {
        User u = new User(new Random().nextInt(), login, pass, 0, null);
        return uDao.add(u) ? u : null;
    }
    public boolean checkUserPassword(User u, String pass) {
        return u != null && u.getPass().equals(pass);
    }

    public User getByLogin(String login) {
        return uDao.getByLogin(login);
    }
}
