<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro correcto</title>
<jsp:directive.include file="includes/includefile.jspf" />
</head>
<body>
	<div class="container">
		<div class="header"></div>
		<c:if test="${error != null}">
			<div class="diverror">
				<p>
					<strong><c:out value="Error" /></strong> <br>
					<c:out value="${error}" />
				</p>
			</div>
		</c:if>
		<div class="tabla">

			<c:if test="${socio != null}">
				<table class="table tablaconborde tablacebra ">
					<caption>Sus datos han sido registrados</caption>
					<tr>
						<th scope="col">IDSOCIO</th>
						<th scope="col">NOMBRE</th>
						<th scope="col">EMAIL</th>
						<th scope="col">DIRECCION</th>
					</tr>
					<tr>
						<td>${socio.idsocio}</td>
						<td>${socio.nombre}</td>
						<td>${socio.email}</td>
						<td>${socio.direccion}</td>
					</tr>
				</table>
				<div>
					<h2>Recibirá un correo con un enlace para darse de alta como usuario de la aplicación</h2>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>