<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Consulta bibliográfica</title>
<jsp:directive.include file="../includes/includefile.jspf" />
</head>
<body>
	<div class="container">
		<div class="header"></div>
		<div class="menu">
			<jsp:directive.include file="../WEB-INF/menu.jspf" />
		</div>
		<div id="formBusquedaLibro" class="formulariogeneral">
		<form name="frmBusquedaLibro" method="POST" action="${pageContext.request.contextPath}/controllersocio">
			<fieldset id="datosLibro">
			<legend><img src="${pageContext.request.contextPath}/resources/img/azarquiel.gif">&nbsp;Búsqueda sencilla</legend>
			<table>
	  			<tr>
					<td><input name="valorbusqueda" type="search" id="valorbusqueda" value="${valorbusqueda}" size="25" maxlength="40"></td>
					<td>
		  			  <select name="criteriobusqueda">
					      <option value="autor">autor</option>
					      <option value="titulo" <c:if test="${criteriobusqueda.equals('titulo')}">
					      						<c:out value="selected"></c:out>
					      						</c:if> 
					      >titulo</option>
					      <option value="isbn" ${criteriobusqueda.equals('isbn')?'selected':''} >isbn</option>
					  </select>
					</td>
		    		<td><input type="submit" name="Submit" value="Buscar"></td>
		    		<td><input name="operacion" type="hidden" id="operacion" value="busquedalibros"></td>
	  			</tr>
			</table>
			</fieldset>
		</form>	
	</div>
    <c:if test="${requestScope.listadoLibrosBusqueda!=null}" >
	 <c:choose>
		<c:when test="${!requestScope.listadoLibrosBusqueda.isEmpty()}">
			<div class="w-75 ma">
        		<table class="table tablaconborde tablacebra tabla-hover">      
             	<caption>Listado de Libros
             	</caption>   
             	<thead>  	
		  		<tr>
		    		<th scope="col">TITULO</th>
			        <th scope="col">AUTOR</th>
					<th scope="col">TOTALES</th>
					<th scope="col">PRESTADOS</th>
					<th scope="col">DISPONIBLES</th>
		 		 </tr>
		 		 </thead>
		 		 <tbody>
					<c:forEach items="${requestScope.listadoLibrosBusqueda}" var="libro">
						<tr>		           
						  <td>${libro.titulo}</td>
			        	  <td>${libro.nombreAutor}</td>
			              <td class="txtderecha">${libro.ejemplaresTotales}</td>
			              <td class="txtderecha">${libro.ejemplaresEnPrestamo}</td>
			              <td class="txtderecha">${libro.ejemplaresDisponibles}</td>
			            </tr>		
					</c:forEach>
					</tbody>
				 </table>
			 </div>
		 </c:when>
		<c:otherwise>		
		   <p align="center" class="advertencia">No hay registros coincidentes </p>
		</c:otherwise>
			</c:choose>
	</c:if>			
   </div>
</body>
</html>