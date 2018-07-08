package entities.gestionVenta;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

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
        return idDetalle == that.idDetalle &&
                idVenta == that.idVenta &&
                cantidad == that.cantidad &&
                Objects.equals(subtotal, that.subtotal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDetalle, idVenta, cantidad, subtotal);
    }
}
