package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import beans.Profile;
import daos.ProfileDAO;
import daos.ProfileDAOImpl;

@WebServlet("/uploadProfile")
@MultipartConfig
public class UploadProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProfileDAO profileDAO = new ProfileDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request
    }

    private String getFileName(Part part) {
        if (part == null) {
            return null;
        }
        String contentDisp = part.getHeader("content-disposition");
        if (contentDisp == null) {
            return null;
        }
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
        String password = request.getParameter("passwordProfile");

        // Check if nomProfile and passwordProfile are not null or empty
        if (nom == null || nom.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "NomProfile and PasswordProfile are required.");
            request.getRequestDispatcher("error1.jsp").forward(request, response);
            return;
        }

        String prenom = request.getParameter("prenomProfile");
        String email = request.getParameter("emailProfile");
        String telephone = request.getParameter("telephoneProfile");

        Part filePart = request.getPart("photoProfile");
        String fileName = getFileName(filePart);

        if (filePart != null && fileName != null && !fileName.isEmpty()) {
            String uploadPath = getServletContext().getRealPath("") + File.separator + "img";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            File file = new File(uploadPath + File.separator + fileName);
            filePart.write(file.getAbsolutePath());
        }

        Profile profile = new Profile();
        profile.setNomProfile(nom);
        profile.setPasswordProfile(password);
        if (prenom != null && !prenom.isEmpty()) {
            profile.setPrenomProfile(prenom);
        }
        if (email != null && !email.isEmpty()) {
            profile.setEmailProfile(email);
        }
        if (telephone != null && !telephone.isEmpty()) {
            profile.setTelephoneProfile(telephone);
        }
        if (filePart != null && fileName != null && !fileName.isEmpty()) {
            profile.setPhotoProfile("img" + File.separator + fileName);
        }

        try {
            profileDAO.insert(profile);
            response.sendRedirect("protected/homeClient.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
