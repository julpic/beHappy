package entities.gestionFacturacion;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DetalleFacturaPK implements Serializable {
    private int idDetalleFactura;
    private int idTipoFactura;
    private int idNumericoSucursal;
    private int idNumericoFactura;

    @Column(name = "idDetalleFactura")
    @Id
    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    @Column(name = "idTipoFactura")
    @Id
    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    @Column(name = "idNumericoSucursal")
    @Id
    public int getIdNumericoSucursal() {
        return idNumericoSucursal;
    }

    public void setIdNumericoSucursal(int idNumericoSucursal) {
        this.idNumericoSucursal = idNumericoSucursal;
    }

    @Column(name = "idNumericoFactura")
    @Id
    public int getIdNumericoFactura() {
        return idNumericoFactura;
    }

    public void setIdNumericoFactura(int idNumericoFactura) {
        this.idNumericoFactura = idNumericoFactura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleFacturaPK that = (DetalleFacturaPK) o;

        if (idDetalleFactura != that.idDetalleFactura) return false;
        if (idTipoFactura != that.idTipoFactura) return false;
        if (idNumericoSucursal != that.idNumericoSucursal) return false;
        if (idNumericoFactura != that.idNumericoFactura) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalleFactura;
        result = 31 * result + idTipoFactura;
        result = 31 * result + idNumericoSucursal;
        result = 31 * result + idNumericoFactura;
        return result;
    }
}
