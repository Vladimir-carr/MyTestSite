package app.servlets;

import app.entities.User;
import app.model.ConnectingDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Authorization extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        ConnectingDB auth = new ConnectingDB();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        if (auth.getUser(user)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", email);
            System.out.println(email + " found!");
            resp.sendRedirect("welcome");
        }else {
            req.setAttribute("errorMessage", "Invalid email or password. Try again");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/auth.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
