package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Profile;


public class ProfileDAOImpl  implements ProfileDAO {

	

    public Profile get(int id) throws SQLException {
        Connection con = Database.getConnection();
        Profile profile = null;
        String sql = "SELECT id_profile, nom_profile, prenom_profile, email_profile, password_profile, telephone_profile, photo_profile FROM Profile WHERE id_profile = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int idProfile = rs.getInt("id_profile");
            String nomProfile = rs.getString("nom_profile");
            String prenomProfile = rs.getString("prenom_profile");
            String emailProfile = rs.getString("email_profile");
            String passwordProfile = rs.getString("password_profile");
            String telephoneProfile = rs.getString("telephone_profile");
            String photoProfile = rs.getString("photo_profile");
         

            profile = new Profile();
            profile.setIdProfile(idProfile);
            profile.setNomProfile(nomProfile);
            profile.setPrenomProfile(prenomProfile);
            profile.setEmailProfile(emailProfile);
            profile.setPasswordProfile(passwordProfile);
            profile.setTelephoneProfile(telephoneProfile);
            profile.setPhotoProfile(photoProfile);
        
        }
        Database.closeResultSet(rs);
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return profile;
    }

    public List<Profile> getAll() throws SQLException {
        Connection con = Database.getConnection();
        List<Profile> profiles = new ArrayList<>();
        String sql = "SELECT id_profile, nom_profile, prenom_profile, email_profile, password_profile, telephone_profile, photo_profile FROM Profile";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idProfile = rs.getInt("id_profile");
            String nomProfile = rs.getString("nom_profile");
            String prenomProfile = rs.getString("prenom_profile");
            String emailProfile = rs.getString("email_profile");
            String passwordProfile = rs.getString("password_profile");
            String telephoneProfile = rs.getString("telephone_profile");
            String photoProfile = rs.getString("photo_profile");
//            int idProducteur = rs.getInt("id_producteur");

            Profile profile = new Profile();
            profile.setIdProfile(idProfile);
            profile.setNomProfile(nomProfile);
            profile.setPrenomProfile(prenomProfile);
            profile.setEmailProfile(emailProfile);
            profile.setPasswordProfile(passwordProfile);
            profile.setTelephoneProfile(telephoneProfile);
            profile.setPhotoProfile(photoProfile);
//            profile.setIdProducteur(idProducteur);

            profiles.add(profile);
        }
        Database.closeResultSet(rs);
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return profiles;
    }

    public int save(Profile profile) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "UPDATE Profile SET nom_profile = ?, prenom_profile = ?, email_profile = ?, password_profile = ?, telephone_profile = ?, photo_profile = ? WHERE id_profile = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, profile.getNomProfile());
        ps.setString(2, profile.getPrenomProfile());
        ps.setString(3, profile.getEmailProfile());
        ps.setString(4, profile.getPasswordProfile());
        ps.setString(5, profile.getTelephoneProfile());
        ps.setString(6, profile.getPhotoProfile());
   
        ps.setInt(7, profile.getIdProfile());
        int result = ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return result;
    }

    public int insert1(Profile profile) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "INSERT INTO Profile (nom_profile, prenom_profile, email_profile, password_profile, telephone_profile, photo_profile) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, profile.getNomProfile());
        ps.setString(2, profile.getPrenomProfile());
        ps.setString(3, profile.getEmailProfile());
        ps.setString(4, profile.getPasswordProfile());
        ps.setString(5, profile.getTelephoneProfile());
        ps.setString(6, profile.getPhotoProfile());
//        ps.setInt(7, profile.getIdProducteur());
        int result = ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return result;
    }
    
    public int insert(Profile profile) throws SQLException {
        Connection con = Database.getConnection();
        StringBuilder sql = new StringBuilder("INSERT INTO Profile (");
        StringBuilder values = new StringBuilder("VALUES (");
        List<Object> parameters = new ArrayList<>();
        
        if (profile.getNomProfile() != null) {
            sql.append("nom_profile, ");
            values.append("?, ");
            parameters.add(profile.getNomProfile());
        }
        if (profile.getPrenomProfile() != null) {
            sql.append("prenom_profile, ");
            values.append("?, ");
            parameters.add(profile.getPrenomProfile());
        }
        if (profile.getEmailProfile() != null) {
            sql.append("email_profile, ");
            values.append("?, ");
            parameters.add(profile.getEmailProfile());
        }
        if (profile.getPasswordProfile() != null) {
            sql.append("password_profile, ");
            values.append("?, ");
            parameters.add(profile.getPasswordProfile());
        }
        if (profile.getTelephoneProfile() != null) {
            sql.append("telephone_profile, ");
            values.append("?, ");
            parameters.add(profile.getTelephoneProfile());
        }
        if (profile.getPhotoProfile() != null) {
            sql.append("photo_profile, ");
            values.append("?, ");
            parameters.add(profile.getPhotoProfile());
        }
     
        // Remove the last comma and space, and close the parentheses
        sql.setLength(sql.length() - 2);
        values.setLength(values.length() - 2);
        sql.append(") ");
        values.append(")");
        sql.append(values);
        
        PreparedStatement ps = con.prepareStatement(sql.toString());
        
        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }
        
        int result = ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return result;
    }


    public int delete(Profile profile) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "DELETE FROM Profile WHERE id_profile = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, profile.getIdProfile());
        int result = ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return result;
    }

	@Override
	public int update(Profile profile) throws SQLException {
	    Connection con = Database.getConnection();
	    StringBuilder sql = new StringBuilder("UPDATE Profile SET ");
	    List<Object> parameters = new ArrayList<>();
	    
	    if (profile.getNomProfile() != null) {
	        sql.append("nom_profile = ?, ");
	        parameters.add(profile.getNomProfile());
	    }
	    if (profile.getPrenomProfile() != null) {
	        sql.append("prenom_profile = ?, ");
	        parameters.add(profile.getPrenomProfile());
	    }
	    if (profile.getEmailProfile() != null) {
	        sql.append("email_profile = ?, ");
	        parameters.add(profile.getEmailProfile());
	    }
	    if (profile.getPasswordProfile() != null) {
	        sql.append("password_profile = ?, ");
	        parameters.add(profile.getPasswordProfile());
	    }
	    if (profile.getTelephoneProfile() != null) {
	        sql.append("telephone_profile = ?, ");
	        parameters.add(profile.getTelephoneProfile());
	    }
	    if (profile.getPhotoProfile() != null) {
	        sql.append("photo_profile = ?, ");
	        parameters.add(profile.getPhotoProfile());
	    }
	  
	    // Remove the last comma and space
	    sql.setLength(sql.length() - 2);
	    
	    sql.append(" WHERE id_profile = ?");
	    parameters.add(profile.getIdProfile());
	    
	    PreparedStatement ps = con.prepareStatement(sql.toString());
	    
	    for (int i = 0; i < parameters.size(); i++) {
	        ps.setObject(i + 1, parameters.get(i));
	    }
	    
	    int result = ps.executeUpdate();
	    Database.closePreparedStatement(ps);
	    Database.closeConnection(con);
	    return result;
	}

	
}
