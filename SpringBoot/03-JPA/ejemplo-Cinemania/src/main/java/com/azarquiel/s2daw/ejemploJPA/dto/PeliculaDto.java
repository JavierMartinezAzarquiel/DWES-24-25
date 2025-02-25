package com.azarquiel.s2daw.ejemploJPA.dto;

import com.azarquiel.s2daw.ejemploJPA.entity.Pelicula;

import java.io.Serializable;
import java.util.Objects;

public class PeliculaDto implements Serializable {
    private String idpelicula;
    private String titulo;

    public PeliculaDto() {
    }

    public PeliculaDto(String idpelicula, String titulo) {
        super();
        this.idpelicula = idpelicula;
        this.titulo = titulo;
    }
    //constructor para mapeo directo de Entity a Dto
    public PeliculaDto(Pelicula pelicula) {
        super();
        this.idpelicula= pelicula.getIdpelicula();
        this.titulo = pelicula.getTitulo();
    }
    public String getIdpelicula() {
        return idpelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaDto entity = (PeliculaDto) o;
        return Objects.equals(this.idpelicula, entity.idpelicula) &&
                Objects.equals(this.titulo, entity.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpelicula, titulo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idpelicula = " + idpelicula + ", " +
                "titulo = " + titulo + ")";
    }
}