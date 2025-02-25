package com.azarquiel.s2daw.ejemploJPA.rest;

import com.azarquiel.s2daw.ejemploJPA.dto.PeliculaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    //atributo con el objeto Servicio

    @GetMapping("/peliculas")
    public List<PeliculaDTO> getPeliculas() {

    }

    @PostMapping("/peliculas")
    public PeliculaDTO SetPelicula(@RequestBody PeliculaDTO pelicula) {
        servicio.gardarPelicula(pelicula);
    }
}
