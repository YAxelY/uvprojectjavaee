package servlets;


import daos.AuthDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Store the requested URL in the session
//        String requestedUrl = request.getRequestURI();
//        String queryString = request.getQueryString();
//        if (queryString != null) {
//            requestedUrl += "?" + queryString;
//        }

       
        AuthDAO authDAO = new  AuthDAO();
        if (authDAO.authenticate(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
//            session.setMaxInactiveInterval(1 * 1);
//            response.sendRedirect((String)requestedUrl); // Redirect to the protected resource after successful login
            response.sendRedirect("homeGuest.jsp"); 
        } else {
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
