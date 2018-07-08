package entities.gestionFacturacion;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "DetallesFactura", schema = "BeFruit", catalog = "")
@IdClass(DetalleFacturaPK.class)
public class DetalleFactura {
    private int idDetalleFactura;
    private int idTipoFactura;
    private int idNumericoSucursal;
    private int idNumericoFactura;
    private int cantidad;
    private BigDecimal subtotal;

    @Id
    @Column(name = "idDetalleFactura")
    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    @Id
    @Column(name = "idTipoFactura")
    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    @Id
    @Column(name = "idNumericoSucursal")
    public int getIdNumericoSucursal() {
        return idNumericoSucursal;
    }

    public void setIdNumericoSucursal(int idNumericoSucursal) {
        this.idNumericoSucursal = idNumericoSucursal;
    }

    @Id
    @Column(name = "idNumericoFactura")
    public int getIdNumericoFactura() {
        return idNumericoFactura;
    }

    public void setIdNumericoFactura(int idNumericoFactura) {
        this.idNumericoFactura = idNumericoFactura;
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
        DetalleFactura that = (DetalleFactura) o;
        return idDetalleFactura == that.idDetalleFactura &&
                idTipoFactura == that.idTipoFactura &&
                idNumericoSucursal == that.idNumericoSucursal &&
                idNumericoFactura == that.idNumericoFactura &&
                cantidad == that.cantidad &&
                Objects.equals(subtotal, that.subtotal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDetalleFactura, idTipoFactura, idNumericoSucursal, idNumericoFactura, cantidad, subtotal);
    }
}
