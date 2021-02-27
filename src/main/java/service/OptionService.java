package service;


import cache.CarCache;
import cache.OptionCache;
import dao.*;
//import dao.OptionDAO;
import data.Car;
import data.CarOption;
import data.Option;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class OptionService {
  // private OptionDao optionDAO = new OptionDaoImpl();
  private OptionDao optionDAO = new HibernateOptionDao();
  private CarOptionDao carOptionDAO = new CarOptionDaoImpl();
 // private CarOptionDao carOptionDAO = new HibernateCarOptionDao();




    public Collection<Option>  getOptionsByCarId(String carId) {
        Collection<String> optionIds = carOptionDAO.getByCarId(carId);
        Collection<Option> out = new ArrayList<>();
        for (String optionId : optionIds) {
            //out.add(optionDAO.getById(optionId));//todo: 27 OptionCache
            out.add(OptionCache.getById(optionId));

        }
        return out;
    }
    public Collection<Option>   getOptionsByCarIdAdd(String carId) {
        Collection<String> optionIds = carOptionDAO.getOptionsByCarIdForAdd(carId);
        Collection<Option> out = new ArrayList<>();
        for (String optionId : optionIds) {
            out.add(optionDAO.getById(optionId));

        }
        return out;
    }

//
//    public Collection<Car> getAllCars() {
//        Collection<Car> out = CarCache.getAllCars();
//        for (Car c : out) {
//            c.setOptions(optionService.getOptionsByCarId(c.getId()));
//        }
//        return out;
//    }
//
//    public Car getById(String id) {
//        Car out = CarCache.getById(id);
//        out.setOptions(optionService.getOptionsByCarId(out.getId()));
//        return out;
//    }
//
    public CarOption addNewOptionCar(String id, String CarId) {
        CarOption co = new CarOption(new Random().nextInt(), id, CarId);
        return carOptionDAO.addNewOptionCar(co) ? co : null;
    }

    public boolean removeOptionCar(String CarId, String OptionId) {
       return carOptionDAO.removeOptionCar( CarId, OptionId) ;

    }

}
