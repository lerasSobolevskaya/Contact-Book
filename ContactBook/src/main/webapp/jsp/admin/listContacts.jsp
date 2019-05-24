<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link
	href='${pageContext.request.contextPath}/resources/styles/css/custom.css'
	rel="stylesheet" type="text/css" />
<!-- <link -->
<%-- 	href='${pageContext.request.contextPath}/resources/styles/css/bootstrap.min.css' --%>
<!-- 	rel="stylesheet" type="text/css" /> -->
<!-- <link -->
<%-- 	href='${pageContext.request.contextPath}/resources/styles/fonts/fonts-awesome.min.css' --%>
<!-- 	rel="stylesheet" type="text/css" /> -->
<title>Список контактов</title>
</head>
<body>
	<form class="form-horizontal" action="MainServlet" method="get">
		<input type="hidden" name="command" value="formAddContacts"> <input
			type="submit" value="Добавить новый контакт" class="btn btn-default">
	</form>
	<c:forEach var="contact" items="${listContacts}">
		<p>
			Номер телефона:
			<c:out value="${contact.getPhone()}" />
		</p>

		<p>
			Email:
			<c:out value="${contact.getEmail()}" />
		</p>
		<p>
			Имя:
			<c:out value="${mapUsers.get(contact.getId()).getName()}" />
		</p>
		<p>
			Фамилия:
			<c:out value="${mapUsers.get(contact.getId()).getSurname()}" />
		</p>
		<p>
			Отчество:
			<c:out value="${mapUsers.get(contact.getId()).getPatronymic()}" />
		</p>
		<form action="MainServlet" method="get" class="form-horizontal">
			<input type="hidden" name="command" value="formUpdateContacts"><input
				type="hidden" name="contact_id" value="${contact.id}"> <input
				type="submit" value="Изменить контактную информацию"
				class="btn btn-default">
		</form>
		<form action="MainServlet" method="get" class="form-horizontal">
			<input type="hidden" name="command" value="deleteContacts"> <input
				type="hidden" name="user_id" value="${contact.userId}"> <input
				type="submit" value="Удалить контакт" class="btn btn-default">
		</form>
	</c:forEach>


</body>
</html>