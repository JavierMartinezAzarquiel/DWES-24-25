<%@taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!doctype html>
        <html lang="en">

        <head>
            <title>Carro de la compra</title>
            <!-- Required meta tags -->
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

            <!-- Bootstrap CSS v5.2.1 -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                crossorigin="anonymous" />
        </head>

        <body>
            <header style="background-color: rgb(255, 255, 255);" class="py-2">
                <div class="container" style="text-align:center;">
                    <img src="resources/imagenes/headerazarquiel.jpg" alt="" class="txt-center" aria-hidden="true"></i>
                </div>
            </header>
            <main>
                <div class="container shadow">
                    <h2 style="text-align:center;">BIENVENIDO A LA PAGINA DE COMPRA</h2>
                    <c:if test="${listadoProductos!=null}">
                        <table class="table table-striped table-hover">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">DESCRIPCION</th>
                                <th scope="col">PRECIO</th>
                                <th scope="col"></th>
                            </tr>
                            <c:forEach items="${listadoProductos}" var="producto">
                                <tr>
                                    <td class="justcentro">${producto.id}</td>
                                    <td class="justcentro">${producto.nombre}</td>
                                    <td class="justder">${producto.precio_normal}</td>
                                    <td class="text-center"><a
                                            href="controller?operacion=addproducto&producto=${producto.id}"><img
                                                src="resources/imagenes/tobasket_button.gif" title="Añadir Producto"
                                                width="37" height="37"></a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
                <c:if test="${carroCliente!=null}">
                    <c:choose>
                        <c:when test="${!carroCliente.elementos.isEmpty()}">
                            <h3 style="text-align:center">CONTENIDO ACTUAL DEL CARRO</h3>
                            <div class="container shadow">
                                <table class="table table-striped table-hover">

                                    <tr>
                                        <th scope="col" style="text-align:center">CODIGO</th>
                                        <th scope="col" style="text-align:center">PRODUCTO</th>
                                        <th scope="col" style="text-align:center">PRECIO</th>
                                        <th scope="col" style="text-align:center">CANTIDAD</th>
                                        <th scope="col" style="text-align:center">TOTAL</th>
                                        <th scope="col"></th>
                                        <th scope="col"></th>
                                        <th scope="col"></th>
                                    </tr>
                                    <c:set var="total" value="${0}" />
                                    <c:forEach items="${carroCliente.elementos}" var="productocarro">
                                        <tr>
                                            <c:set var="total"
                                                value="${total + productocarro.precio_normal*productocarro.cantidad}" />
                                            <td style="text-align:center">${productocarro.id}</td>
                                            <td style="text-align:center">${productocarro.nombre}</td>
                                            <td style="text-align:right;">${productocarro.precio_normal}</td>
                                            <td style="text-align:right;">${productocarro.cantidad}</td>
                                            <td style="text-align:right;">
                                                ${productocarro.precio_normal*productocarro.cantidad}</td>
                                            <td style="text-align:center"><a
                                                    href="controller?operacion=addproducto&producto=${productocarro.id}"><img
                                                        src="resources/imagenes/addCarro.png" title="incrementar"
                                                        width="37" height="37"></a></td>
                                            <td style="text-align:center"><a
                                                    href="controller?operacion=restarcantidadproducto&producto=${productocarro.id}"><img
                                                        src="resources/imagenes/remCarro.png" title="decrementar"
                                                        width="37" height="37"></a></td>
                                            <td style="text-align:center"><a
                                                    href="controller?operacion=eliminarproducto&producto=${productocarro.id}"><img
                                                        src="resources/imagenes/delCarro.png" title="Eliminar Producto"
                                                        width="37" height="37"></a></td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td colspan="4">Total</td>
                                        <td class="resaltado">${sessionScope.carroCliente.total}</td>
                                    </tr>
                                </table>
                            </div>
                            <div class="container shadow">
                                <div class="h3 text-decoration-none" style="text-align:center">
                                    <a href="getdatospedido.jsp">Formalizar Pedido</a>
                                </div>
                            </div>
                        </c:when>
                    </c:choose>
                </c:if>
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