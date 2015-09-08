<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./taglib.jsp" %>
    
<table class="table table-striped table-bordered table-hover">
	<caption>User Listing : </caption>
	
	<thead>
		<td>No.</td>
		<td>Name</td>
		<td>Email</td>
		<td>Password</td>	
	</thead>
	<tbody>
		<c:forEach items="${userList}" var="user">
		<tr>
			<td>
			
			${user.id }</td>
			<td><a href='<spring:url value="/user/${user.id }.html"/>'>${user.name}</a></td>
			<td>${user.email}</td>
			<td>${user.password }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>