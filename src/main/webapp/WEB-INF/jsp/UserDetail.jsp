<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./taglib.jsp" %>    

${user.name}
<c:forEach items="${user.blogs }" var="blog">
<h3>${blog.name }</h3>
<p>${blog.url}</p>
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>Item Name</th>
			<th>Link</th>
		</tr>
	</thead>
	<tbody>
		
			<c:forEach items="${blog.items }" var="item">
			<tr>
				<td>${item.title}</td>
				<td>${item.link}</td>
			</tr>			
			</c:forEach>
		
	</tbody>
</table>
</c:forEach>