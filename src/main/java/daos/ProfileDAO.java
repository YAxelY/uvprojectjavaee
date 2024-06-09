package daos;


import java.sql.SQLException;

import beans.Profile;

public interface ProfileDAO  extends DAO<Profile> {
	int insert(Profile profile) throws SQLException ;
}
