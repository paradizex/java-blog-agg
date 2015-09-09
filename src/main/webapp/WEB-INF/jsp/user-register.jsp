<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./taglib.jsp" %>

<form:form commandName="user" cssClass="form-horizontal">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label" >Name: </label>
		<div class="col-sm-10">
      		<form:input path="name" cssClass="form-control"  />
    	</div>
	</div> <!-- class="form-group" -->
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label" >Email: </label>
		<div class="col-sm-10">
      		<form:input path="email" cssClass="form-control"  />
    	</div>
	</div> <!-- class="form-group" -->
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label" >Password:</label>
		<div class="col-sm-10">
      		<form:password path="password" cssClass="form-control"  />
    	</div>
	</div> <!-- class="form-group" -->
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
     	 	<button type="submit"  class="btn btn-primary btn-lg" >Save</button>
    	</div>
	</div> <!-- class="form-group" -->
</form:form>