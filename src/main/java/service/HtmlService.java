package service;

import data.Car;
import enums.CarType;
import enums.RedirectPath;
import dao.CarDAO;

import java.util.Collection;
import java.util.Iterator;

public class HtmlService {

    public String getMainPage(String title) {
        StringBuilder out = new StringBuilder();
        out.append(getHead(title));
        out.append("<h1>Main Page!!!</h1>");
        //add your 5) code here
        out.append("<table>\n");
        Collection<Car> carCollection = new CarDAO().getAllCars();
        Iterator<Car> carIterator = carCollection.iterator();
        for (int j = 0; j < 3; j++) {
              Car car = carIterator.next();
                  out.append("<tr><td>" + car.getName() + "</td>\n" +
                             "<td> <img src=\"" + car.getPicture() + "\"></td>" +
                             "<td>" + CarType.values()[car.getType()-1]  + "</td>\n" +
                             "<td>" + car.getPrice() + "</td>\n" +
                             "<td>" + car.getDescription() + "</td></tr>\n");
        }
        out.append("</table>\n");
        out.append("<form action='");
        out.append(RedirectPath.FIRST_PAGE.getValue());
        out.append("' method='GET'>\n");
        out.append("    <input type='submit' value='To First Page'>\n");
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
        out.append("</title></head><body>");
        out.append("<meta charset=\"utf-8\">");
        return out.toString();
    }

    private String getEnd() {
        return "</body></html>";
    }
}
