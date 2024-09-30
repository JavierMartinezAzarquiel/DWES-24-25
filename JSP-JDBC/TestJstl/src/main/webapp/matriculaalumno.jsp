<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es_ES">
<head>
<meta charset="UTF-8">
<title>Matricula</title>
<link rel="stylesheet" href="resources/css/formmatricula.css" />
<link rel="stylesheet" href="resources/css/estilo.css" />
</head>
<body>
            <form action="Controller" method="POST">
                <h1 class="azulcobalto centrar">Formulario de matricula</h1>
                <p>Los campos obligatorios van seguidos de <strong> <abbr title = "Obligatorio"> * </abbr> </strong> son obligatorios.</p>
                <section>
                    <h2 class="azulcobalto">Datos personales</h2>
                    <fieldset>
                      <legend>Alumno</legend>

                    <p>
                      <label for="nombre">
                        <span>Nombre:</span>
                        <strong><abbr title="obligatorio">*</abbr></strong>
                      </label>
                      <input type="text" id="nombre" name="nombre" required>
                    </p>
                    <p>
                      <label for="apellido1">
                        <span>Primer apellido:</span>
                        <strong><abbr title="obligatorio">*</abbr></strong>
                      </label>
                      <input type="text" id="apellido1" name="apellido1" required>
                    </p>  
                    <p>
                      <label for="apellido2">
                        <span>Segundo apellido:</span>
                      </label>
                      <input type="text" id="apellido2" name="apellido2">
                    </p>   
                    <p>
                      <label for="email">
                        <span>Correo electrónico:</span>
                        <strong><abbr title="obligatorio">*</abbr></strong>
                      </label>
                      <input type="email" id="email" name="email" required>
                    </p>
                    <p>
                    <p>
                        <label for="fechanacimiento">
                            <span>Fecha de nacimiento</span>
                            <strong><abbr title="obligatorio">*</abbr></strong>
                          </label>
                          <input type="date" 
                                 id="fechanacimiento" 
                                 name="fechanacimiento" 
                          		 required>
                    </p>
                    <p>
                        <label for="provincianacimiento">
                            <span>Provincia de nacimiento</span>
                    
                          </label>
                        <select id="provincianacimiento" name="provincianacimiento">
	                        <option value="Albacete">Albacete</option>
	                        <option value="Ciudad Real">Ciudad Real</option>
	                        <option value="Cuenca">Cuenca</option>
	                        <option value="Guadalajara">Guadalajara</option>
	                        <option value="Toledo">Toledo</option>
                      </select>
                    </p>                    
                    </fieldset>
                    <br/>
                    <fieldset>
                     <legend>Emancipado</legend>
                        <p>
                            <label class="labelleft" for="emancipado_op1">
                              <input type="radio" id="emancipado_op1" name="emancipado"value="S">
                              Si
                            </label>
                       </p>
                        <p>
                            <label class="labelleft" for="emancipado_op2">
                              <input type="radio" id="emancipado_op2" name="emancipado" value="N">
                              No
                            </label>
                      </p>
                   </fieldset>
                   
                </section>
                <section>
                    <h2 class="azulcobalto">Módulos de los que se matricula</h2>
                    <fieldset>
                      <legend>Módulos</legend>  
					<label class="labelleft">
					    <input type="checkbox" id="modulodwes" value="DWES" name="modulos" checked> 
					    Desarrollo Web en Entorno Servidor
					</label><br>
					<label class="labelleft">
					    <input type="checkbox" id="modulodwec" value="DWEC" name="modulos" checked> 
					    Desarrollo Web en Entorno Cliente
					</label><br>
					<label class="labelleft">
					    <input type="checkbox" id="modulodaw" value="DAW" name="modulos"> 
					    Despliegue de aplicaciones web
					</label><br>	
					<label class="labelleft">
					    <input type="checkbox" id="modulodiw" value="DIW" name="modulos"> 
					    Diseño de interfaces web
					</label><br>	
					<label class="labelleft">
					    <input type="checkbox" id="moduloeie" value="EIE" name="modulos"> 
					    Empresa e iniciativa emprendedora
					</label><br>											
                    </fieldset>                
                </section>    
                <input type="hidden" name="operacion" value="matricular"/>
                <p class="centrar"> <button type="submit">Guardar</button> </p>            
            </form>
</body>
</html>