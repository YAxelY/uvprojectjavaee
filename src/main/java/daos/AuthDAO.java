package daos;

import java.sql.SQLException;
import beans.User;

public class AuthDAO {

    public boolean authenticate(String identifier, String password) {
        UserDAO userDAO = new UserDAOImpl();
        try {
            User userByUsername = userDAO.getByUsername(identifier);
            User userByEmail = userDAO.getByEmail(identifier);

            if (userByUsername != null && userByUsername.getPassword().equals(password)) {
                return true;
            } else if (userByEmail != null && userByEmail.getPassword().equals(password)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
