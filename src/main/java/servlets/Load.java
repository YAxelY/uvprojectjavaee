package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Profile;
import daos.ProfileDAO;
import daos.ProfileDAOImpl;

/**
 * Servlet implementation class Load
 */
@WebServlet("/Load")
public class Load extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ProfileDAO profileDAO = new ProfileDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return "";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nomProfile");
      
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telephone = request.getParameter("phone");
        
        Part filePart = request.getPart("photoProfile");
        String fileName = getFileName(filePart);
        
        if (fileName == null || fileName.isEmpty()) {
            request.setAttribute("errorMessage", "File name is invalid.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        
        String uploadPath = getServletContext().getRealPath("") + File.separator + "img";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        File file = new File(uploadPath + File.separator + fileName);
        filePart.write(file.getAbsolutePath());
        
        Profile profile = new Profile();
        profile.setNomProfile(nom);
       
        profile.setEmailProfile(email);
        profile.setPasswordProfile(password);
        profile.setTelephoneProfile(telephone);
        profile.setPhotoProfile("img" + File.separator + fileName);

        try {
            profileDAO.insert(profile);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        response.sendRedirect("success.jsp");
    }
}
