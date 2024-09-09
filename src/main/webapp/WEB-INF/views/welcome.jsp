<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/welcome.css">
</head>
<body>

    <div class="navbar">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Logo">
        </div>
        <div class="nav-links">
            <%
                Map<String, String> navLinks = (Map<String, String>) request.getAttribute("navLinks");
                
                if (navLinks != null) {
                    for (Map.Entry<String, String> entry : navLinks.entrySet()) {
            %>
            <a href="${pageContext.request.contextPath}<%= entry.getValue() %>/"><%= entry.getKey() %></a>
            <%
                }
            }
            %>
        </div>
    </div>

    <div class="main-container">
		<div class="sidebar">
		  <c:forEach var="entry" items="${sideBarLinks}">
		    <a href="${pageContext.request.contextPath}${entry.value}/">${entry.key}</a>
		  </c:forEach>
		</div>

        <div class="content">
            <h1>Welcome to My Website</h1>
            <p>Hello, ${userName} We're glad to have you here.</p>
        </div>
    </div>

</body>
</html>
