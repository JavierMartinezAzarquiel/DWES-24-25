<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de autores</title>
<jsp:directive.include file="../includes/includefile.jspf" />
</head>
<body>
	<div class="container">
		<div class="header"></div>
		<div class="menu">
			<jsp:directive.include file="/WEB-INF/menu.jspf" />
		</div>
		<c:if test="${error != null}">
			<div class="diverror">
				<p>
					<strong><c:out value="Error" /></strong> <br>
					<c:out value="${error}" />
				</p>
			</div>
		</c:if>
		<c:if test="${confirmaroperacion != null}">
			<div class="divconfirmacion">
				<p>
					<strong><c:out value="Mensaje" /></strong> <br>
					<c:out value="${confirmaroperacion}" />
				</p>
			</div>
		</c:if>		
	<c:if test="${not empty listadoautores}">
		<div class="w-75 ma py-2">
			<table class="table tablaconborde tablacebra tabla-hover">
				<caption>Listado de Autores</caption>
				<thead>
				<tr>
					<th scope="col">CODIGO</th>
					<th scope="col">NOMBRE</th>
					<th scope="col">FECHA NACIMIENTO</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${listadoautores}" var="autor">
						<tr>
						<td class="txtderecha">${autor.idAutor}</td>
						<td>${autor.nombre}</td>
                 	    <td class="txtcentrado"><fmt:formatDate 
                 	                             value="${autor.fechaNacimiento}"
                 	                             pattern="dd-MM-yyyy" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="w-75 ma py-2">
				<c:set var="totalregistros" value="${totalregistros}"></c:set>
				<c:set var="paginaactual" value="${pagina}"></c:set>
				<c:set var="registrosporpagina" value="${numregpag}"></c:set>
				<c:set var="paginamasalta" value="${paginamasalta}"></c:set>
				<c:out value="Total Registros: ${totalregistros}"></c:out>
				<c:out
					value="Mostrando desde ${(registrosporpagina*paginaactual)+1} a ${(registrosporpagina*paginaactual)+registrosporpagina < totalregistros?(registrosporpagina*paginaactual)+registrosporpagina:totalregistros}"></c:out>
				<a
					href="${pageContext.request.contextPath}/controllersocio?operacion=listarAutoresPaginado&pag=${paginaactual+1>paginamasalta?0:paginaactual+1}&nrp=${registrosporpagina} ">
					Sig</a> <a
					href="${pageContext.request.contextPath}/controllersocio?operacion=listarAutoresPaginado&pag=${paginaactual-1>=0?paginaactual-1:paginamasalta}&nrp=${registrosporpagina} ">Ant</a>
			</div>
	</c:if>		
   </div>
</body>
</html>