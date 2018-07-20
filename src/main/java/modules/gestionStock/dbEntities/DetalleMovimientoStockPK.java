package modules.gestionStock.dbEntities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DetalleMovimientoStockPK implements Serializable {
    private long idDetalleMovimientoStock;
    private long idMovimiento;

    @Column(name = "idDetalleMovimientoStock")
    @Id
    public long getIdDetalleMovimientoStock() {
        return idDetalleMovimientoStock;
    }

    public void setIdDetalleMovimientoStock(long idDetalleMovimientoStock) {
        this.idDetalleMovimientoStock = idDetalleMovimientoStock;
    }

    @Column(name = "idMovimiento")
    @Id
    public long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleMovimientoStockPK that = (DetalleMovimientoStockPK) o;
        return idDetalleMovimientoStock == that.idDetalleMovimientoStock &&
                idMovimiento == that.idMovimiento;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDetalleMovimientoStock, idMovimiento);
    }
}
