package app.servlets;

import app.entities.Product;
import app.model.ConverterToJson;
import app.model.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, Product> products = ProductDB.select();
        ConverterToJson.toJson();
        req.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/views/welcome.jsp").forward(req, resp);

    }
}
