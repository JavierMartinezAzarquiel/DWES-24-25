package azarquiel.s2daw.foster.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "BODY", length = 1024)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CATEGORIAID")
    private Categoria categoriaid;

    @Column(name = "IMAGEN")
    private String imagen;

    @Column(name = "FONDO")
    private String fondo;

    @Column(name = "SUMARIO", length = 1024)
    private String sumario;

    @OneToMany(mappedBy = "idproducto")
    private List<Punto> puntos = new ArrayList<>();

    public List<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Punto> puntos) {
        this.puntos = puntos;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Categoria getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Categoria categoriaid) {
        this.categoriaid = categoriaid;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

}