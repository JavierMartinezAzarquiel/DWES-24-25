<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import="model.Image" %>
<%@page import="model.Playa" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous" />
    <link rel="stylesheet" href="css/mycss.css">
</head>

<body>
    <% Playa playa=(Playa) session.getAttribute("playa"); Integer star=(Integer)
        session.getAttribute("star"); %>
        <div class="container shadow">
            <div class="jumbotron bg-primary text-white my-2 text-center">
                <h1 class="display-3">${playa.nombre}</h1>
                <h3 class="display-3"><img src="ImgPlayas/ccaa_${playa.municipioBean.provinciaBean.ccaaBean.id}.png"
                        alt=""></h3>
                <p class="lead">
                    <%=playa.getDescripcion() %>
                </p>
                <hr class="my-1">
                <p class="lead"><img src="img/ic_${star}.png" alt=""></p>
            </div>
            <div id="carouselId" class="carousel slide" data-bs-ride="carousel">
                <ol class="carousel-indicators">
                    <c:set var="i" value="0"></c:set>
                    <c:forEach items="${playa.images}" var="image">
                        <c:choose>
                            <c:when test="${i==0}">
                                <c:set var="i" value="${i+1}"></c:set>
                                <li data-bs-target="#carouselId" data-bs-slide-to="${i-1}"
                                    class="active" aria-current="true" aria-label="${i} slide"></li>
                            </c:when>
                            <c:otherwise>
                                <c:set var="i" value="${i+1}"></c:set>
                                <li data-bs-target="#carouselId" data-bs-slide-to="${i-1}"
                                    aria-label="${i} slide"></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <c:set var="i" value="0"></c:set>
                    <c:forEach items="${playa.images}" var="image">
                        <c:choose>
                            <c:when test="${i==0}">
                                <c:set var="i" value="${i+1}"></c:set>
                                <div class="carousel-item active">
                                    <img src="ImgPlayas/${playa.id}_${image.id}.jpg" class="w-100 d-block"
                                        alt="${image.id} slide" />
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:set var="i" value="${i+1}"></c:set>
                                <div class="carousel-item">
                                    <img src="ImgPlayas/${playa.id}_${image.id}.jpg" class="w-100 d-block"
                                        alt="${image.id} slide" />
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselId"
                    data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselId"
                    data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>

            <div id="votos" class="text-center py-2 bg-light">
                <c:forEach var="i" begin="1" end="5">
                    <a href="Controller?op=savePuntuacion&puntos=${i}"><img src="img/ic_${i}.png"
                            alt=""></a>
                </c:forEach>
            </div>
        </div>
        <!-- Bootstrap JavaScript Libraries -->

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>
</body>

</html>