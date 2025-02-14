package com.azarquiel.s2daw.InyeccionDependencias.entrenadores;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EntrenadorBaloncesto implements Entrenador{

    //constructor


//    public EntrenadorBaloncesto() {
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
        return "Toca entrenar los lanzamientos triples";
    }
}
