package service;

import dao.UserDAO;
import data.User;

import java.util.Random;

public class UserService {
    public User addNewUser(String login, String pass) {
        User u = new User(
                new Random().nextInt(),
                login,
                pass,
                0,
                null);
        return new UserDAO().add(u) ? u : null;
    }
}
