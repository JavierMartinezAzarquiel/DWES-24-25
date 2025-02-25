package com.azarquiel.s2daw.ejemploJPA.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pelicula", schema = "cinemania")
public class Pelicula {
    @Id
    @Column(name = "idpelicula", nullable = false, length = 15)
    private String idpelicula;

    @Column(name = "titulo", length = 80)
    private String titulo;

    @OneToMany(mappedBy = "idpelicula")
    private List<Reparto> repartos = new ArrayList<>();

    public List<Reparto> getRepartos() {
        return repartos;
    }

    public void setRepartos(List<Reparto> repartos) {
        this.repartos = repartos;
    }

    public String getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(String idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}