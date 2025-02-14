package com.azarquiel.s2daw.InyeccionDependencias.entrenadores;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurar {

    @Bean
    public Entrenador entrenadorTenis() {
        return new EntrenadorTenis();
    }

}

