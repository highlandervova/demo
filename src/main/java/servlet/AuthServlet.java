package servlet;

import dao.UserDAO;
import data.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Authentication</title></head><body>");
        out.println("<form action='/demo_war_exploded/auth' method='POST'>\n" +
                    "    Enter Login: <input type='text' name='login'>\n" +
                    "    Enter Pass: <input type='password' name='pass'>\n" +
                    "    <input type='submit' value='Authenticate'>\n" +
                    "</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        UserDAO uDao = new UserDAO();
        User u = uDao.getByLogin(login);
        if (u != null && u.getPass().equals(pass)) {
            req.getSession().setAttribute("authenticated", u);
            resp.sendRedirect("/demo_war_exploded/main");
        } else {
            resp.sendRedirect("/demo_war_exploded/index.jsp");
        }
    }
}
