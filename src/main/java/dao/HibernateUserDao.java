package dao;

import data.User;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class HibernateUserDao implements UserDao {

    @Override
    public User getByLogin(String login) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
//        User u = (User) s.createSQLQuery("SELECT * FROM public.user WHERE login=\'"+login+"\'").list().get(0);
        User u = (User) s.createQuery("FROM User WHERE login=\'"+login+"\'").list().get(0);
        s.getTransaction().commit();
        s.close();
        return u;
    }

    @Override
    public boolean add(User u) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.save(u);
        s.getTransaction().commit();
        s.close();
        return true;
    }
}
