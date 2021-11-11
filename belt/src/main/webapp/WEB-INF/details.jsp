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
<title>Details</title>
</head>
<body>
	<div class="container">

	<h1>
			Welcome
			<c:out value="${user.firstName}" />
		</h1>
			<a href="/shows">all shows</a><a href="/logout">logout</a> 
		<p>posted by : ${thisShow.showCreator.firstName } </p>
		<p> network:${thisShow.network } </p>
		<p> description:${thisShow.description }
		
		
		
		<form:form action="/shows/${thisShow.id}/rating" method="post"
					modelAttribute="tvrating">
					<div class="form-group">
						<form:label path="score">Leave a Rating</form:label>
						<form:errors class="error-txt" path="score" />
						<form:input class="form-control" path="score"  />
					</div>
					
					

					<div class="form-group">
						<input type="submit" value="Rate" class="btn btn-primary " />
						
					</div>
				</form:form>
				
				<hr>
				<table class="table table-striped table-dark">
			<thead>
				<tr>

					<th>Name</th>
					<th>Rating</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${thisShow.ratingsCreatedForShow}" var="score">
					<tr>
						<td><c:out value="${ score.ratingCreator.firstName}" /></td>
					
						<td>
						<c:out value="${score.score}" />
						</td>
					
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
	</div>

</body>
</html>