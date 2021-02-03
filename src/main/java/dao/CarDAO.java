package dao;

import data.Car;

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
            System.out.println("Error get all cars;");
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
            System.out.println("Error get cars by type;");
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Car getById(String id) {
        try (Connection c = getConnection(); Statement st = c.createStatement();) {
            ResultSet rs = st.executeQuery("SELECT * FROM public.car WHERE id='" + id +"'");
            if (rs.next()) {
                return new Car(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("type"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getString("picture"));
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error get car by id;");
            e.printStackTrace();
            return null;
        }
    }

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
