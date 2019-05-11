<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

				<form id="contact-form" method="get" action="MainServlet"
					role="form">
					<input type="hidden" name="command" value="saveNewContacts">
<%-- 					<input type="hidden" name="contact_id" value="${contact.Id()}"> --%>
<%-- 					<input type="hidden" name="user_id" value="${user.getId()}"> --%>
					<div class="messages"></div>

					<div class="controls">

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="form_name">Имя</label> <input id="form_name"
										type="text" name="name" class="form-control">
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="form_surname">Фамилия</label> <input
										id="form_surname" type="text" name="surname"
										class="form-control">
									<div class="help-block with-errors"></div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="form_patronymic">Отчество</label> <input
									id="form_patronymic" type="text" name="patronymic"
									class="form-control">
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="row">

							<div class="col-md-6">
								<div class="form-group">
									<label for="form_phone">Номер телефона</label> <input
										id="form_phone" type="text" name="phone" class="form-control">
									<div class="help-block with-errors"></div>
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group">
									<label for="form_email">Email</label> <input id="form_email"
										type="text" name="email" class="form-control">
									<div class="help-block with-errors"></div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<input type="submit" class="btn btn-success btn-send"
									value="Добавить в справочник">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>