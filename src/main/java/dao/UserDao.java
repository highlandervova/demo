package dao;

import data.User;

public interface UserDao {
    User getByLogin(String login) ;
    boolean add(User u);
}
