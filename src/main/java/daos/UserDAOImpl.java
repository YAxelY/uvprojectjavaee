package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public User get(int id) throws SQLException {
        Connection con = Database.getConnection();
        User user = null;
        String sql = "SELECT id, nomUser, adresseEmail, password, role FROM utilisateurs WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setNomUser(rs.getString("nom_user"));
            user.setAdresseEmail(rs.getString("adresse_email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        }
        Database.closeResultSet(rs);
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        Connection con = Database.getConnection();
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, nom_user, adresse_email, password, role FROM utilisateurs";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setNomUser(rs.getString("nom_user"));
            user.setAdresseEmail(rs.getString("adresse_email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            users.add(user);
        }
        Database.closeResultSet(rs);
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return users;
    }

    @Override
    public int save(User user) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "UPDATE utilisateurs SET nom_user = ?, adresse_email = ?, password = ?, role = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getNomUser());
        ps.setString(2, user.getAdresseEmail());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getRole());
        ps.setLong(5, user.getId());
        int result = ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return result;
    }

    @Override
    public int insert(User user) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "INSERT INTO utilisateurs (nom_user, adresse_email, password, role) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getNomUser());
        ps.setString(2, user.getAdresseEmail());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getRole());
        int result = ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return result;
    }

    @Override
    public int delete(User user) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "DELETE FROM utilisateurs WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, user.getId());
        int result = ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return result;
    }

    @Override
    public int update(User user) throws SQLException {
        Connection con = Database.getConnection();
        StringBuilder sql = new StringBuilder("UPDATE utilisateurs SET ");
        List<Object> parameters = new ArrayList<>();
        
        if (user.getNomUser() != null) {
            sql.append("nom_user = ?, ");
            parameters.add(user.getNomUser());
        }
        if (user.getAdresseEmail() != null) {
            sql.append("adresse_email = ?, ");
            parameters.add(user.getAdresseEmail());
        }
        if (user.getPassword() != null) {
            sql.append("password = ?, ");
            parameters.add(user.getPassword());
        }
        if (user.getRole() != null) {
            sql.append("role = ?, ");
            parameters.add(user.getRole());
        }
        
        // Remove the last comma and space
        sql.setLength(sql.length() - 2);
        
        sql.append(" WHERE id = ?");
        parameters.add(user.getId());
        
        PreparedStatement ps = con.prepareStatement(sql.toString());
        
        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }
        
        int result = ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return result;
    }
    
    
    @Override
    public User getByUsername(String username) throws SQLException {
        Connection con = Database.getConnection();
        User user = null;
        String sql = "SELECT id, nom_user, adresse_email, password, role FROM utilisateurs WHERE nom_user = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setNomUser(rs.getString("nom_user"));
            user.setAdresseEmail(rs.getString("adresse_email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        }
        Database.closeResultSet(rs);
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return user;
    }

    @Override
    public User getByEmail(String email) throws SQLException {
        Connection con = Database.getConnection();
        User user = null;
        String sql = "SELECT id, nom_user, adresse_email, password, role FROM utilisateurs WHERE adresse_email = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setNomUser(rs.getString("nom_user"));
            user.setAdresseEmail(rs.getString("adresse_email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        }
        Database.closeResultSet(rs);
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return user;
    }

}
