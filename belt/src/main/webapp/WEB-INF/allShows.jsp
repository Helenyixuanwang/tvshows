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
<title>All shows</title>
</head>
<body>
	<div class="container">
	<h1>
			Welcome
			<c:out value="${user.firstName}" />
		</h1>
		<a href="/logout">logout</a> 
		
		<table class="table table-striped table-dark">
			<thead>
				<tr>

					<th>Show</th>
					<th>NetWork</th>
					<th>Average Rating</th>
				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allShows}" var="show">
					<tr>
						<td><a href="/shows/${show.id}"><c:out value="${show.title}" /></a></td>
						<td><c:out value="${show.network}" /></td>
						<td>
						<c:if  test="${not empty show.ratingsCreatedForShow }">
						
						<!--<c:forEach  items="${show.ratingsCreatedForShow }" var="rating"> -->
						<span><c:out value="${show.findAve(show.ratingsCreatedForShow)}" /></span>
						<!--</c:forEach> -->
						</c:if>
						</td>
					
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a  class="btn btn-primary" href="shows/new">add New Show</a>
			
	</div>

</body>
</html>