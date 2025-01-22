<%@page import="java.util.List"%>
<%@page import="model.PuntoView"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="table table-striped text-primary w-50 m-auto">
  <tbody>
      <c:forEach items="${puntuaciones}" var="puntoview">
          <tr>
            <td><img src="img/ic_${puntoview.punto}.png" alt=""></td>
            <td>${puntoview.cuenta}</td>
          </tr>          
      </c:forEach>
  </tbody>
</table>
