package com.azarquiel.s2daw.ejemploJPA.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "protagonista", schema = "cinemania")
public class Protagonista {
    @Id
    @Column(name = "idprotagonista", nullable = false, length = 15)
    private String idprotagonista;

    @Column(name = "nombre", length = 80)
    private String nombre;

    @OneToMany(mappedBy = "idprotagonista")
    private List<Reparto> repartos = new ArrayList<>();

    public List<Reparto> getRepartos() {
        return repartos;
    }

    public void setRepartos(List<Reparto> repartos) {
        this.repartos = repartos;
    }

    public String getIdprotagonista() {
        return idprotagonista;
    }

    public void setIdprotagonista(String idprotagonista) {
        this.idprotagonista = idprotagonista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}