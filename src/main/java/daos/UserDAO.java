package daos;
import java.sql.SQLException;

import beans.User;

public interface UserDAO  extends DAO<User> {
	User getByUsername(String username) throws SQLException; // Add this method
	User getByEmail(String email) throws SQLException; // Add this method
}
