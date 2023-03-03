<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"></link>
<body>
	<h1>Agregar cliente</h1>
	
	<form:form action="insertarCliente" modelAttribute="cliente" method="POST">
		<form:hidden path="id"/>
		<div>
			<label>Nombre:</label>
			<form:input path="nombre"/>
		</div>
			<label>Apellido:</label>
			<form:input path="apellido"/>
		<div>
			<label>Email:</label>
			<form:input path="email"/>
		</div>
		<div>
			<button type="submit">${valorButton}</button>
		</div>
	</form:form>

</body>
</html>