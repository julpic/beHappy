package modules.gestionStock.dbEntities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DetallesMovimientosStock", schema = "BeFruit")
@IdClass(DetalleMovimientoStockPK.class)
public class DetalleMovimientoStock {
    private long idDetalleMovimientoStock;
    private long idMovimiento;
    private long idInsumo;
    private int cantidad;

    public DetalleMovimientoStock() {
    }

    @Id
    @Column(name = "idDetalleMovimientoStock")
    public long getIdDetalleMovimientoStock() {
        return idDetalleMovimientoStock;
    }

    public void setIdDetalleMovimientoStock(long idDetalleMovimientoStock) {
        this.idDetalleMovimientoStock = idDetalleMovimientoStock;
    }

    @Id
    @Column(name = "idMovimiento")
    public long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    @Basic
    @Column(name = "idInsumo")
    public long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(long idInsumo) {
        this.idInsumo = idInsumo;
    }

    @Basic
    @Column(name = "cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleMovimientoStock that = (DetalleMovimientoStock) o;
        return idDetalleMovimientoStock == that.idDetalleMovimientoStock &&
                idMovimiento == that.idMovimiento &&
                cantidad == that.cantidad;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDetalleMovimientoStock, idMovimiento, cantidad);
    }

}
