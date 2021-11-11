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
	<h1>Create a new tv show</h1>
		<div class="row">
			<div class="col ">
			
				<form:form action="/shows/create" method="post"
					modelAttribute="show">
					<div class="form-group">
						<form:label path="title">Title</form:label>
						<form:errors class="error-txt" path="title" />
						<form:input class="form-control" path="title" />
					</div>
					<div class="form-group">
						<form:label path="network">network</form:label>
						<form:errors class="error-txt" path="network" />
						<form:input class="form-control" path="network" />
					</div>
					<div class="form-group">
						<form:label path="description">Description</form:label>
						<form:errors class="error-txt" path="description" />
						<form:input type="textarea" class="form-control" path="description" />
					</div>
				
			
					

					<div class="form-group">
						<input type="submit" value="Submit" class="btn btn-primary " />
						<a class="btn btn-primary " href="/shows">Cancel</a>
					</div>
				</form:form>
		
	</div>

</body>
</html>