package dao;

import data.Car;
import data.Option;

import java.util.Collection;

public interface OptionDao {
    public Option getById(String id);
    Collection<Option> getAllOptions();

    public boolean createTableOption() ;

    }
