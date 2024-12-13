<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<title>Formalizar pedido</title>
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
<script src="resources/js/validate.js"></script>
<script type="text/JavaScript">
function validar_formulario(formulario_actual)
{ 
   if(mandatory_fields_completed(formulario_actual))
     formulario_actual.submit();
}
</script>
</head>
<body>
			<header style="background-color: rgb(255, 255, 255);" class="py-2">
                <div class="container" style="text-align:center;">
                    <img src="resources/imagenes/headerazarquiel.jpg" alt="" class="txt-center" aria-hidden="true"></i>
                </div>
            </header>
            <main>
            <h2 style="text-align:center">INTRODUZCA SU IDENTIFICADOR DE CLIENTE Y LA DIRECCION DE ENVIO</h2>
                <div class="container shadow">
                    
                <div id="formularioPedido" class="formulariogeneral">
			<form action="controller" method="post" name="identificacion"
				target="_self" id="identificacion">
				<fieldset id="datosAutor">
					<legend>Datos Pedido</legend>
					<table>
						<tr>
							<td class="txt-right">* Id</td>
							<td colspan="3"><input name="idcliente" type="text"
								id="idcliente"></td>
						</tr>
						<tr>
							<td class="txt-right">*Direccion de Envio</td>
							<td class="txt-left"><input name="direccion" type="text"
								id="direccion" size="40"></td>
							<td><input type="button" name="Submit" value=" Finalizar "
								onclick="validar_formulario(this.form)"></td>
							<td width="29%"><input name="operacion" type="hidden"
								id="operacion" value="validarygrabarpedido"></td>
						</tr>
					</table>
				</fieldset>

			</form>
		</div>
		<c:if test="${requestScope.error != null}">
			<div class="diverror">
				<p>
					<strong><c:out value="Error" /></strong> <br>
					<c:out value="${requestScope.error}" />
				</p>
			</div>
		</c:if>
		<script type="text/javascript">
			document.forms[0].idcliente.mandatory = true
			document.forms[0].direccion.mandatory = true
		</script>
            </main>
            
            <footer>
                <!-- place footer here -->
            </footer>
            <!-- Bootstrap JavaScript Libraries -->
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                crossorigin="anonymous"></script>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
                crossorigin="anonymous"></script>
</body>
</html>