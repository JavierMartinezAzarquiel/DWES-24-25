package com.azarquiel.s2daw.ejemploJPA.dao;


import com.azarquiel.s2daw.ejemploJPA.entity.Reparto;
import com.azarquiel.s2daw.ejemploJPA.entity.RepartoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepartoRepository extends JpaRepository<Reparto, RepartoId> {
}
