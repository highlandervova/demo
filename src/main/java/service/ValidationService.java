package service;

import dao.UserDAO;

public class ValidationService {
    public boolean validateRegistration(String login, String pass1, String pass2) {
        if (pass1 != null && pass1.equals(pass2) && login != null) {
            if (new UserDAO().getByLogin(login) == null) {
                return true;
            } else return false;
        } else return false;
    }
}
