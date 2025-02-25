package com.azarquiel.s2daw.ejemploJPA.dao;

import com.azarquiel.s2daw.ejemploJPA.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, String> {

    // that's it ... no need to write any code LOL!

}
