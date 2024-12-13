package entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto extends Object {

	private long id; 
    private String nombre; 
    private BigDecimal precio_normal; 
    private BigDecimal precio_minimo;
    public Producto() {
    }
    public Producto(long id, String nombre, BigDecimal precio_normal, BigDecimal precio_minimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio_normal = precio_normal;
		this.precio_minimo = precio_minimo;
	}
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecio_normal(BigDecimal precio_normal) {
        this.precio_normal = precio_normal;
    }

    public BigDecimal getPrecio_normal() {
        return precio_normal;
    }

    public void setPrecio_minimo(BigDecimal precio_minimo) {
        this.precio_minimo = precio_minimo;
    }

    public BigDecimal getPrecio_minimo() {
        return precio_minimo;
    }
    
    @Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio_normal=" + precio_normal + ", precio_minimo="
				+ precio_minimo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio_minimo, precio_normal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return id == other.id && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio_minimo, other.precio_minimo)
				&& Objects.equals(precio_normal, other.precio_normal);
	}


    


    

}
