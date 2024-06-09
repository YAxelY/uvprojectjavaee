import java.sql.Connection;
import java.sql.SQLException;
import beans.User;
import daos.*;

public class TestUser {
    public static void main(String[] args) throws SQLException {
        // Establish database connection
        Connection con = Database.getConnection();
        if (con != null) {
            System.out.println("Database connection successful");
        }

        // Create an instance of UserDAO
        UserDAO userDAO = new UserDAOImpl();

        // Test get user by ID
       User user = userDAO.get(1);
       System.out.println(user); 

        // Test update user
        User userToUpdate = new User();
        userToUpdate.setId(2L);
       userToUpdate.setNomUser("Axel");
       userToUpdate.setAdresseEmail("axel@example.com");
       userToUpdate.setPassword("newpassword123");
       userToUpdate.setRole("user");
       int updateResult = userDAO.update(userToUpdate);
       System.out.println("Update result: " + updateResult);

        // Test get all users
       System.out.println(userDAO.getAll());

        // Test insert user
        User newUser = new User();
        newUser.setNomUser("John");
        newUser.setAdresseEmail("john.doe@example.com");
        newUser.setPassword("password123");
        newUser.setRole("admin");
        int insertResult = userDAO.insert(newUser);
        System.out.println("Insert result: " + insertResult);

        // Test delete user
        User userToDelete = new User();
        userToDelete.setId(3L);
        int deleteResult = userDAO.delete(userToDelete);
        System.out.println("Delete result: " + deleteResult);

        // Close the database connection
        Database.closeConnection(con);
    }
}
