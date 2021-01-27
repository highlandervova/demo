package servlet;

import enums.RedirectPath;
import enums.SessionAttribute;
import enums.Title;
import service.HtmlService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(SessionAttribute.AUTHENTICATED.getValue()) != null) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            HtmlService htmlService = new HtmlService();
            out.println(htmlService.getMainPage(Title.MAIN_PAGE.getValue()));
        } else {
            resp.sendRedirect(RedirectPath.AUTH_PAGE.getValue());
        }
    }
}
