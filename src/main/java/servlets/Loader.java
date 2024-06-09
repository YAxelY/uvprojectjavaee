package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import beans.Profile;
import daos.ProfileDAO;
import daos.ProfileDAOImpl;

@WebServlet("/load")
public class Loader extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Loader() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfileDAO profileDAO = new ProfileDAOImpl();
        try {
            List<Profile> profiles = profileDAO.getAll();
            request.setAttribute("profiles", profiles);
            RequestDispatcher rd = request.getRequestDispatcher("homeGuest.jsp");
            rd.forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
