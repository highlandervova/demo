package service;

import data.Car;
import data.Option;
import enums.CarType;
import enums.RedirectPath;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HtmlService {

    public String getMainPage(String title, Collection<Car> cars) {
        StringBuilder out = new StringBuilder();
        out.append(getHead(title));
        out.append("<h1>Car Dealer Shop</h1>");
        out.append("<table><tr><th>NAME</th><th>TYPE</th><th>PRICE</th><th>DESCRIPTION</th><th>PICTURE</th></tr>");
        for (Car c : cars) {
            out.append("<tr><td>");
            out.append(c.getName());
            out.append("</td><td>");
            switch (c.getType()) {
                case 1:
                    out.append(CarType.SEDAN.name());
                    break;
                case 2:
                    out.append(CarType.HATCHBACK.name());
                    break;
                case 3:
                    out.append(CarType.CROSSOVER.name());
            }
            out.append("</td><td><h2>");
            out.append(c.getPrice());
            out.append("</h2> <h4>USD</h4>");
            out.append("</td><td>");
            out.append(c.getDescription());
            out.append("</td><td>");
            out.append("<a href='");
            out.append(RedirectPath.DETAIL_PAGE.getValue());
            out.append("?id=");
            out.append(c.getId());
            out.append("'><img style='width: 100px;' src='");
            out.append(c.getPicture());
            out.append("' alt='No Picture'/></a>");
            out.append("</td><td>");
            out.append("<h1>Options:</h1>");
            out.append("<form action='");
            out.append(RedirectPath.OPTION_PAGE.getValue());
            out.append("' method='GET'>\n");
            out.append("    <input type='hidden' name='carId' value='"+c.getId()+"'>");
            out.append("    <input type='submit' value='Edit options'>\n");
            out.append("</form>");
            for (Option o : c.getOptions()) {
                out.append(o.toString());
                out.append(" ");
                //todo: 26: options in table;
            }
            out.append("</td></tr>");
        }
        out.append("</table>");
        out.append("<form action='");
        out.append(RedirectPath.ADD_PAGE.getValue());
        out.append("' method='GET'>\n");
        out.append("    <input type='submit' value='Add New Car'>\n");
        out.append("</form>");
        out.append("<form action='");
        out.append(RedirectPath.FIRST_PAGE.getValue());
        out.append("' method='GET'>\n");
        out.append("    <input type='submit' value='To First Page'>\n");
        out.append("</form>");
        out.append(getEnd());
        return out.toString();
    }

    public String getOptionPage(String title, Collection<Option> availableOptions, Collection<Option> extendedOptions, String carId) {
        StringBuilder out = new StringBuilder();
        out.append(getHead(title));
        out.append("<h1>Available Options:</h1>");
        for (Option o : availableOptions) {
            out.append("<h2>" + o.getName() + "</h2>");
            out.append("<form action='");
            out.append(RedirectPath.OPTION_PAGE.getValue());
            out.append("' method='POST'>\n");
            out.append("    <input type='hidden' name='carId' value='" + carId + "'>");
            out.append("    <input type='hidden' name='optionId' value='" + o.getId() + "'>");
            out.append("    <input type='submit' value='Remove'>\n");
            out.append("</form>");
        }
        out.append("<h1>Extended Options:");
        for (Option o : extendedOptions) {
            out.append("<h2>" + o.getName() + "</h2>");
            out.append("<form action='");
            out.append(RedirectPath.OPTION_PAGE.getValue());
            out.append("' method='POST'>\n");
            out.append("    <input type='hidden' name='carId' value='" + carId + "'>");
            out.append("    <input type='hidden' name='optionId' value='" + o.getId() + "'>");
            out.append("    <input type='submit' value='Add'>\n");
            out.append("</form>");
        }
        out.append(getEnd());
        return out.toString();
    }

    public String getAddPage(String title) {
        StringBuilder out = new StringBuilder();
        out.append(getHead(title));
        out.append("<form action='");
        out.append(RedirectPath.ADD_PAGE.getValue());
        out.append("' method='POST'>\n");
        out.append("    Enter Car Name: <input type='text' name='name'></br>\n");
        out.append("    Enter Description: <input type='text' name='description'></br>\n");
        out.append("    Enter Type: <input type='number' name='type'></br>\n");
        out.append("    Enter Price: <input type='number' name='price'></br>\n");
        out.append("    Enter Picture link: <input type='text' name='picture'></br>\n");
        out.append("    <input type='submit' value='Add Car'>\n");
        out.append("</form>");
        out.append("<form action='");
        out.append(RedirectPath.MAIN_PAGE.getValue());
        out.append("' method='GET'>\n");
        out.append("    <input type='submit' value='To Main Page'>\n");
        out.append("</form>");
        out.append(getEnd());
        return out.toString();
    }

    public String getAuthPage(String title) {
        StringBuilder out = new StringBuilder();
        out.append(getHead(title));
        out.append("<form action='");
        out.append(RedirectPath.AUTH_PAGE.getValue());
        out.append("' method='POST'>\n");
        out.append("    Enter Login: <input type='text' name='login'>\n");
        out.append("    Enter Pass: <input type='password' name='pass'>\n");
        out.append("    <input type='submit' value='Authenticate'>\n");
        out.append("</form>");
        out.append("<form action='");
        out.append(RedirectPath.FIRST_PAGE.getValue());
        out.append("' method='GET'>\n");
        out.append("    <input type='submit' value='To First Page'>\n");
        out.append("</form>");
        out.append(getEnd());
        return out.toString();
    }

    public String getRegPage(String title) {
        StringBuilder out = new StringBuilder();
        out.append(getHead(title));
        out.append("<form action='");
        out.append(RedirectPath.REG_PAGE.getValue());
        out.append("' method='POST'>\n");
        out.append("    Enter Login: <input type='text' name='login'>\n");
        out.append("    Enter Pass: <input type='password' name='pass1'>\n");
        out.append("    Enter again: <input type='password' name='pass2'>\n");
        out.append("    <input type='submit' value='Register'>\n");
        out.append("</form>");
        out.append("<form action='");
        out.append(RedirectPath.FIRST_PAGE.getValue());
        out.append("' method='GET'>\n");
        out.append("    <input type='submit' value='To First Page'>\n");
        out.append("</form>");
        out.append(getEnd());
        return out.toString();
    }

    private String getHead(String title) {
        StringBuilder out = new StringBuilder();
        out.append("<html><head><title>");
        out.append(title);
        out.append("</title>");
        out.append("<style type='text/css'>" +
                "TABLE {border-collapse: collapse;}" +
                "TD, TH {padding: 3px;border: 1px solid black;}" +
                "TH {background: #b0e0e6;}</style>");
        out.append("</head><body>");
        return out.toString();
    }

    private String getEnd() {
        return "</body></html>";
    }

    public String getDetailPage(String title, Car c) {
        StringBuilder out = new StringBuilder();
        out.append(getHead(title));
        out.append("<h1>Car Dealer Shop</h1>");
        out.append("<table>");
        out.append("<tr><td>");
        out.append("Name");
        out.append("</td><td>");
        out.append(c.getName());
        out.append("</td></tr>");
        out.append("<tr><td>");
        out.append("Description");
        out.append("</td><td>");
        out.append(c.getDescription());
        out.append("</td></tr>");
        out.append("<tr><td>");
        out.append("Price");
        out.append("</td><td>");
        out.append(c.getPrice());
        out.append("</td></tr>");
        out.append("<tr><td>");
        out.append("Type");
        out.append("</td><td>");
        switch (c.getType()) {
            case 1:
                out.append(CarType.SEDAN.name());
                break;
            case 2:
                out.append(CarType.HATCHBACK.name());
                break;
            case 3:
                out.append(CarType.CROSSOVER.name());
        }
        out.append("</td></tr>");
        out.append("<tr><td>");
        out.append("Picture");
        out.append("</td><td>");
        out.append("<img src='");
        out.append(c.getPicture());
        out.append("' alt='No Picture'/>");
        out.append("</td></tr>");
        out.append("<tr><td>");
        out.append("Options");
        out.append("</td><td>");
        for (Option o : c.getOptions()) {
            out.append(o.toString());
            out.append("</br>");
        }
        out.append("</td></tr>");
        out.append("</table>");
        out.append("<form action='");
        out.append(RedirectPath.MAIN_PAGE.getValue());
        out.append("' method='GET'>\n");
        out.append("    <input type='submit' value='To Main Page'>\n");
        out.append("</form>");
        out.append(getEnd());
        return out.toString();
    }
}
