package servlet;

import data.User;
import enums.RedirectPath;
import enums.RequestParameter;
import enums.SessionAttribute;
import enums.Title;
import service.HtmlService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthServlet extends HttpServlet {
    private UserService uServ = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HtmlService htmlService = new HtmlService();
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
