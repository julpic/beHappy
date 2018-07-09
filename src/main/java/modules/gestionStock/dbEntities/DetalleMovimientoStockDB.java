package modules.gestionStock.dbEntities;

import modules.gestionStock.modelEntities.DetalleMovimientoStock;
import modules.gestionStock.modelEntities.Insumo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DetallesMovimientosStock", schema = "BeFruit")
@IdClass(DetalleMovimientoStockPK.class)
public class DetalleMovimientoStockDB {
    private int idDetalleMovimientoStock;
    private int idMovimiento;
    private int idInsumo;
    private int cantidad;

    public DetalleMovimientoStockDB() {
    }

    public DetalleMovimientoStockDB(DetalleMovimientoStock d, int id, int idMovimiento) {
        this.idDetalleMovimientoStock = id;
        this.idMovimiento = idMovimiento;
        this.idInsumo = d.getInsumo().getIdInsumo();
        this.cantidad = d.getCantidad();
    }

    @Id
    @Column(name = "idDetalleMovimientoStock")
    public int getIdDetalleMovimientoStock() {
        return idDetalleMovimientoStock;
    }

    public void setIdDetalleMovimientoStock(int idDetalleMovimientoStock) {
        this.idDetalleMovimientoStock = idDetalleMovimientoStock;
    }

    @Id
    @Column(name = "idMovimiento")
    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    @Basic
    @Column(name = "idInsumo")
    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
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
        DetalleMovimientoStockDB that = (DetalleMovimientoStockDB) o;
        return idDetalleMovimientoStock == that.idDetalleMovimientoStock &&
                idMovimiento == that.idMovimiento &&
                cantidad == that.cantidad;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDetalleMovimientoStock, idMovimiento, cantidad);
    }

    public DetalleMovimientoStock getDetalleMovimiento(Insumo i) {
        DetalleMovimientoStock dms = new DetalleMovimientoStock();
        dms.setIdDetalleMovimientoStock(this.idDetalleMovimientoStock);
        dms.setIdMovimiento(this.idMovimiento);
        dms.setInsumo(i);
        dms.setCantidad(this.cantidad);

        return dms;
    }
}
