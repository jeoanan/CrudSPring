<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"></link>
</head>
<body>
	<h1>Lista Clientes</h1>
	
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Editar</th>
			<th>Eliminar</th>
		</tr>
		
		<c:forEach var="clienteTemp" items="${clientes}">
		
			<c:url var="linkActualizar" value="/cliente/form-editar-cliente">
				<c:param name="clienteId" value="${clienteTemp.id}" />
			</c:url>
			
			<c:url var="linkEliminar" value="/cliente/eliminar">
				<c:param name="clienteId" value="${clienteTemp.id}" />
			</c:url>
			<tr>
				<td>${clienteTemp.nombre}</td>
				<td>${clienteTemp.apellido}</td>
				<td>${clienteTemp.email}</td>
				<td><a href="${linkActualizar}">Modificar</a></td>
				<td><a href="${linkEliminar}"><button onclick="if(!(confirm('¿Desea eliminar este registro?'))) return false">Eliminar</button> </a></td>
			</tr>
		
		</c:forEach>
	
	</table>
	
	<hr/>
	
	<button onclick="window.location.href='form-agregar-cliente'; return false">Agregar Cliente</button>

</body>
</html>