<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<link
	href='${pageContext.request.contextPath}/resources/styles/css/custom.css'
	rel="stylesheet" type="text/css" />
<link
	href='${pageContext.request.contextPath}/resources/styles/css/bootstrap.min.css'
	rel="stylesheet" type="text/css" />
<title>Контактная книга</title>
</head>
<body>

	<form class="form-horizontal" action="MainServlet" method="get">
		<input type="hidden" name="command" value="formAuthentication"
			class="form-control" /> <input type="submit"
			value="Вы администратор этого сайта?" class="btn btn-default">
	</form>

	<div class="container">
		<div class="row">

			<div class="col-md-offset-3 col-md-6">

				<h1 class="text-center">Контактная книга</h1>

				<p class="lead">Поиск информации по номеру телефона или email</p>


				<form class="form-horizontal" id="contact-form" method="get"
					action="MainServlet" role="form">
					<input type="hidden" name="command" value="getInfoByPhoneNumber">

					<div class="form-group">
						<label for="form_phone">Поиск по номеру телефона</label> <input
							class="form-control" id="form_phone" type="text" name="phone">
						<c:if test="${not empty invalid_phone_number}">
							<small class="form-text text-danger"> <c:out
									value="${invalid_phone_number}" />
							</small>
						</c:if>
						<c:if test="${not empty phone_number_dont_exist}">
							<small class="form-text text-danger"> <c:out
									value="${phone_number_dont_exist}" />
							</small>
						</c:if>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-default"
							value="Поиск по справочнику">
					</div>
				</form>

				<form class="form-horizontal" id="contact-form" action="MainServlet"
					method="get">
					<input type="hidden" name="command" value="getInfoByEmail">

					<div class="form-group">
						<label for="form_email">Поиск по Email</label> <input
							id="form_email" type="email" name="email" class="form-control">
						<c:if test="${not empty invalid_email}">
							<small class="form-text text-danger"><c:out
									value="${invalid_email}" /> </small>
						</c:if>
						<c:if test="${not empty email_address_dont_exist}">
							<small class="form-text text-danger"> <c:out
									value="${email_address_dont_exist}" />
							</small>
						</c:if>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-default"
							value="Поиск по справочнику">
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>