<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="form" modelAttribute="form" method="post"> 
		Name: <form:input path="name" id="name"></form:input> 
			<c:if test="${pageContext.request.method=='POST'}">
				<form:errors path="name" /></c:if> <br /> 
		Email address: <form:input path="email" id="email"></form:input> 
			<c:if test="${pageContext.request.method=='POST'}">
				<form:errors path="email" /></c:if> <br /> 
		Age: <form:input path="age" id="age"></form:input> 
			<c:if test="${pageContext.request.method=='POST'}"><form:errors path="age" /></c:if> <br /> 
				<input type="submit" value="Wyślij formularz" /> 
	</form:form>
</body>
</html>