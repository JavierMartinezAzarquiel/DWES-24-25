<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<!-- La etiqueta set sirve para crear una variable -->	
		<c:set var="misueldo" scope="page" value="${100*10}"/>
		
		<c:set var="salariominimo" scope="page" value="1134"/>
		
		<!-- choose es una etiqueta para simular un if -->
		<c:choose>
			<c:when test="${misueldo > salariominimo}">
				<p>
					Mi sueldo es mayor que el salario minimo que actualmente es:
					<b>
						<c:out value="${salariominimo}"/>
					</b>
				</p>
				<p>
					Concretamente gano: <b><c:out value="${misueldo}€ mensuales"></c:out></b>	
			</c:when>	
		
		<c:otherwise>
				<p>
					Mi sueldo es inferior que el salario minimo que actualmente es:
					<b>
						<c:out value="${salariominimo}"/>
					</b>
				</p>
				<p>
					Concretamente gano: <b><c:out value="${misueldo}€ mensuales"></c:out></b>
				</p>	
	  			<p>
					Por tanto, me faltan 
					<b><c:out value="${salariominimo - misueldo }€"></c:out></b>
								para llegar a final de mes
				</p>
		</c:otherwise>
		</c:choose>
</body>
</html>