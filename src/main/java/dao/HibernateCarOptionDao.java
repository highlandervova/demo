package dao;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class HibernateCarOptionDao implements CarOptionDao{
    @Override
    public Collection<String> getByCarId(String carId) {
        Session s = HibernateUtil.getSession();
        Collection<String> out = s.createSQLQuery("SELECT option_id FROM car_option WHERE car_id='" + carId + "'").list();
        s.close();
        return out;
    }
}
