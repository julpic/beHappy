package entities.gestionStock;

import daos.gestionStockDAO.services.DetalleMovimientoStockPK;

import javax.persistence.*;
import java.util.Objects;


public class DetalleMovimientoStock {
    private int idDetalleMovimientoStock;
    private int idMovimiento;
    private Insumo insumo;
    private int cantidad;


    //Getters y Setters
    public int getIdDetalleMovimientoStock() {
        return idDetalleMovimientoStock;
    }

    public void setIdDetalleMovimientoStock(int idDetalleMovimientoStock) { this.idDetalleMovimientoStock = idDetalleMovimientoStock; }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() { return insumo; }

    public void setInsumo(Insumo insumo) { this.insumo = insumo; }



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
