package com.azarquiel.s2daw.ejemploJPA.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reparto", schema = "cinemania")
public class Reparto {
    @EmbeddedId
    private RepartoId id;

    @MapsId("idpelicula")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpelicula", nullable = false)
    private Pelicula idpelicula;

    @MapsId("idprotagonista")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idprotagonista", nullable = false)
    private Protagonista idprotagonista;

    @Column(name = "papel", length = 40)
    private String papel;

    public RepartoId getId() {
        return id;
    }

    public void setId(RepartoId id) {
        this.id = id;
    }

    public Pelicula getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Pelicula idpelicula) {
        this.idpelicula = idpelicula;
    }

    public Protagonista getIdprotagonista() {
        return idprotagonista;
    }

    public void setIdprotagonista(Protagonista idprotagonista) {
        this.idprotagonista = idprotagonista;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

}