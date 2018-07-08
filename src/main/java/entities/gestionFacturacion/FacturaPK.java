package entities.gestionFacturacion;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FacturaPK implements Serializable {
    private int idTipoFactura;
    private int idNumericoSucursal;
    private int idNumericoFactura;

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
        FacturaPK facturaPK = (FacturaPK) o;
        return idTipoFactura == facturaPK.idTipoFactura &&
                idNumericoSucursal == facturaPK.idNumericoSucursal &&
                idNumericoFactura == facturaPK.idNumericoFactura;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTipoFactura, idNumericoSucursal, idNumericoFactura);
    }
}
