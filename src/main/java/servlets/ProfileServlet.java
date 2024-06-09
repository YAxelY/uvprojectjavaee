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

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/uploadProfile")
@MultipartConfig
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProfileDAO profileDAO = new ProfileDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nomProfile");
		String prenom = request.getParameter("prenomProfile");
		String email = request.getParameter("emailProfile");
		String password = request.getParameter("passwordProfile");
		String telephone = request.getParameter("telephoneProfile");
		
		Part filePart = request.getPart("photoProfile");
        String fileName = getFileName(filePart);
        String uploadPath = getServletContext().getRealPath("") + File.separator + "img";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        filePart.write(uploadPath + File.separator + fileName);
        
        Profile profile = new Profile();
        profile.setNomProfile(nom);
        profile.setPrenomProfile(prenom);
        profile.setEmailProfile(email);
        profile.setPasswordProfile(password);
        profile.setTelephoneProfile(telephone);
        profile.setPhotoProfile("img" + File.separator + fileName);

        try {
			profileDAO.insert(profile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.sendRedirect("success.jsp");
		
		
		doGet(request, response);
	}

}
