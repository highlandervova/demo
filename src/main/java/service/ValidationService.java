package service;

import dao.HibernateUserDao;
import dao.UserDao;
import dao.UserDaoImpl;
import enums.SpringBeanName;

import static spring.SpringContextHolder.getBean;

public class ValidationService {
   // private UserDao userDao = new HibernateUserDao();
   private UserDao userDao = new UserDaoImpl();
   // UserDao userDao = (UserDao) getBean(SpringBeanName.USER_DAO.getName());


    public  boolean validateRegistration(String login, String pass1, String pass2) {
        if (pass1 != null && pass1.equals(pass2) && login != null) {
            if (userDao.getByLogin(login) == null) {
                return true;
            } else return false;
        } else return false;
    }
}
