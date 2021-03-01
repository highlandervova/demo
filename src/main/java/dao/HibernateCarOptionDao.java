package dao;

import data.CarOption;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class HibernateCarOptionDao implements CarOptionDao{
    @Override
    public Collection<String> getByCarId(String carId) {
        Session s = HibernateUtil.getSession();
        Collection<CarOption> carOptions = s.createQuery("FROM CarOption WHERE carId='" + carId + "'").list();
        s.close();
        Collection<String> out = new ArrayList<>();
        for (CarOption co : carOptions) {
            out.add(co.getOptionId());
        }
        return out;
    }
}
