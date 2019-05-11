<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="MainServlet" method="get">
		<input type="hidden" name="command" value="listUsers"> <input
			type="submit" value="list">
	</form>
</body>
</html>