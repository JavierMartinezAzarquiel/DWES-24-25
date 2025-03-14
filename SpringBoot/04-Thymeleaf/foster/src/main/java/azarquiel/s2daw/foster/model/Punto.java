package azarquiel.s2daw.foster.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "PUNTO")
public class Punto {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDPRODUCTO")
    private Producto idproducto;

    @Column(name = "PUNTOS")
    private Short puntos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Short getPuntos() {
        return puntos;
    }

    public void setPuntos(Short puntos) {
        this.puntos = puntos;
    }

}