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
	<c:forEach var="user" items="${listUsers}">
		<p>
			Имя:
			<c:out value="${user.getName()}" /></p>
			<p>Фамилия:
			<c:out value="${user.getSurname()}" /></p>
		<p>	Email :
			<c:out value="${userContacts.get(user.getId()).getEmail()}" /></p>
			
		<p>	Телефон:
			<c:out value="${userContacts.get(user.getId()).getPhone()}" /></p>
		<form action="MainServlet" method="post">
			<input type="hidden" name="command" value="deleteUser"><input
				type="hidden" name="user_id" value="${user.getId()}"><input
				type="submit" value="delete">
		</form>

		<form action="MainServlet" method="get">
			<input type="hidden" name="command" value="formUpdateUser"><input
				type="hidden" name="user_id" value="${user.getId()}"><input
				type="submit" value="update">
		</form>
	</c:forEach>

</body>
</html>