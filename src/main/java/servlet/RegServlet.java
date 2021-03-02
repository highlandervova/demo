package servlet;

import data.User;
import enums.*;
import service.HtmlService;
import service.OptionService;
import service.UserService;
import service.ValidationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static spring.SpringContextHolder.getBean;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //HtmlService htmlService = new HtmlService();
        HtmlService htmlService = (HtmlService) getBean(SpringBeanName.HTML_SERVICE.getName());

     //ValidationService validationService = (ValidationService) getBean(SpringBeanName.VALIDATION_SERVICE.getName());
        out.println(htmlService.getRegPage(Title.REGISTRATION.getValue()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     ValidationService validationService = (ValidationService) getBean(SpringBeanName.VALIDATION_SERVICE.getName());

        String login = req.getParameter(RequestParameter.LOGIN.getValue());
        String pass1 = req.getParameter(RequestParameter.PASS1.getValue());
        String pass2 = req.getParameter(RequestParameter.PASS2.getValue());

        if (validationService.validateRegistration(login, pass1, pass2)) {
            User u = ((UserService) getBean(SpringBeanName.USER_SERVICE.getName())).addNewUser(login, pass1);
            //User u = new service.UserService().addNewUser(login, pass1);

            if (u != null) {
                req.getSession().setAttribute(SessionAttribute.AUTHENTICATED.getValue(), u);
                resp.sendRedirect(RedirectPath.MAIN_PAGE.getValue());
            } else {
                resp.sendRedirect(RedirectPath.FIRST_PAGE.getValue());
            }
        } else {
            resp.sendRedirect(RedirectPath.FIRST_PAGE.getValue());
        }
    }
}
