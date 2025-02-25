package com.azarquiel.s2daw.ejemploJPA.dao;

import com.azarquiel.s2daw.ejemploJPA.entity.Protagonista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProtagonistaRepository extends JpaRepository<Protagonista, String> {

    // that's it ... no need to write any code LOL!

}
