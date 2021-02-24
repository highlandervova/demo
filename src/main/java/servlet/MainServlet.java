package servlet;

import enums.RedirectPath;
import enums.SessionAttribute;
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

public class MainServlet extends HttpServlet {
    HtmlService htmlService = (HtmlService) getBean(SpringBeanName.HTML_SERVICE.getName());
    CarService carService   = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(SessionAttribute.AUTHENTICATED.getValue()) != null) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println(htmlService.getMainPage(Title.MAIN_PAGE.getValue(), carService.getAllCars()));
        } else {
            resp.sendRedirect(RedirectPath.AUTH_PAGE.getValue());
        }
    }
}
