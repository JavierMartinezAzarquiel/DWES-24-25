package com.azarquiel.s2daw.ejemploJPA.dto;

import java.io.Serializable;
import java.util.Objects;


public class ProtagonistaDto implements Serializable {
    private String idprotagonista;
    private String nombre;

    public ProtagonistaDto(String idprotagonista, String nombre) {
        this.idprotagonista = idprotagonista;
        this.nombre = nombre;
    }

    public String getIdprotagonista() {
        return idprotagonista;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtagonistaDto entity = (ProtagonistaDto) o;
        return Objects.equals(this.idprotagonista, entity.idprotagonista) &&
                Objects.equals(this.nombre, entity.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idprotagonista, nombre);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idprotagonista = " + idprotagonista + ", " +
                "nombre = " + nombre + ")";
    }
}