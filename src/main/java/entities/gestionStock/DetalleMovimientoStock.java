package entities.gestionStock;

import javax.persistence.*;

@Entity
@Table(name = "DetallesMovimientosStock", schema = "BeFruit", catalog = "")
@IdClass(DetalleMovimientoStockPK.class)
public class DetalleMovimientoStock {
    private int idDetalleMovimientoStock;
    private int idMovimiento;
    private int cantidad;
    private Insumo insumo;

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
    @Column(name = "cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {return insumo; }

    public void setInsumo(Insumo insumo) { this.insumo = insumo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleMovimientoStock that = (DetalleMovimientoStock) o;

        if (idDetalleMovimientoStock != that.idDetalleMovimientoStock) return false;
        if (idMovimiento != that.idMovimiento) return false;
        if (cantidad != that.cantidad) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalleMovimientoStock;
        result = 31 * result + idMovimiento;
        result = 31 * result + cantidad;
        return result;
    }
}
