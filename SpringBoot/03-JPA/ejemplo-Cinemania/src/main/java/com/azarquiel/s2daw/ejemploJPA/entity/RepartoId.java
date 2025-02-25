package com.azarquiel.s2daw.ejemploJPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RepartoId implements Serializable {
    private static final long serialVersionUID = -1003104535680103405L;
    @Column(name = "idpelicula", nullable = false, length = 15)
    private String idpelicula;

    @Column(name = "idprotagonista", nullable = false, length = 15)
    private String idprotagonista;

    public String getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(String idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getIdprotagonista() {
        return idprotagonista;
    }

    public void setIdprotagonista(String idprotagonista) {
        this.idprotagonista = idprotagonista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RepartoId entity = (RepartoId) o;
        return Objects.equals(this.idpelicula, entity.idpelicula) &&
                Objects.equals(this.idprotagonista, entity.idprotagonista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpelicula, idprotagonista);
    }

}