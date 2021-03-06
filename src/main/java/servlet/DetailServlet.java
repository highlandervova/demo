package servlet;

import enums.RequestParameter;
import enums.Title;
import service.CarService;
import service.HtmlService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DetailServlet extends HttpServlet {
    HtmlService htmlService = new HtmlService();
    CarService  carService  = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(RequestParameter.ID.getValue());
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(htmlService.getDetailPage(Title.DETAIL.getValue(), carService.getById(id)));
    }
}
