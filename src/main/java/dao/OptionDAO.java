package dao;

import data.Option;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OptionDAO extends PostgreSqlDao {
    //todo: 27 add interface and hibernate support
    public Option getById(String id) {
        try (Connection c = getConnection(); Statement st = c.createStatement();) {
            ResultSet rs = st.executeQuery("SELECT * FROM public.option WHERE id='" + id + "'");
            Option out = new Option();
            if (rs.next()) {
                out.setId(rs.getString("id"));
                out.setName(rs.getString("name"));
                out.setColor(rs.getInt("color"));
            }
            return out;
        } catch (Exception e) {
            System.out.println("Error get options by id;");
            e.printStackTrace();
            return null;
        }
    }
}
