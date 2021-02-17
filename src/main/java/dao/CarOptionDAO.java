package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarOptionDAO extends PostgreSqlDao {
    //todo: 27 add interface and hibernate support
    public Collection<String> getByCarId(String carId) {
        try (Connection c = getConnection(); Statement st = c.createStatement();) {
            ResultSet rs = st.executeQuery("SELECT option_id FROM public.car_option WHERE car_id='" + carId + "'");
            Collection<String> out = new ArrayList<>();
            while (rs.next()) {
                out.add(rs.getString("option_id"));
            }
            return out;
        } catch (Exception e) {
            System.out.println("Error get options for car;");
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
