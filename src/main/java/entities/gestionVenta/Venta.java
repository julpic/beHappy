package entities.gestionVenta;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Ventas", schema = "BeFruit", catalog = "")
public class Venta {
    private int idVenta;
    private BigDecimal montoTotal;
    private Timestamp fechaHoraVenta;

    @Id
    @Column(name = "idVenta")
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    @Basic
    @Column(name = "montoTotal")
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Basic
    @Column(name = "fechaHoraVenta")
    public Timestamp getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(Timestamp fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venta venta = (Venta) o;

        if (idVenta != venta.idVenta) return false;
        if (montoTotal != null ? !montoTotal.equals(venta.montoTotal) : venta.montoTotal != null) return false;
        if (fechaHoraVenta != null ? !fechaHoraVenta.equals(venta.fechaHoraVenta) : venta.fechaHoraVenta != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVenta;
        result = 31 * result + (montoTotal != null ? montoTotal.hashCode() : 0);
        result = 31 * result + (fechaHoraVenta != null ? fechaHoraVenta.hashCode() : 0);
        return result;
    }
}
