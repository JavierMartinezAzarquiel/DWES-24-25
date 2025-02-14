package com.azarquiel.s2daw.InyeccionDependencias.entrenadores;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


public class EntrenadorTenis implements Entrenador{

    @Override
    public String getEntrenamiento() {
        return "Toca entrenar el saque";
    }
}
