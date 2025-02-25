package com.azarquiel.s2daw.ejemploJPA.service;


import com.azarquiel.s2daw.ejemploJPA.dto.PeliculaDto;

import java.util.List;

public interface PeliculaService {

    List<PeliculaDto> findAll();

    PeliculaDto findById(String idpelicula);

    void save(PeliculaDto peliculaDto);

    void deleteById(String idpelicula);

}
