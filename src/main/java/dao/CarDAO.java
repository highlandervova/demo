package dao;

import data.Car;
import data.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarDAO extends PostgreSqlDao {
    public Collection<Car> getAllCars() {
        try (Connection c = getConnection(); Statement st = c.createStatement();) {
            ResultSet rs = st.executeQuery("SELECT * FROM public.car");
            Collection<Car> out = new ArrayList<>();
            while (rs.next()) {
                out.add(new Car(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("type"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getString("picture")));
            }
            return out;
        } catch (Exception e) {
            System.out.println("Error save user;");
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Collection<Car> getByType(int type) {
        try (Connection c = getConnection(); Statement st = c.createStatement();) {
            ResultSet rs = st.executeQuery("SELECT * FROM public.car WHERE type=" + type);
            Collection<Car> out = new ArrayList<>();
            while (rs.next()) {
                out.add(new Car(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("type"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getString("picture")));
            }
            return out;
        } catch (Exception e) {
            System.out.println("Error save user;");
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    //3) getById for single car
    //4) create table car and add into it 2-3 test caes
    //5) show your 2-3 test cars on main page with all columns

    public boolean add(Car car) {
        int count = 0;
        try (Connection c = getConnection(); Statement st = c.createStatement();) {
            count = st.executeUpdate("INSERT INTO public.car VALUES(\'"+car.getId()+"\', \'"+car.getName()+"\', "+car.getType()+", "+car.getPrice()+", \'"+car.getDescription()+"\', \'"+car.getPicture()+"\')");
        } catch (Exception e) {
            System.out.println("Error save car;");
            e.printStackTrace();
        }
        return count > 0;
    }
}
