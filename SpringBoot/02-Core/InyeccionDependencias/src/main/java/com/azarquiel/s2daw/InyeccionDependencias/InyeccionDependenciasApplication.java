package com.azarquiel.s2daw.InyeccionDependencias;

import com.azarquiel.s2daw.InyeccionDependencias.entrenadores.EntrenadorFutbol;
import com.azarquiel.s2daw.InyeccionDependencias.rest.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InyeccionDependenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(InyeccionDependenciasApplication.class, args);
	}

	// ya no es necesario crear los objetos, se crean automáticamente los beans
	//new Controller(new EntrenadorFutbol())
}
