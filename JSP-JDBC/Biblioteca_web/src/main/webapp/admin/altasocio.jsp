<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Socio</title>
<jsp:directive.include file="../includes/includefile.jspf" />
</head>
<body>
	<div class="container">
		<div class="header"></div>
		<div class="menu">
			<jsp:directive.include file="../WEB-INF/menu.jspf" />
		</div>
		<c:if test="${error != null}">
			<div class="diverror">
				<p>
					<strong><c:out value="Error" /></strong> <br>
					<c:out value="${error}" />
				</p>
			</div>
		</c:if>
		<div id="divAltaSocio" class="formulariogeneral">
			<form name="frmSocio" method="post"
				action="${pageContext.request.contextPath}/controlleradmin">
				<fieldset id="datosSocio">
					<legend>
						<img src="../resources/img/azarquiel.gif">&nbsp;Nuevo Socio
					</legend>
					<div class="etiquetas">
						<label for="nombre">Nombre:</label>
					</div>
					<div class="campos">
						<input type="text" id="nombre" name="nombre" />
					</div>
					<div class="etiquetas">
						<label for="email">Email:</label>
					</div>
					<div class="campos">
						<input type="email" id="email" name="email" />
					</div>
					<div class="etiquetas">
						<label for="password">Clave:</label>
					</div>
					<div class="campos">
						<input type="password" id="password" name="password" />
					</div>
					<div class="etiquetas">
						<label for="direccion">Direccion:</label>
					</div>
					<div class="campos">
						<input type="text" id="direccion" name="direccion" /> 
						<input name="operacion" type="hidden" id="operacion" value="registrarse">
					</div>

					<div class="cb"></div>
					<div class="botones">
						<input type="submit" name="Submit" value="Alta">
					</div>
				</fieldset>
			</form>
		</div>

		<div id="separacion">
			<br>
		</div>
	</div>
</body>
</html>