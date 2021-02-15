package service;

import dao.CarOptionDAO;
import dao.OptionDAO;
import data.Option;

import java.util.ArrayList;
import java.util.Collection;

public class OptionService {
    private OptionDAO optionDAO = new OptionDAO();
    private CarOptionDAO carOptionDAO = new CarOptionDAO();

    public Collection<Option> getOptionsByCarId(String carId) {
        Collection<String> optionIds = carOptionDAO.getByCarId(carId);
        Collection<Option> out = new ArrayList<>();
        for (String optionId : optionIds) {
            out.add(optionDAO.getById(optionId));
        }
        return out;
    }
}
