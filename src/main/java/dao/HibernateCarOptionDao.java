package dao;


import data.CarOption;
import hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;

public class HibernateCarOptionDao implements CarOptionDao {

    @Override
    public Collection<String> getByCarId(String carId) {
        Session s = HibernateUtil.getSession();
        Collection<CarOption> carOptions =
                s.createQuery("FROM CarOption WHERE carId='" + carId + "'").list();
        Collection<String> out = new ArrayList<>();
        for (CarOption co : carOptions) {
            out.add(co.getOptionId());
        }
        s.close();
        return out;
    }

    @Override
    public Collection<String> getOptionsByCarIdForAdd (String carId)   {
        Session s = HibernateUtil.getSession();
        Collection<CarOption> carOptions =
       s.createQuery("SELECT o.id FROM option o " +
                            "left outer  join car_option co on co.option_id = o.id  " +
                            " and co.car_id = '" + carId+"' where co.id is null").list();
        Collection<String> out = new ArrayList<>();
        for (CarOption co : carOptions) {
            out.add(co.getOptionId());
        }
        s.close();
        return out;
    }


    @Override
    public boolean addNewOptionCar(CarOption co) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.save(co);
        s.getTransaction().commit();
        s.close();
        return true;
    }

    @Override
    public boolean removeOptionCar(String carId, String optionId) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        Query query = s.createQuery("delete from car_option co where co.car_id = :carId and co.option_id =:optionId");
        query.setParameter("carId", carId);
        query.setParameter("optionId", optionId);
        query.executeUpdate();
        s.getTransaction().commit();
        s.close();
        return true;
    }

    @Override
    public boolean createTableCarOption() {
        return false;
    }
}
