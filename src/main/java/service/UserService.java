package service;

import dao.HibernateUserDao;
import dao.UserDao;
import data.User;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {
    private UserDao uDao = new HibernateUserDao();

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
