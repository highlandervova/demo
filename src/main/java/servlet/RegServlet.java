package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Authentication</title></head><body>");
        out.println("<form action='/demo_war_exploded/reg' method='POST'>\n" +
                "    Enter Login: <input type='text' name='login'>\n" +
                "    Enter Pass: <input type='password' name='pass1'>\n" +
                "    Enter again: <input type='password' name='pass2'>\n" +
                "    <input type='submit' value='Register'>\n" +
                "</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo registration process with checks
    }
}
