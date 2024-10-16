<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Socios Morosos</title>
<jsp:directive.include file="../includes/includefile.jspf" />
</head>
<body>
	<div class="container">
		<div class="header"></div>
		<div class="menu">
			<jsp:directive.include file="../WEB-INF/menu.jspf" />
		</div>
		<c:choose>
			<c:when test="${not empty listadoSociosMorosos}">
				<div class="w-75 ma">
					<table class="table tablaconborde tablacebra tabla-hover">
						<caption>Listado de Socios Morosos</caption>
						<thead>
							<tr>
								<th scope="col">IDSOCIO</th>
								<th scope="col">NOMBRE</th>
								<th scope="col">Ver Libros</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listadoSociosMorosos}" var="socio">
								<tr>
									<td class="txtderecha">${socio.idsocio}</td>
									<td>${socio.nombre}</td>
									<td class="txtcentrado"><a
										href="${pageContext.request.contextPath}/controllerAdmin?operacion=verlibrosfueraplazo&socio=${socio.idsocio}">Ver
											Libros</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<p align="center" class="advertencia">No hay socios morosos</p>
			</c:otherwise>
		</c:choose>

		<c:if
			test="${listadoLibrosFueraPlazo!=null && not empty listadoLibrosFueraPlazo}">
			<div class="w-75 ma">
				<table class="table tablaconborde tablacebra tabla-hover">
					<caption>Préstamos no devueltos del socio:
						${nombreSocio}</caption>
					<thead>
						<tr>
							<th scope="col">TITULO</th>
							<th scope="col">FECHA DEL PRÉSTAMO</th>
							<th scope="col">DIAS DE DEMORA</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listadoLibrosFueraPlazo}"
							var="prestamo">
							<tr>
								<td>${prestamo.titulo}</td>
								<td class="txtcentrado"><fmt:formatDate
										value="${prestamo.fechaprestamo}" /></td>
								<td class="txtcentrado">${prestamo.diasDemora}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>
</body>
</html>