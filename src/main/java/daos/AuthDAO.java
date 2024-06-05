package daos;


public class AuthDAO {
    public boolean authenticate(String username, String password) {
        // For demonstration purposes, we're using hardcoded values.
        // In a real application, you'd query the database or another user store.
        return "admin".equals(username) && "password".equals(password);
    }
}
