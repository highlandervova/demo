package service;

import cache.CarCache;
import dao.CarDao;

import dao.HibernateCarDao;
import data.Car;
import enums.SpringBeanName;

import java.util.Collection;
import java.util.UUID;

import static spring.SpringContextHolder.getBean;
import static util.StringUtil.isNotEmpty;

public class CarService {
//    CarDao carDAO = new HibernateCarDao();
    private CarDao carDAO = (CarDao) getBean(SpringBeanName.CARDAO.getName());
  //  OptionService optionService = new OptionService();
    private OptionService optionService = (OptionService) getBean(SpringBeanName.OPTION_SERVICE.getName());

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
        Collection<Car> out = CarCache.getAllCars();
        for (Car c : out) {
            c.setOptions(optionService.getOptionsByCarId(c.getId()));
        }
        return out;
    }

    public Car getById(String id) {
        Car out = CarCache.getById(id);
        out.setOptions(optionService.getOptionsByCarId(out.getId()));
        return out;
    }

    public Collection<Car> getByType(int type) {
        Collection<Car> out = carDAO.getByType( type);
        for (Car c : out) {
            c.setOptions(optionService.getOptionsByCarId(c.getId()));
        }
        return out;
    }

}
