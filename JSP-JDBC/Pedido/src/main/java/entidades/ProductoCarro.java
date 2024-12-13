package entidades;

public class ProductoCarro extends Producto {
    private int cantidad;
    public ProductoCarro() {
      super();
    }
    public ProductoCarro(Producto p,int cantidad) {
    	super(p.getId(),p.getNombre(),p.getPrecio_normal(),p.getPrecio_minimo());
        this.cantidad=cantidad;
      }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

}
