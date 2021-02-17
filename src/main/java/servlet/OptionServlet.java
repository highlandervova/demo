package servlet;

import data.Car;
import data.Option;
import enums.RequestParameter;
import enums.Title;
import service.CarService;
import service.HtmlService;
import service.OptionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class OptionServlet extends HttpServlet {
    private HtmlService   htmlService   = new HtmlService();
    private OptionService optionService = new OptionService();
    private CarService    carService    = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter(RequestParameter.CAR_ID.getValue());
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Collection<Option> allOptions = optionService.getOptionsByCarId(carId);
        Car c = carService.getById(carId);
        //todo: 27 exclude redundant options;
        out.println(htmlService.getOptionPage(Title.OPTIONS.getValue(), allOptions, c.getOptions(), carId));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo: 27 implement doPost
    }
}
