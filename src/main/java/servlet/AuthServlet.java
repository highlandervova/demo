package servlet;

import dao.UserDao;
import dao.UserDaoImpl;
import data.User;
import enums.*;
import service.HtmlService;
import service.UserService;
import spring.SpringContextHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static spring.SpringContextHolder.getBean;

public class AuthServlet extends HttpServlet {
    //UserService uServ = new UserService();
    private UserService uServ = (UserService) getBean(SpringBeanName.USER_SERVICE.getName());


    private HtmlService htmlService = (HtmlService) getBean(SpringBeanName.HTML_SERVICE.getName());
    //HtmlService htmlService = new HtmlService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(htmlService.getAuthPage(Title.AUTHENTICATION.getValue()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(RequestParameter.LOGIN.getValue());
        String pass = req.getParameter(RequestParameter.PASS.getValue());
        User u = uServ.getByLogin(login);
        if (uServ.checkUserPassword(u, pass)) {
            req.getSession().setAttribute(SessionAttribute.AUTHENTICATED.getValue(), u);
            resp.sendRedirect(RedirectPath.MAIN_PAGE.getValue());
        } else {
            resp.sendRedirect(RedirectPath.FIRST_PAGE.getValue());
        }
    }
}
