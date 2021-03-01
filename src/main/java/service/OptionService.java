package service;

import dao.CarOptionDao;
import dao.OptionDAO;
import data.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class OptionService {
    private OptionDAO optionDAO = new OptionDAO();
    @Autowired
    private CarOptionDao carOptionDAO;

    public Collection<Option> getOptionsByCarId(String carId) {
        Collection<String> optionIds = carOptionDAO.getByCarId(carId);
        Collection<Option> out = new ArrayList<>();
        for (String optionId : optionIds) {
            out.add(optionDAO.getById(optionId));//todo: 27 OptionCache
        }
        return out;
    }
}
