<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">

			<div class="col-md-offset-3 col-md-6">
				<form class="form-horizontal" action="MainServlet" method="post">
					<input type="hidden" name="command" value="checkRole"> <span
						class="heading">АВТОРИЗАЦИЯ</span>
					<div class="form-group">
						<input type="text" class="form-control" id="login"
							placeholder="Login" name="login" required="required"> <i
							class="fa fa-user"></i>
					</div>
					<div class="form-group help">
						<input type="password" class="form-control" id="password"
							placeholder="Password" name="password" required="required">
						<i class="fa fa-lock"></i> <a class="fa fa-question-circle"></a>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-default">ВХОД</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>