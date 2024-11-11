<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Devolución Préstamo</title>
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
         <c:if test="${confirmaroperacion != null}">
            <div class="divconfirmacion">
               <p>
                  <strong><c:out value="Mensaje" /></strong> <br>
                  <c:out value="${confirmaroperacion}" />
               </p>
            </div>
         </c:if>      
      <div id="formDevolucion" class="formulariogeneral">
         <form name="formDevolucion" method="POST"
            action="${pageContext.request.contextPath}/controllerAdmin">
            <fieldset id="datosDevolucion">
               <legend><img src="${pageContext.request.contextPath}/resources/img/azarquiel.gif">&nbsp;Datos Devolucion</legend>
               		<div class="etiquetas">
						<label for="numeroejemplar">Código de Ejemplar:</label>
					</div>
					<div class="campos">
						<input type="text" 
						       id="numeroejemplar" 
						       name="numeroejemplar"
						       value="${ejemplar}" />
					</div>
					<div class="cb"></div>
 					<input name="operacion" type="hidden"
                        id="operacion" value="devolucion">
					<div class="botones">	
							<input type="submit" name="Submit" value="Devolver">
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