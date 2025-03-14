package azarquiel.s2daw.foster.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION", length = 1024)
    private String descripcion;

    @Column(name = "GUARNICION", length = 1024)
    private String guarnicion;

    @OneToMany(mappedBy = "categoriaid")
    private List<Producto> productos = new ArrayList<>();

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGuarnicion() {
        return guarnicion;
    }

    public void setGuarnicion(String guarnicion) {
        this.guarnicion = guarnicion;
    }

}