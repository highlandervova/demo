package service;



import cache.OptionCache;
import dao.*;
import data.CarOption;
import data.Option;
import enums.SpringBeanName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import static spring.SpringContextHolder.getBean;

public class OptionService {
  // private OptionDao optionDAO = new OptionDaoImpl();
  private OptionDao optionDao = new HibernateOptionDao();
  //OptionDao optionDao = (OptionDao) getBean(SpringBeanName.OPTION_DAO.getName());
 //  private CarOptionDao carOptionDao = new CarOptionDaoImpl();
  // CarOptionDao carOptionDao = (CarOptionDao) getBean(SpringBeanName.CAR_OPTION_DAO.getName());
  private CarOptionDao carOptionDao = new HibernateCarOptionDao();
    public  OptionService()  { }
    public OptionService(OptionDao optionDao) {
        this.optionDao = optionDao;
    }
    public Collection<Option>  getOptionsByCarId(String carId) {
        Collection<String> optionIds = carOptionDao.getByCarId(carId);
        Collection<Option> out = new ArrayList<>();
        for (String optionId : optionIds) {
            out.add(OptionCache.getById(optionId));
        }
        return out;
    }
    public Collection<Option>   getOptionsByCarIdAdd(String carId) {
        Collection<String> optionIds = carOptionDao.getOptionsByCarIdForAdd(carId);
        Collection<Option> out = new ArrayList<>();
        for (String optionId : optionIds) {
            out.add(optionDao.getById(optionId));
        }
        return out;
    }
    public CarOption addNewOptionCar(String id, String CarId) {
        CarOption co = new CarOption(new Random().nextInt(), id, CarId);
        return carOptionDao.addNewOptionCar(co) ? co : null;
    }
    public boolean removeOptionCar(String CarId, String OptionId) {
       return carOptionDao.removeOptionCar( CarId, OptionId) ;
    }
}
