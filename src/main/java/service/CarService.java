package service;

import dao.CarDAO;
import data.Car;

import java.util.Collection;
import java.util.UUID;

import static util.StringUtil.isNotEmpty;

public class CarService {
    CarDAO carDAO = new CarDAO();
    OptionService optionService = new OptionService();

    public boolean checkAddCarParameters(String name, String desc, String picture, Integer type, Integer price) {
        return isNotEmpty(name) && isNotEmpty(desc) && isNotEmpty(picture) &&
                type != null && type >= 1 && type <= 3 &&
                price != null & price > 0;
    }

    public Car addNewCar(String name, String desc, Integer type, Integer price, String picture) {
        Car c = new Car(UUID.randomUUID().toString(), name, type, price, desc, picture);
        return carDAO.add(c) ? c : null;
    }

    public Collection<Car> getAllCars() {
        Collection<Car> out = carDAO.getAllCars();
        for (Car c : out) {
            c.setOptions(optionService.getOptionsByCarId(c.getId()));
        }
        return out;
    }

    public Car getById(String id) {
        Car out = carDAO.getById(id);
        out.setOptions(optionService.getOptionsByCarId(out.getId()));
        return out;
    }
}
