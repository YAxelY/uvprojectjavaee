package servlets;


import daos.ProfileDAO;
import daos.ProfileDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.Profile;

import java.io.File;
import java.io.IOException;

import java.sql.SQLException;

@WebServlet("/updateProfile")
@MultipartConfig
public class UpdateProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
    

        // Assuming you have a method to get Profile by username
        ProfileDAO profileDAO=new ProfileDAOImpl();
        Profile profile = null ;
        try {
        	profile = profileDAO.get(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(profile);
            response.sendRedirect("error1.jsp");
            return;
        }

        if (profile == null) {
            response.sendRedirect("error2.jsp");
            return;
        }

        boolean updated = false;

        // Update the profile with new values if they are provided
        String nomProfile = request.getParameter("nomProfile");
        if (nomProfile != null && !nomProfile.isEmpty()) {
            profile.setNomProfile(nomProfile);
            updated = true;
        }

        String prenomProfile = request.getParameter("prenomProfile");
        if (prenomProfile != null && !prenomProfile.isEmpty()) {
            profile.setPrenomProfile(prenomProfile);
            updated = true;
        }

        String emailProfile = request.getParameter("emailProfile");
        if (emailProfile != null && !emailProfile.isEmpty()) {
            profile.setEmailProfile(emailProfile);
            updated = true;
        }

        String passwordProfile = request.getParameter("passwordProfile");
        if (passwordProfile != null && !passwordProfile.isEmpty()) {
            profile.setPasswordProfile(passwordProfile);
            updated = true;
        }

        String telephoneProfile = request.getParameter("telephoneProfile");
        if (telephoneProfile != null && !telephoneProfile.isEmpty()) {
            profile.setTelephoneProfile(telephoneProfile);
            updated = true;
        }

        // Handle file upload
        Part filePart = request.getPart("photoProfile");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = filePart.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("") + File.separator + "img" + File.separator;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            filePart.write(uploadPath + fileName);
            profile.setPhotoProfile("img/" + fileName);
            updated = true;
        }

        // Update the profile in the database if any field was updated
        if (updated) {
            try {
                profileDAO.update(profile);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("error3.jsp");
                return;
            }
        }

        response.sendRedirect("Protected/homeClient.jsp");
    }
}
