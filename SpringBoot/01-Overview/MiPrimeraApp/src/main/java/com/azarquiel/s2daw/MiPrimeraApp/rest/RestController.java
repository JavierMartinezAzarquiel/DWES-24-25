package com.azarquiel.s2daw.MiPrimeraApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    //recupero las variables del archivo aplication.properties
    @Value("${entrenador.nombre}")
    private String entrenador;
    @Value("${equipo.nombre}")
    private String equipo;

    //Preparar los mapeos para las url's que necesito responder

    @GetMapping("/")
    public String inicio(){
        return "Página del equipo: " + equipo + " entrenado por " + entrenador;
    }

    @GetMapping("/hola")
    public String saludar(){
        return "Hola, buenas tardes, encantado de saludarle!";
    }
}
