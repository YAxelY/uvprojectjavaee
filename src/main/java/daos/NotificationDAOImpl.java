package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Notification;


public class NotificationDAOImpl implements NotificationDAO {

    private final String url = "jdbc:mysql://localhost:3306/votre_base_de_donnees";
    private final String utilisateur = "votre_utilisateur";
    private final String motDePasse = "votre_mot_de_passe";

    
    @Override
    public void save(Notification notification) {
        String sql = "INSERT INTO notifications (type, title, message, recipient, created_at, expires_at, status, priority, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, notification.getType());
            preparedStatement.setString(2, notification.getTitle());
            preparedStatement.setString(3, notification.getMessage());
            preparedStatement.setString(4, notification.getRecipient());
            preparedStatement.setTimestamp(5, new Timestamp(notification.getCreatedAt().getTime()));
            preparedStatement.setTimestamp(6, notification.getExpiresAt() != null ? new Timestamp(notification.getExpiresAt().getTime()) : null);
            preparedStatement.setString(7, notification.getStatus());
            preparedStatement.setString(8, notification.getPriority());
            preparedStatement.setString(9, notification.getUrl());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("La sauvegarde de la notification a échoué, aucune ligne n'a été insérée.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    notification.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("La sauvegarde de la notification a échoué, aucun ID généré.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Notification notification) {
        String sql = "UPDATE notifications SET type=?, title=?, message=?, recipient=?, created_at=?, expires_at=?, status=?, priority=?, url=? WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, notification.getType());
            preparedStatement.setString(2, notification.getTitle());
            preparedStatement.setString(3, notification.getMessage());
            preparedStatement.setString(4, notification.getRecipient());
            preparedStatement.setTimestamp(5, new Timestamp(notification.getCreatedAt().getTime()));
            preparedStatement.setTimestamp(6, notification.getExpiresAt() != null ? new Timestamp(notification.getExpiresAt().getTime()) : null);
            preparedStatement.setString(7, notification.getStatus());
            preparedStatement.setString(8, notification.getPriority());
            preparedStatement.setString(9, notification.getUrl());
            preparedStatement.setLong(10, notification.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Notification get(long id) {
        String sql = "SELECT * FROM notifications WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToNotification(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Notification> getAll() {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM notifications";

        try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                notifications.add(mapResultSetToNotification(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }

    private Notification mapResultSetToNotification(ResultSet resultSet) throws SQLException {
        Notification notification = new Notification();
        notification.setId(resultSet.getLong("id"));
        notification.setType(resultSet.getString("type"));
        notification.setTitle(resultSet.getString("title"));
        notification.setMessage(resultSet.getString("message"));
        notification.setRecipient(resultSet.getString("recipient"));
        notification.setCreatedAt(resultSet.getTimestamp("created_at"));
        notification.setExpiresAt(resultSet.getTimestamp("expires_at"));
        notification.setStatus(resultSet.getString("status"));
        notification.setPriority(resultSet.getString("priority"));
        notification.setUrl(resultSet.getString("url"));

        return notification;
    }
}
