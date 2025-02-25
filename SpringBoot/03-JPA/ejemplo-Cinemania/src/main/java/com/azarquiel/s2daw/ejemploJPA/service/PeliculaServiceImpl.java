package com.azarquiel.s2daw.ejemploJPA.service;

import com.azarquiel.s2daw.ejemploJPA.dao.PeliculaRepository;
import com.azarquiel.s2daw.ejemploJPA.dto.PeliculaDto;
import com.azarquiel.s2daw.ejemploJPA.entity.Pelicula;
import com.azarquiel.s2daw.ejemploJPA.errors.PeliculaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private PeliculaRepository peliculaRepository;

    @Autowired
    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public List<PeliculaDto> findAll() {
        List<Pelicula> peliculas = peliculaRepository.findAll();

        List<PeliculaDto> listaDTO=peliculas.stream()
                .map(pelicula -> new PeliculaDto(pelicula.getIdpelicula(), pelicula.getTitulo()))
                .toList();

        return listaDTO;
    }

    @Override
    public PeliculaDto findById(String idpelicula) {
        Optional<Pelicula> result = peliculaRepository.findById(idpelicula);

        Pelicula mipelicula = null;

        if (result.isPresent()) {
            mipelicula = result.get();
        }
        else {
            throw new PeliculaNotFoundException("Pelicula no encontrada: " + idpelicula);
        }

        return new PeliculaDto(mipelicula);
    }

    @Override
    public void save(PeliculaDto peliculaDto) {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdpelicula(peliculaDto.getIdpelicula());
        pelicula.setTitulo(peliculaDto.getTitulo());
        peliculaRepository.save(pelicula);
    }

    @Override
    public void deleteById(String idpelicula) {
        peliculaRepository.deleteById(idpelicula);
    }
}






