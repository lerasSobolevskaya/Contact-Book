<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>

	<form action="MainServlet" method="post">
		<input type="hidden" name="command" value="listContacts" /> <input
			type="submit" value="Список контактов" />
	</form>
</body>
</html>