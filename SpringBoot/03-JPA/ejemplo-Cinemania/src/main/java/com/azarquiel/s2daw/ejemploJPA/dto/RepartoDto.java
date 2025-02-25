package com.azarquiel.s2daw.ejemploJPA.dto;

import java.io.Serializable;
import java.util.Objects;


public class RepartoDto implements Serializable {
    private String idIdpelicula;
    private String idIdprotagonista;
    private String papel;

    public RepartoDto(String idIdpelicula, String idIdprotagonista, String papel) {
        this.idIdpelicula = idIdpelicula;
        this.idIdprotagonista = idIdprotagonista;
        this.papel = papel;
    }

    public String getIdIdpelicula() {
        return idIdpelicula;
    }

    public String getIdIdprotagonista() {
        return idIdprotagonista;
    }

    public String getPapel() {
        return papel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepartoDto entity = (RepartoDto) o;
        return Objects.equals(this.idIdpelicula, entity.idIdpelicula) &&
                Objects.equals(this.idIdprotagonista, entity.idIdprotagonista) &&
                Objects.equals(this.papel, entity.papel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIdpelicula, idIdprotagonista, papel);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idIdpelicula = " + idIdpelicula + ", " +
                "idIdprotagonista = " + idIdprotagonista + ", " +
                "papel = " + papel + ")";
    }
}