<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib
	uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@ page
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es_ES">
<head>
<meta charset="UTF-8">
<title>Confirmación de matricula</title>
<link rel="stylesheet" href="resources/css/estilo.css" />
</head>
<body>
	<h1 class="azulcobalto centrar">Datos de la matricula</h1>
	<section id="detallematricula">
		<p>
			<span class="azulcobalto">Alumno:</span>
			<c:out value="${apellido1} ${apellido2}, ${nombre}"></c:out>
		</p>
		<p>
			<span class="azulcobalto">Email:</span>
			<c:out value="${email}"></c:out>
		</p>
		<p>
			<span class="azulcobalto">Fecha de Nacimiento:</span>
			<fmt:formatDate pattern="dd-MM-yyyy" value="${fechanacimiento}" />

		</p>
		<p>
			<span class="azulcobalto">Dia de la semana en que nació:</span>
			<c:out value="${diasemananacimiento}"></c:out>
		</p>
		<p>
			<span class="azulcobalto">Provincia de nacimiento:</span>
			<c:out value="${provincianacimiento}"></c:out>
		</p>

		<p>
			<span class="azulcobalto">Emancipado: </span>
			<c:choose>
				<c:when test="${emancipado!=null}">
					<c:choose>
						<c:when test="${emancipado.equals('S')}">
							<c:out value="SI"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="NO"></c:out>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:out value="No consta"></c:out>
				</c:otherwise>
			</c:choose>
			
		</p>
		<c:if test="${modulosmatriculados!=null}">
			<p>
				<span class="azulcobalto">Módulos de los que se ha
					matricuado: </span>
			</p>
			<ul>
				<c:forEach items="${modulosmatriculados}" var="modulo">
					<li><c:out value="${modulo}"></c:out></li>
				</c:forEach>
			</ul>
		</c:if>





	</section>
</body>
</html>