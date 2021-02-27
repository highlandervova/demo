package servlet;

import data.Car;
import data.CarOption;
import data.Option;
import enums.RedirectPath;
import enums.RequestParameter;
import enums.SessionAttribute;
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
       // Collection<Option> allOptions = optionService.getOptionsByCarId(carId);

        Collection<Option> addOptions = optionService.getOptionsByCarIdAdd(carId);

        Car c = carService.getById(carId);
             //todo: 27 exclude redundant options;
        out.println(htmlService.getOptionPage(Title.OPTIONS.getValue(), c.getOptions(), addOptions, carId));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter(RequestParameter.CAR_ID.getValue());
        String optionId = req.getParameter(RequestParameter.OPTION_ID.getValue());


       if(   req.getParameter(RequestParameter.ADD.getValue()) != null){
           CarOption co = new OptionService().addNewOptionCar(carId, optionId );
           if (co != null) {

               resp.sendRedirect(RedirectPath.MAIN_PAGE.getValue());
           } else {
               resp.sendRedirect(RedirectPath.FIRST_PAGE.getValue());
           }
        }


        if(   req.getParameter(RequestParameter.REMOVE.getValue()) != null){
           boolean boolTrue = new OptionService().removeOptionCar(carId, optionId );
            if (  boolTrue )
             {

                resp.sendRedirect(RedirectPath.MAIN_PAGE.getValue());
            } else {
                resp.sendRedirect(RedirectPath.FIRST_PAGE.getValue());
            }
        }


        //todo: 27 implement doPost
    }
}
