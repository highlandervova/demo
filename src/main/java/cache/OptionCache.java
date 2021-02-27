package cache;

import dao.CarDao;
import dao.HibernateCarDao;
import dao.HibernateOptionDao;
import dao.OptionDao;
import data.Car;
import data.Option;

import java.time.LocalDateTime;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OptionCache {

    private static Map<String, Option> data = new ConcurrentHashMap<>();
    private static LocalDateTime time = null;

       public static Option getById(String id) {
        if (!hasTime()) updateCache();
        return data.get(id);
    }



    private static boolean hasTime() {
        if (time == null) {
            return false;
        }
        LocalDateTime before = LocalDateTime.now().minusMinutes(1);
        return time.isAfter(before);
    }
    private static void updateCache() {
        OptionDao optionDao = new HibernateOptionDao();
        Collection<Option> options = optionDao.getAllOptions();
        data = new ConcurrentHashMap<>();
        for (Option o : options) {
            data.put(o.getId(), o);
        }
    }

}
