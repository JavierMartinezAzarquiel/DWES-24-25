<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<title>Title</title>
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
	<div class="container shadow">
		<header class="bg-primary p-4">
			<img src="img/logo-white.png" alt="" width="120">
		</header>
		<main>
		<div class="row justify-content-center align-items-center px-2">
                <div class="col-md-3">
                    <form action="Controller?operacion=cambiomarca" method="post">
                        <select class="form-select form-select-lg" name="idmarca" id="" onchange="this.form.submit()">
                            <option value="0" disabled selected>Elija Marca</option>
                            <option value="0">Todas</option>
                            <!--  forEach  -->
                        </select>
                    </form>
                </div>
                <div class="col-md-3">
                    <form action="Controller?operacion=cambioorden" method="post">
                        <select class="form-select form-select-lg" name="orden" id="" onchange="this.form.submit()">
                            <option value="null" disabled selected>Elija Orden</option>
                            <option value="marca">Marca</option>
                            <option value="precio asc">Precio Ascendente</option>
                            <option value="precio desc">Precio Descendente</option>
                        </select>
                    </form>
                </div>
                <div class="col-md-3 text-end">
                       <span class="text-secondary display-4">&#9733;</span>
                </div>
            </div>
			<div class="row justify-content-center mt-3">
				<c:forEach items="${bicis}" var="bici">
					<div class="col-xl-3 col-lg-4 col-md-6  position-relative mb-3 d-flex">
						<div class="card pb-3 flex-fill">
							<img class="card-img-top" src="${bici.foto}" alt="Title" />
							<div class="card-body">
								<h4 class="card-title">${bici.nombremarca}</h4>
	                            <p class="card-text">${bici.descripcion}
								<p> ${bici.precio}</p>
								<c:choose>
									<c:when test="${bici.fav==0}">
										<span
											class="text-secondary display-6 position-absolute bottom-0 start-0 ms-2 mb-2">&#9733;</span>
									</c:when>
									<c:otherwise>
										<span
											class="text-warning display-6 position-absolute bottom-0 start-0 ms-2 mb-2">&#9733;</span>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</main>
		<footer class="bg-primary text-white p-2">
			<h5 class="text-center">&copy; Alltricks</h5>
		</footer>
	</div>
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