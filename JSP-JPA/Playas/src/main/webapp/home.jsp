
<%@page import="model.Usuario"%>
<%@page import="model.Municipio"%>
<%@page import="model.Provincia"%>
<%@page import="model.Ccaa"%>
<%@page import="model.Playa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
  <title>Playas</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->

    <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="css/mycss.css">
 </head>

<body>

  <div class="container shadow">
    <header>
      <div class="row align-items-center">
          <div class="col-2"><img src="img/logo.png" alt="" class="img-fluid"></div>
        <div class="col-10">
          <div class="row align-items-center">
            <div class="col-md-3">
              <form action="Controller?op=ccaa" method="post">
                <div class="form-group">
                  <select class="form-control" name="idccaa" id="idccaa" onchange="this.form.submit()">
                    <option disabled selected value="">Elija CCAA</option>
                    <c:forEach items="${comunidades}" var="comunidad">
                        <option value="${comunidad.id}">${comunidad.nombre}</option>
                    </c:forEach>
                  </select>
                </div>
              </form>
            </div>
            <div class="col-md-3">
              <form action="Controller?op=provincia" method="post">
                <div class="form-group">
                  <select class="form-control" name="idprovincia" id="idprovincia" onchange="this.form.submit()">
                    <option disabled selected value="">Elija Provincia</option>
                    <c:forEach items="${comunidadSelected.provincias}" var="provincia">
                        <option value="${provincia.id}">${provincia.nombre}</option>
                    </c:forEach>
                  </select>
                </div>
              </form>
            </div>
            <div class="col-md-3">
              <form action="Controller?op=municipio" method="post">
                <div class="form-group">
                  <select class="form-control" name="idmunicipio" id="idmunicipio" onchange="this.form.submit()">
                    <option disabled selected value="">Elija Municipio</option>
                        <c:forEach items="${provinciaSelected.municipios}" var="municipio">
                            <option value="${municipio.id}">${municipio.nombre}</option>
                        </c:forEach>
                  </select>
                </div>
              </form>
            </div>
              <div class="col-md-3">
          <div class="row">
              <div class="ml-auto pr-3">
                  <c:choose>
                      <c:when test="${usuario==null}">
                          <button class="btn btn-danger my-2 my-sm-0" data-bs-toggle="modal" data-bs-target="#modallogin">Login</button>    
                      </c:when>
                      <c:otherwise>
                         <span class="text-primary ml-2 h5">Welcome ${usuario.nick}</span>
                         <a href="Controller?op=logout" class="btn btn-success my-2 my-sm-0">Logout</a>     
                      </c:otherwise>
                  </c:choose>
              </div>
          </div>                  
              </div>
          </div>
        </div>
      </div>
    </header>
    <div class="row justify-content-center">
        <c:forEach items="${municipioSelected.playas}" var="miplaya">
            <div class="col-md-6 my-2 d-flex">
                <div class="card text-left d-fill">
                    <img src="ImgPlayas/${miplaya.id}_${miplaya.images[0].id}.jpg" class="img-fluid" alt="...">
                    <div class="card-body">
                        <h4 class="card-title">${miplaya.nombre}</h4>
                        <p class="card-text">${miplaya.descripcion}</p>
                    </div>
                    <c:if test="${usuario!=null}">
                        <a data-bs-toggle="modal" data-bs-target="#modalinfo" data-bs-nombreplaya="${miplaya.nombre}" data-bs-idplaya="${miplaya.id}"><i id="info" class="fa fa-info-circle text-danger fa-3x" aria-hidden="true"></i></a>
                        <a href="Controller?op=detail&playa=${miplaya.id}"><i id="star" class="fa fa-star-half-o text-warning fa-3x" aria-hidden="true"></i></a>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
  </div>

        <!-- Modal Login -->
        <div class="modal fade" id="modallogin" tabindex="-1" data-bs-keyboard="false"
            role="dialog" aria-labelledby="modalTitleId" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalTitleId">
                            Login & Register
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="Controller?op=login" method="post">
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="" class="form-label">Nick</label>
                                <input type="text" class="form-control" name="nick" id="" aria-describedby="helpId"
                                    placeholder="" />

                            </div>
                            <div class="mb-3">
                                <label for="" class="form-label">Password</label>
                                <input type="password" class="form-control" name="pass" id="" placeholder="" />
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                Cancel
                            </button>
                            <button type="submit" class="btn btn-primary">Login & register</button>
                        </div>
                    </form>
                   
                </div>
            </div>
        </div>

   <!-- Modal info -->
    <div class="modal fade" id="modalinfo" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <h3 class="modal-title bg-dark text-success text-center">Calificación de la playa</h3>
                <div class="modal-header">
                    <h4 class="text-success">
                        <!-- Nombre playa -->
                    </h4>
                </div>
                <div class="modal-body">
                    <!-- se rellena con ajax -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

   
    <div class="position-fixed top-50 start-50 translate-middle">
        <div id="tostada" class="toast rounded-pill border-2 border-danger" role="alert" aria-live="assertive" aria-atomic="true" data-bs-delay="2000">
            <div class="toast-body bg-light text-danger text-center rounded-pill">
                <h5>${msg}</h5>
            </div>
        </div>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
        
    <script type="text/javascript" src="js/js.js"></script>
    
    <script type="text/javascript">
        
        function selectElement(id, valueToSelect) {    
            let element = document.getElementById(id);
            element.value = valueToSelect;
        }

        selectElement('idccaa', '${comunidadSelected.id}');
        selectElement('idprovincia', '${provinciaSelected.id}');
        selectElement('idmunicipio', '${municipioSelected.id}');
    
    </script>
    
<c:if test="${msg!=null}">
	<script type="text/javascript">
    	const tostada = document.getElementById('tostada')
    	const toastBootstrap = bootstrap.Toast.getOrCreateInstance(tostada)
    	toastBootstrap.show()
	</script>
	<c:remove var="msg" scope="session" />
</c:if>
</body>

</html>