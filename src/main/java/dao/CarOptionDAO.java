package dao;

import data.CarOption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public interface CarOptionDao {
    public Collection<String> getByCarId (String carId);

    public Collection<String> getOptionsByCarIdForAdd (String carId);



    boolean  addNewOptionCar(CarOption co);
    boolean  removeOptionCar(String carId, String optionalId);

    //getOptionsByCarIdForRemove

    public boolean createTableCarOption() ;

    }
