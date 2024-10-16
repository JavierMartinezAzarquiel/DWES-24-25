<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<title>Conversor Millas Kilometros</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
</head>

<body>
	<header>
	</header>
	<main>
		<div class="w-50 p-4" id="formulario">
			<form name="frmAutor" method="post"
				action="${pageContext.request.contextPath}/controller">
				<br>
				<fieldset id="Operacion">
					<legend>Operación a realizar</legend>
					<br>
					<div>
						<label for="operacion">Operación:</label> <select
							name="conversion">
							<option value="kmamillas"
								${conversionelegida=='kmamillas' ? 'selected' : '' }>Km
								a Millas</option>
							<option value="millasakm"
								${conversionelegida=='millasakm' ? 'selected' : '' }>
								Millas a Km</option>
						</select>
					</div>
					<br>
					<div>
						<label>Cantidad: </label> <input type="text" id="cantidad"
							name="cantidad" value="${cantidad}" /> <input type="submit"
							value="Calcular" />
					</div>
				</fieldset>
			</form>
			<br>
			<c:if test="${resultado != null}">
				<c:out value="El resultado es: "></c:out>
				<c:out value="${resultado}"></c:out>
				<c:choose>
					<c:when test="${conversionelegida == 'kmamillas' }">
						<c:out value="Millas"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="Km"></c:out>
					</c:otherwise>
				</c:choose>

			</c:if>
		</div>
	</main>
	<footer>
		<!-- place footer here -->
	</footer>
	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>

</html>