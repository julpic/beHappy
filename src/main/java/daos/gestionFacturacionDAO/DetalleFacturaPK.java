package entities.gestionFacturacion;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

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
        return idDetalleFactura == that.idDetalleFactura &&
                idTipoFactura == that.idTipoFactura &&
                idNumericoSucursal == that.idNumericoSucursal &&
                idNumericoFactura == that.idNumericoFactura;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDetalleFactura, idTipoFactura, idNumericoSucursal, idNumericoFactura);
    }
}
