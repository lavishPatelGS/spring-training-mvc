<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>

    <!-- Load Bootstrap 5 CSS from CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"></head>
<body>
    <div class="container my-5">
        <div class="row">
            <!-- Contact Form Section -->
            <div class="col-md-6 mb-4">
                <div class="card shadow-lg p-4">
                    <h2 class="text-center">Contact Us</h2>
                    <p class="text-center">We'd love to hear from you. Please fill out the form below to get in touch!</p>
                    
                    <form action="${pageContext.request.contextPath}/submitContact" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                        </div>
                        <div class="mb-3">
                            <label for="subject" class="form-label">Subject</label>
                            <input type="text" class="form-control" id="subject" name="subject" placeholder="Enter the subject" required>
                        </div>
                        <div class="mb-3">
                            <label for="message" class="form-label">Message</label>
                            <textarea class="form-control" id="message" name="message" rows="5" placeholder="Enter your message" required></textarea>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary btn-lg">Send Message</button>
                        </div>
                    </form>
                </div>
            </div>

            <!-- Contact List Section -->
            <div class="col-md-6 mb-4">
                <div class="card shadow-lg p-4">
                    <h2 class="text-center">Submitted Contacts</h2>

                    <c:if test="${not empty contacts}">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Subject</th>
                                    <th>Message</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="contact" items="${contacts}">
                                    <tr>
                                        <td><c:out value="${contact.name}"/></td>
                                        <td><c:out value="${contact.email}"/></td>
                                        <td><c:out value="${contact.subject}"/></td>
                                        <td><c:out value="${contact.message}"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    
                    <c:if test="${empty contacts}">
                        <p class="text-center">No contacts have been submitted yet.</p>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <!-- Load Popper.js and Bootstrap 5 JS from CDN -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>
