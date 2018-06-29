package entities.gestionVenta;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DetallesVenta", schema = "BeFruit", catalog = "")
@IdClass(DetalleVentaPK.class)
public class DetalleVenta {
    private int idDetalle;
    private int idVenta;
    private int cantidad;
    private BigDecimal subtotal;

    @Id
    @Column(name = "idDetalle")
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    @Id
    @Column(name = "idVenta")
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    @Basic
    @Column(name = "cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "subtotal")
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleVenta that = (DetalleVenta) o;

        if (idDetalle != that.idDetalle) return false;
        if (idVenta != that.idVenta) return false;
        if (cantidad != that.cantidad) return false;
        if (subtotal != null ? !subtotal.equals(that.subtotal) : that.subtotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalle;
        result = 31 * result + idVenta;
        result = 31 * result + cantidad;
        result = 31 * result + (subtotal != null ? subtotal.hashCode() : 0);
        return result;
    }
}
