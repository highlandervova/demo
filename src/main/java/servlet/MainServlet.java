package servlet;

import enums.*;
import service.CarService;
import service.HtmlService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static spring.SpringContextHolder.getBean;

public class MainServlet extends HttpServlet {
    //HtmlService htmlService = new HtmlService();
     HtmlService htmlService = (HtmlService) getBean(SpringBeanName.HTML_SERVICE.getName());


     CarService carService   = new CarService();
  //  CarService carService = (CarService) getBean(SpringBeanName.CAR_SERVICE.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer type = null;
        if (req.getSession().getAttribute(SessionAttribute.AUTHENTICATED.getValue()) != null) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
 //           out.println(htmlService.getMainPage(Title.MAIN_PAGE.getValue(), carService.getAllCars()));

            if ( req.getParameter(RequestParameter.TYPE.getValue()) == null )


            {
                out.println(htmlService.getMainPage(Title.MAIN_PAGE.getValue(), carService.getAllCars()));
            }
            else
            {


                type =   Integer.parseInt(req.getParameter(RequestParameter.TYPE.getValue()));
                out.println(htmlService.getMainPage(Title.MAIN_PAGE.getValue(), carService.getByType(type)));


            }


        } else {
            resp.sendRedirect(RedirectPath.AUTH_PAGE.getValue());
        }
    }
}
