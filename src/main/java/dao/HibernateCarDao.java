package dao;

import data.Car;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class HibernateCarDao implements CarDao{
    @Override
    public Collection<Car> getAllCars() {
        Session s = HibernateUtil.getSession();
        Collection<Car> out = s.createCriteria(Car.class).list();
        s.close();
        return out;
    }

    @Override
    public Collection<Car> getByType(int type) {
        Session s = HibernateUtil.getSession();
        Collection<Car> out = s.createQuery("FROM Car WHERE type=" + type).list();
        s.close();
        return out;
    }

    @Override
    public Car getById(String id) {
        Session s = HibernateUtil.getSession();
        Car out = (Car) s.createQuery("FROM Car WHERE id='" + id + "'").uniqueResult();
        s.close();
        return out;
    }

    @Override
    public boolean add(Car car) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.save(car);
        s.getTransaction().commit();
        s.close();
        return true;
    }
}
