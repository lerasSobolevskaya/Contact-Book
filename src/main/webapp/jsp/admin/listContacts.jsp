<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="contact" items="${listContacts}">
		<c:out value="${contact.getPhone()}" />
		<c:out value="${contact.getEmail()}" />
		<c:out value="${contactsUsers.get(contact.getId()).getName()}" />
		<c:out value="${contactsUsers.get(contact.getId()).getSurname()}" />
	</c:forEach>
</body>
</html>