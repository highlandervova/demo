package service;

//import dao.HibernateUserDao;
import dao.HibernateUserDao;
import dao.UserDao;
//import dao.UserDaoImpl;
import dao.UserDaoImpl;
import data.User;
import enums.SpringBeanName;

import java.util.Random;

import static spring.SpringContextHolder.getBean;

public class UserService {
   // private UserDao userDao = new HibernateUserDao();
    private UserDao userDao = new UserDaoImpl();
     // UserDao userDao = (UserDao) getBean(SpringBeanName.USER_DAO.getName());

    public User addNewUser(String login, String pass) {

       User u = new User(new Random().nextInt(), login, pass, 0, "No");

        return userDao.add(u) ? u : null;
    }
    public boolean checkUserPassword(User u, String pass) {
        return u != null && u.getPass().equals(pass);
    }

    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }
}
