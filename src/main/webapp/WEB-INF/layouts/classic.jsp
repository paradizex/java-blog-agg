<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../jsp/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>



<title><tiles:getAsString name="title"/></title>
</head>
<body>
<div class="container">
<xtiles:useAttribute name="current"/>

<!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/"/>'>JBA</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class='${current == "index" ? "active" : "" }'><a href='<spring:url value="/"/>'>Home</a></li>
              <security:authorize access="hasRole('ADMIN')">
              	<li class='${current == "users" ? "active" : "" }' ><a href='<spring:url value="/users.html"/>'>Users</a></li>
              </security:authorize>
              <security:authorize access="! isAuthenticated()">
              	<li class='${current == "user-register" ? "active" : "" }' ><a href='<spring:url value="/register.html"/>'>Register</a></li>
              </security:authorize>
              <security:authorize access="! isAuthenticated()">
              	<li class='${current == "login" ? "active" : "" }' ><a href='<spring:url value="/login.html"/>'>Login</a></li>
              </security:authorize>
              <security:authorize access="isAuthenticated()">	
              	<li class='${current == "login" ? "active" : "" }' ><a href='<spring:url value="/logout"/>'>Logout</a></li>
              </security:authorize>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class='${current == "index" ? "active" : "" }'><a href="./">Default <span class="sr-only">(current)</span></a></li>
              <li><a href="../navbar-static-top/">Static top</a></li>
              <li><a href="../navbar-fixed-top/">Fixed top</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>



<tiles:insertAttribute name="body" />

<br/><br/>
<center>
<tiles:insertAttribute name="footer"/>
</center>
</div> <!--  /container -->
</body>
</html>