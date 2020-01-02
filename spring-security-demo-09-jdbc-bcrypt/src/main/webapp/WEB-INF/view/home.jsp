<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>HI Welcome</h2>
	
	<p>
		User : <security:authentication property="principal.username"/>
		<br><br>
		Roles : <security:authentication property="principal.authorities"/>
	</p>
	<security:authorize access="hasRole('MANAGER')">
	<a href="${pageContext.request.contextPath}/manager">Manager Meeting</a>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<a href="${pageContext.request.contextPath}/system">Admin Page</a>
	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout"
				method="post">
				<input type="submit" value="logout"  />
	</form:form>
</body>
</html>