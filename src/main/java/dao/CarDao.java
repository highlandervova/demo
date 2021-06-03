package dao;

import data.Car;
import java.util.Collection;

public interface CarDao {
    Collection<Car> getAllCars();
    Collection<Car> getByType(int type);
    Car getById(String id);
    boolean add(Car car);
}
