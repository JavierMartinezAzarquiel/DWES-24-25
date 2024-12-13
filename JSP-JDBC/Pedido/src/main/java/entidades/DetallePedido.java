package entidades;

import java.math.BigDecimal;

public class DetallePedido {
    private long idpedido; 
    private int lineadetalle; 
    private long idproducto;
    private String descripcion;
    private int cantidad; 
    private BigDecimal precio_unitario; 
    private BigDecimal total_lineadetalle; 
    public DetallePedido() {
    }

    public void setIdpedido(long idpedido) {
        this.idpedido = idpedido;
    }

    public long getIdpedido() {
        return idpedido;
    }

    public void setLineadetalle(int lineadetalle) {
        this.lineadetalle = lineadetalle;
    }

    public int getLineadetalle() {
        return lineadetalle;
    }

    public void setIdproducto(long idproducto) {
        this.idproducto = idproducto;
    }

    public long getIdproducto() {
        return idproducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setTotal_lineadetalle(BigDecimal total_lineadetalle) {
        this.total_lineadetalle = total_lineadetalle;
    }

    public BigDecimal getTotal_lineadetalle() {
        return total_lineadetalle;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
