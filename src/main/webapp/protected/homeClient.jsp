<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="beans.Profile" %>
<!DOCTYPE html>
<html>
<head>
    <title>homeGuest</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/sideBar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/dark-color.css" id="theme-link">
</head>

<body>

    <div class="content">
       <%@ include file="../components/sideBarClient.jsp" %>
		<%@ include file="../components/homeContainer.jsp" %>
    </div>
    
    
   
</body>
</html>
