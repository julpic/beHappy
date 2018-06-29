package entities.gestionStock;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DetalleMovimientoStockPK implements Serializable {
    private int idDetalleMovimientoStock;
    private int idMovimiento;

    @Column(name = "idDetalleMovimientoStock")
    @Id
    public int getIdDetalleMovimientoStock() {
        return idDetalleMovimientoStock;
    }

    public void setIdDetalleMovimientoStock(int idDetalleMovimientoStock) {
        this.idDetalleMovimientoStock = idDetalleMovimientoStock;
    }

    @Column(name = "idMovimiento")
    @Id
    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleMovimientoStockPK that = (DetalleMovimientoStockPK) o;

        if (idDetalleMovimientoStock != that.idDetalleMovimientoStock) return false;
        if (idMovimiento != that.idMovimiento) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalleMovimientoStock;
        result = 31 * result + idMovimiento;
        return result;
    }
}
