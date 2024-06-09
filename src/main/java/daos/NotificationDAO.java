package daos;

import java.util.List;

import beans.Notification;

public interface NotificationDAO {

	Notification get(long id);

	List<Notification> getAll();

	void update(Notification notification);

	void save(Notification notification);

}
