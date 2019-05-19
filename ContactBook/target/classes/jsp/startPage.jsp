<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<head>
<title>Bootstrap ReCaptcha Form | BootstrapTema</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href='${pageContext.request.contextPath}/resources/styles/css/bootstrap.min.css'
	rel='stylesheet' type='text/css' />
<link
	href='${pageContext.request.contextPath}/resources/styles/fonts/fonts.googleapis.css'
	rel='stylesheet' type='text/css' />
<link
	href='${pageContext.request.contextPath}/resources/styles/css/custom.css'
	rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="MainServlet" method="get">
		<input type="hidden" name="command" value="formAuthentication" /> <input
			type="submit" value="Вы администратор этого сайта?"
			class="btn btn-default">
		<button type="submit" class="btn btn-default">ВХОД</button>
	</form>
	<div class="container">

		<div class="row">

			<div class="col-lg-8 col-lg-offset-2">

				<h1 class="text-center">Контактная книга</h1>

				<p class="lead">Поиск информации по номеру телефона или email</p>


				<form id="contact-form" method="get" action="MainServlet"
					role="form">
					<input type="hidden" name="command" value="getInfoByPhoneNumber">

					<div class="col-md-6">
						<div class="form-group">
							<label for="form_phone">Поиск по номеру телефона</label> <input
								id="form_phone" type="text" name="phone" class="form-control">
						</div>
					</div>
					<div class="col-md-12">
						<input type="submit" class="btn btn-default"
							value="Поиск по справочнику" class="btn btn-default">
					</div>
				</form>

				<form id="contact-form" action="MainServlet" method="get">
					<input type="hidden" name="command" value="getInfoByEmail">

					<div class="col-md-6">
						<div class="form-group">
							<label for="form_email">Поиск по Email</label> <input
								id="form_email" type="email" name="email" class="form-control">
						</div>
					</div>
					<div class="col-md-12">
						<input type="submit" class="btn btn-default"
							value="Поиск по справочнику">
					</div>
				</form>
			</div>

		</div>
	</div>

</body>
</html>