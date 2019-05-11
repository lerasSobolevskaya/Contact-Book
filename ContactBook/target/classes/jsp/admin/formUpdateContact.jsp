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

				<form id="contact-form" method="get" action="MainServlet"
					role="form">
					<input type="hidden" name="command" value="saveContactsUpdate">
					<div class="messages"></div>

					<div class="controls">
						<input type="hidden" name="contact_id" value="${contact.id}" /> <input
							type="hidden" name="user_id" value="${user.id}" />

						<div class="col-md-6">
							<div class="form-group">
								<label for="form_phone" id="phone">Номер телефона</label> <input
									id="phone" type="text" name="phone" class="form-control">
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group">
								<label for="form_email" id="email">Email</label> <input
									id="form_email" type="text" name="email" class="form-control">
								<div class="help-block with-errors"></div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="form_name" id="name">Имя</label> <input id="name"
									type="text" name="name" class="form-control">
								<div class="help-block with-errors"></div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="form_surname" id="surname">Фамилия</label> <input
									id="surname" type="text" name="surname" class="form-control">
								<div class="help-block with-errors"></div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="form_patronymic" id="patronymic">Отчество</label> <input
								id="form_patronymic" type="text" name="patronymic"
								class="form-control">
							<div class="help-block with-errors"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<input type="submit" class="btn btn-success btn-send"
								value="Изменить">
						</div>
					</div>

				</form>

			</div>
		</div>
	</div>
</body>

</body>
</html>