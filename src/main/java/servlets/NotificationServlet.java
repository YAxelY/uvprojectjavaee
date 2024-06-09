package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Notification;

/**
 * Servlet implementation class NotificationServlet
 */
@WebServlet("/NotificationServlet")
public class NotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private final NotificationDAO notificationDAO = new NotificationDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Récupération de toutes les notifications
	    request.setAttribute("notifications", notificationDAO.getAll());
	    request.getRequestDispatcher("notifications.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des paramètres de la requête
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        String recipient = request.getParameter("recipient");

        // Création de la notification
        Notification notification = new Notification();
        notification.setType(type);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setRecipient(recipient);
        notification.setCreatedAt(new Date()); // Définir la date et l'heure actuelles

        // Enregistrement de la notification
        notificationDAO.save(notification);

        // Redirection vers la page des notifications
        response.sendRedirect(request.getContextPath() + "/notifications");
	}

}
