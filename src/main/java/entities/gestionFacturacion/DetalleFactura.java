package entities.gestionFacturacion;

import javax.persistence.*;
import java.math.BigDecimal;

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

        if (idDetalleFactura != that.idDetalleFactura) return false;
        if (idTipoFactura != that.idTipoFactura) return false;
        if (idNumericoSucursal != that.idNumericoSucursal) return false;
        if (idNumericoFactura != that.idNumericoFactura) return false;
        if (cantidad != that.cantidad) return false;
        if (subtotal != null ? !subtotal.equals(that.subtotal) : that.subtotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalleFactura;
        result = 31 * result + idTipoFactura;
        result = 31 * result + idNumericoSucursal;
        result = 31 * result + idNumericoFactura;
        result = 31 * result + cantidad;
        result = 31 * result + (subtotal != null ? subtotal.hashCode() : 0);
        return result;
    }
}
