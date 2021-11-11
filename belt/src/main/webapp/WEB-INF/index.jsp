<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<title>Edit Event</title>
</head>
<body>
	<div class="container">
	<h1>Welcome to TV SHOWS!</h1>
		<div class="row">
			<div class="col fence">
				<h1>Register</h1>
				<form:form action="/registration" method="post"
					modelAttribute="user">
					<div class="form-group">
						<form:label path="firstName">First Name</form:label>
						<form:errors class="error-txt" path="firstName" />
						<form:input class="form-control" path="firstName" />
					</div>
					<div class="form-group">
						<form:label path="lastName">Last Name</form:label>
						<form:errors class="error-txt" path="lastName" />
						<form:input class="form-control" path="lastName" />
					</div>
					<div class="form-group">
						<form:label path="email">Email</form:label>
						<form:errors class="error-txt" path="email" />
						<form:input class="form-control" path="email" />
					</div>
				
			
					<div class="form-group">
						<form:label path="password">Password</form:label>
						<form:errors class="error-txt" path="password" />
						<form:input class="form-control" path="password" type="password" />
					</div>
					<div class="form-group">
						<form:label path="passwordConfirmation">Confirm Password</form:label>
						<form:errors class="error-txt" path="passwordConfirmation" />
						<form:input class="form-control" path="passwordConfirmation"
							type="password" />
					</div>

					<div class="form-group">
						<input type="submit" value="Register" class="btn btn-primary " />
					</div>
				</form:form>
			</div>
			<div class="col fence">
				<h1>Login</h1>
				<p class="error-txt">
					<c:out value="${error}" />
				</p>
				<form action="/login" method="POST">
					<div class="form-group">
						<label for="email">Email</label> <input type="email" name="email"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							name="password" class="form-control">
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn btn-primary " />
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>