package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.*;
import beans.Profile;

@WebServlet("/viewController")
public class ViewController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProfileDAO profileDAO = new ProfileDAOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProfileStr = request.getParameter("idProfile");
        String username = request.getParameter("username");

        // Convert idProfileStr to an integer
        int idProfile = Integer.parseInt(idProfileStr);

        // Fetch the profile based on idProfile
        // This is just a placeholder. Replace it with your actual code to fetch the profile.
        Profile profile = null;
		try {
			profile = profileDAO.get(idProfile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Set the profile in the request attribute to be accessed in the JSP
        request.setAttribute("profile", profile);

        // Forward the request to view.jsp
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }
}
