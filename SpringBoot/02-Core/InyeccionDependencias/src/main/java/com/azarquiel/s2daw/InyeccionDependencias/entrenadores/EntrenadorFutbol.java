package com.azarquiel.s2daw.InyeccionDependencias.entrenadores;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class EntrenadorFutbol implements Entrenador{

//    public EntrenadorFutbol() {
//        System.out.println("Iniciando Bean : "+ getClass().getSimpleName());
//    }

    @PostConstruct
    public void iniciando() {
        System.out.println("Iniciando Bean: " + getClass().getSimpleName());
    }
    @PreDestroy
    public void cerrando() {
        System.out.println("Cerrando Bean: " + getClass().getSimpleName());
    }

    @Override
    public String getEntrenamiento() {
        return "Toca entrenar los lanzamientos de penalti";
    }
}
