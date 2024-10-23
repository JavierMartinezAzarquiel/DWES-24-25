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
					<td><input name="valorbusqueda" type="search" id="valorbusqueda"  size="25" maxlength="40"></td>
					<td>
		  			  <select name="criteriobusqueda">
					      <option value="autor">autor</option>
					      <option value="titulo">titulo</option>
					      <option value="isbn">isbn</option>
					  </select>
					</td>
		    		<td><input type="submit" name="Submit" value="Buscar"></td>
		    		<td><input name="operacion" type="hidden" id="operacion" value="busquedalibros"></td>
	  			</tr>
			</table>
			</fieldset>
		</form>	
	</div>
    
   </div>
</body>
</html>