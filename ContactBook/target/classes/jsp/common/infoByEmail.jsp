<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href='${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css'
	rel='stylesheet' type='text/css' />
<link
	href='${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css'
	rel='stylesheet' type='text/css' />
<link
	href='${pageContext.request.contextPath}/resources/bootstrap/fonts/fonts.googleapis.css'
	rel='stylesheet' type='text/css' />
<body>
	<div class="container">

		<div class="row">

			<div class="col-lg-8 col-lg-offset-2">

				<h1 class="text-center">Bootstrap ReCaptcha Form</h1>

				<p class="lead">Bootstrap contact form with PHP and AJAX add
					Google's ReCaptcha.</p>

				<div>
					Email:
					<c:out value="${contact.getEmail()}" />
				</div>
				<div>
					Номер телефона:
					<c:out value="${contact.getPhone()}" />
				</div>
				<div>
					Имя:
					<c:out value="${mapUsers.get(contact.getId()).getName()}" />
				</div>
				<div>
					Фамилия:
					<c:out value="${mapUsers.get(contact.getId()).getSurname()}" />
				</div>
				<div>
					Отчество:
					<c:out value="${mapUsers.get(contact.getId()).getPatronymic()}" />
				</div>
			</div>
		</div>
	</div>

</body>
</html>