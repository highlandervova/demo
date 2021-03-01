package controller;

import dao.CarDao;
import data.Car;
import enums.RedirectPath;
import enums.SessionAttribute;
import enums.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getSession().getAttribute(SessionAttribute.AUTHENTICATED.getValue()) != null) {
            ModelAndView out = new ModelAndView("main");
            String title = Title.MAIN_PAGE.getValue();
            out.addObject("title", title);
            Collection<Car> cars = carService.getAllCars();
            out.addObject("cars", cars);
            return out;
        } else {
            resp.sendRedirect(RedirectPath.AUTH_PAGE.getValue());
            return null;
        }
    }
}
