package app.servlets;


import app.entities.User;
import app.model.ConnectingDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        ConnectingDB signUpUser = new ConnectingDB();
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        User userFromDB = new User();
        userFromDB.setEmail(email);
        boolean result = signUpUser.getUserForChecking(userFromDB);
        if (login.isEmpty() && email.isEmpty() && password.isEmpty()) {
            req.setAttribute("errorMessageLogin", "Invalid login");
            req.setAttribute("errorMessageEmail", "Invalid email");
            req.setAttribute("errorMessagePassword", "Invalid password");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
        else if (result) {
            req.setAttribute("error", "User exists with this email");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }

        else {
            signUpUser.signUp(user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/auth.jsp");
            requestDispatcher.forward(req, resp);
        }



    }
}
