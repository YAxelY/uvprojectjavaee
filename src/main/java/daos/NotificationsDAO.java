package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Notification;

public class NotificationsDAO {

//    public void saveNotification(Notification notification) {
//        String sql = "INSERT INTO notifications (type, title, message, recipient, created_at, expires_at, status, priority, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setString(1, notification.getType());
//            preparedStatement.setString(2, notification.getTitle());
//            preparedStatement.setString(3, notification.getMessage());
//            preparedStatement.setString(4, notification.getRecipient());
//            preparedStatement.setTimestamp(5, new Timestamp(notification.getCreatedAt().getTime()));
//            preparedStatement.setTimestamp(6, notification.getExpiresAt() != null ? new Timestamp(notification.getExpiresAt().getTime()) : null);
//            preparedStatement.setString(7, notification.getStatus());
//            preparedStatement.setString(8, notification.getPriority());
//            preparedStatement.setString(9, notification.getUrl());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Notification> getAllNotifications() {
//        List<Notification> notifications = new ArrayList<>();
//        String sql = "SELECT * FROM notifications";
//
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            while (resultSet.next()) {
//                Notification notification = new Notification();
//                notification.setId(resultSet.getLong("id"));
//                notification.setType(resultSet.getString("type"));
//                notification.setTitle(resultSet.getString("title"));
//                notification.setMessage(resultSet.getString("message"));
//                notification.setRecipient(resultSet.getString("recipient"));
//                notification.setCreatedAt(resultSet.getTimestamp("created_at"));
//                notification.setExpiresAt(resultSet.getTimestamp("expires_at"));
//                notification.setStatus(resultSet.getString("status"));
//                notification.setPriority(resultSet.getString("priority"));
//                notification.setUrl(resultSet.getString("url"));
//
//                notifications.add(notification);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return notifications;
//    }
//
//    // Autres méthodes DAO si nécessaire
}

