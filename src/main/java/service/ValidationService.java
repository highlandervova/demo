package service;

import dao.HibernateUserDao;
import dao.UserDao;

public class ValidationService {
    private UserDao uDao = new HibernateUserDao();

    public boolean validateRegistration(String login, String pass1, String pass2) {
        if (pass1 != null && pass1.equals(pass2) && login != null) {
            if (uDao.getByLogin(login) == null) {
                return true;
            } else return false;
        } else return false;
    }
}
