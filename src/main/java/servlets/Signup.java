package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.User;
import daos.UserDAO;
import daos.UserDAOImpl;
import daos.ProfileDAOImpl;
import java.io.*;
import java.sql.SQLException;

@WebServlet("/signup")
public class Signup extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String vue ="login.jsp";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            request.setAttribute("errorMessage1", "All fields are required.");
            request.setAttribute("form", "signup");
            RequestDispatcher rd = request.getRequestDispatcher(vue);
            rd.forward(request, response);
        } else if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage1", "Passwords do not match.");
            request.setAttribute("form", "signup");
            RequestDispatcher rd = request.getRequestDispatcher(vue);
            rd.forward(request, response);
        } else {
        	
            UserDAO userDAO = new UserDAOImpl();
            User newUser = new User();
            newUser.setNomUser(username);
           
            newUser.setPassword(password);
           

            try {
                int result = userDAO.insert(newUser);
                if (result > 0) {
                    request.setAttribute("successMessage", "Signup successful! Please log in.");
                    RequestDispatcher rd = request.getRequestDispatcher(vue);
                    rd.forward(request, response);
                } else {
                    request.setAttribute("errorMessage1", "Error in signup. Please try again.");
                    request.setAttribute("form", "signup");
                    RequestDispatcher rd = request.getRequestDispatcher(vue);
                    rd.forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage1", "Database error: " + e.getMessage());
                request.setAttribute("form", "signup");
                RequestDispatcher rd = request.getRequestDispatcher(vue);
                rd.forward(request, response);
            }
           
        }
    }
}