package entities.gestionVenta;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

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
        return idVenta == venta.idVenta &&
                Objects.equals(montoTotal, venta.montoTotal) &&
                Objects.equals(fechaHoraVenta, venta.fechaHoraVenta);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idVenta, montoTotal, fechaHoraVenta);
    }
}
