package dao;

import java.util.Collection;

public interface CarOptionDao {
    Collection<String> getByCarId(String carId);
}
