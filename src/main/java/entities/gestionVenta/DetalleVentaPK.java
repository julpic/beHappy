package entities.gestionVenta;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DetalleVentaPK implements Serializable {
    private int idDetalle;
    private int idVenta;

    @Column(name = "idDetalle")
    @Id
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    @Column(name = "idVenta")
    @Id
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleVentaPK that = (DetalleVentaPK) o;
        return idDetalle == that.idDetalle &&
                idVenta == that.idVenta;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDetalle, idVenta);
    }
}
