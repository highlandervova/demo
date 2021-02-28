package servlet;

import enums.RedirectPath;
import enums.RequestParameter;
import enums.SpringBeanName;
import enums.Title;
import service.CarService;
import service.HtmlService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static spring.SpringContextHolder.getBean;

public class AddServlet extends HttpServlet {


    CarService carService = new CarService();
    //CarService carService = (CarService) getBean(SpringBeanName.CAR_SERVICE.getName());


    HtmlService htmlService = (HtmlService) getBean(SpringBeanName.HTML_SERVICE.getName());
   // HtmlService htmlService = new HtmlService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(htmlService.getAddPage(Title.AUTHENTICATION.getValue()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(RequestParameter.NAME.getValue());
        String description = req.getParameter(RequestParameter.DESCRIPTION.getValue());
        String picture = req.getParameter(RequestParameter.PICTURE.getValue());
        Integer type = Integer.valueOf(req.getParameter(RequestParameter.TYPE.getValue()));
        Integer price = Integer.valueOf(req.getParameter(RequestParameter.PRICE.getValue()));
        if (carService.checkAddCarParameters(name, description, picture, type, price)) {
            carService.addNewCar(name, description, type, price, picture);
        }
        resp.sendRedirect(RedirectPath.MAIN_PAGE.getValue());
    }
}
