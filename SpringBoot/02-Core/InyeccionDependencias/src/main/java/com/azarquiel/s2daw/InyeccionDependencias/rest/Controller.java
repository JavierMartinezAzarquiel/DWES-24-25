package com.azarquiel.s2daw.InyeccionDependencias.rest;

import com.azarquiel.s2daw.InyeccionDependencias.entrenadores.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    //Atributo para contener el entrenador asociado
    private Entrenador miEntrenador;
    private Entrenador miSegundoEntrenador;

    @Autowired
    public Controller(@Qualifier("entrenadorTenis") Entrenador miEntrenador,
                      @Qualifier("entrenadorBaloncesto") Entrenador miSegundoEntrenador) {
        this.miEntrenador = miEntrenador;
        this.miSegundoEntrenador = miSegundoEntrenador;
        System.out.println("Iniciando Controller");
    }

//    @Autowired
//    public void setMiEntrenador(@Qualifier("entrenadorBaloncesto") Entrenador miEntrenador){
//        this.miEntrenador=miEntrenador;
//    }

    @GetMapping("/entrenamiento")
    public String entrenamiento(){
        return miEntrenador.getEntrenamiento();
    }

    @GetMapping("/comprobar")
    public String comprobar(){
        return "Comprobación de Beans: " + (miEntrenador==miSegundoEntrenador);
    }
}
