package com.azarquiel.s2daw.ejemploJPA.dto;

public class PeliculaDTO {
    private String idpelicula;
    private String titulo;

    public PeliculaDTO() {
    }

    public PeliculaDTO(String idpelicula, String titulo) {
        this.idpelicula = idpelicula;
        this.titulo = titulo;
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

    @Override
    public String toString() {
        return "PeliculaDTO{" +
                "idpelicula='" + idpelicula + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
