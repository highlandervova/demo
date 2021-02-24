package cache;

import dao.CarDao;
import dao.HibernateCarDao;
import data.Car;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarCache {
    private static Map<String, Car> data = new ConcurrentHashMap<>();
    private static LocalDateTime time = null;

    public static Car getById(String id) {
        if (!hasTime()) updateCache();
        return data.get(id);
    }
    public static Collection<Car> getAllCars() {
        if (!hasTime()) updateCache();
        return data.values();
    }

    private static boolean hasTime() {
        if (time == null) {
            return false;
        }
        LocalDateTime before = LocalDateTime.now().minusMinutes(1);
        return time.isAfter(before);
    }
    private static void updateCache() {
        CarDao carDao = new HibernateCarDao();
        Collection<Car> cars = carDao.getAllCars();
        data = new ConcurrentHashMap<>();
        for (Car c : cars) {
            Car copy = Car.copy(c);
            data.put(copy.getId(), copy);
        }
    }
}
