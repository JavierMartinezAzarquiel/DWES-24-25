<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% 
		  String[] provinciasclm={"Toledo","Ciudad Real","Albacete","Cuenca","Guadalajara"};
		  pageContext.setAttribute("provinciascastillalamancha", provinciasclm);
		  %>

		<table>
		<c:forEach items="${provinciascastillalamancha}" var="provincia">
			<tr>
			<td><c:out value="${provincia}"></c:out></td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>