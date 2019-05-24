<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<link
	href='${pageContext.request.contextPath}/resources/styles/css/custom.css'
	rel="stylesheet" type="text/css" />
<link
	href='${pageContext.request.contextPath}/resources/styles/css/bootstrap.min.css'
	rel="stylesheet" type="text/css" />
<link
	href='${pageContext.request.contextPath}/resources/styles/fonts/fonts-awesome.min.css'
	rel="stylesheet" type="text/css" />
<title>Администратор</title>
</head>
<body>

	<form class="form-horizontal" action="MainServlet" method="post">
		<input type="hidden" name="command" value="listContacts" /> <input
			type="submit" value="Список контактов" class="btn btn-default"/>
	</form>
</body>
</html>