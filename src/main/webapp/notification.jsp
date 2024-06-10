<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notifications</title>
    <link rel="stylesheet" type="text/css" href="./styles/notification.css">
</head>
<body>
    <div class="sidebar">
        <h2>Menu</h2>
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="notifications.jsp">Notifications</a></li>
            <!-- Ajouter d'autres liens de menu ici -->
        </ul>
    </div>

    <div class="content">
        <h1>Notifications</h1>
        <c:if test="${not empty notifications}">
            <ul>
                <c:forEach var="notification" items="${notifications}">
                    <li>
                        <h3>${notification.title}</h3>
                        <p>${notification.message}</p>
                        <small>Envoyé à : ${notification.recipient} le ${notification.createdAt}</small>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty notifications}">
            <p>Aucune notification disponible.</p>
        </c:if>
    </div>

    <div class="notification-sidebar">
        <button id="notificationButton">Afficher les notifications</button>
    </div>

    <script>
        document.getElementById("notificationButton").addEventListener("click", function() {
            window.location.href = "${pageContext.request.contextPath}/notifications";
        });
    </script>
</body>
</html>
 --%>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notifications</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="sidebar">
        <h2>Menu</h2>
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="notifications.jsp">Notifications</a></li>
            <!-- Ajouter d'autres liens de menu ici -->
        </ul>
    </div>

    <div class="content">
        <h1>Notifications</h1>
        <c:if test="${not empty notifications}">
            <ul id="notificationList">
                <c:forEach var="notification" items="${notifications}">
                    <li>
                        <h3>${notification.title}</h3>
                        <p>${notification.message}</p>
                        <small>Envoyé à : ${notification.recipient} le ${notification.createdAt}</small>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty notifications}">
            <p>Aucune notification disponible.</p>
        </c:if>
    </div>

    <div class="notification-sidebar">
        <button id="notificationButton">Afficher les notifications</button>
    </div>

    <script>
        document.getElementById("notificationButton").addEventListener("click", function() {
            window.location.href = "${pageContext.request.contextPath}/notifications";
        });

        var ws = new WebSocket("ws://" + window.location.host + "${pageContext.request.contextPath}/notificationsSocket");
        ws.onmessage = function(event) {
            var notificationList = document.getElementById("notificationList");
            var newNotification = document.createElement("li");
            newNotification.innerHTML = "<h3>Nouvelle Notification</h3><p>" + event.data + "</p>";
            notificationList.insertBefore(newNotification, notificationList.firstChild);
        };
    </script>
</body>
</html>
 