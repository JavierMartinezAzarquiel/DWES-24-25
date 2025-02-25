package com.azarquiel.s2daw.ejemploJPA.rest;

import com.azarquiel.s2daw.ejemploJPA.dto.PeliculaDto;
import com.azarquiel.s2daw.ejemploJPA.errors.PeliculaNotFoundException;
import com.azarquiel.s2daw.ejemploJPA.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeliculaRestController {

    private PeliculaService peliculaService;

    @Autowired
    public PeliculaRestController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }
    
    @GetMapping("/peliculas")
    public List<PeliculaDto> findAll() {
        return peliculaService.findAll();
    }

    @GetMapping("/peliculas/{idpelicula}")
    public PeliculaDto getPelicula(@PathVariable String idpelicula) {

        PeliculaDto  pelicula = peliculaService.findById(idpelicula);

        if (pelicula == null) {
            throw new PeliculaNotFoundException("La película no existe - " + idpelicula);
        }

        return pelicula;
    }


    @PostMapping("/peliculas")
    public void addPelicula(@RequestBody PeliculaDto pelicula) {
        peliculaService.save(pelicula);
    }


    @PutMapping("/peliculas")
    public void updatePelicula(@RequestBody PeliculaDto pelicula) {
        peliculaService.save(pelicula);
    }

    @DeleteMapping("/peliculas/{idpelicula}")
    public void deletePelicula(@PathVariable String idpelicula) {

        PeliculaDto pelicula = peliculaService.findById(idpelicula);

        if (pelicula == null) {
            throw new PeliculaNotFoundException("La película no existe - " + idpelicula);
        }

        peliculaService.deleteById(idpelicula);

    }

}














