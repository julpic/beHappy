package modules.gestionStock.dbEntities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MovimientosStock", schema = "BeFruit")
public class MovimientoStock {
    private long idMovimientoStock;
    private Long idVenta;
    private Long idTurno;
    private Timestamp fechaHora;
    private Timestamp fechaHoraAnulacion;
    private boolean entrada;

    public MovimientoStock() {
    }

    @Id
    @Column(name = "idMovimientoStock")
    public long getIdMovimientoStock() {
        return idMovimientoStock;
    }

    public void setIdMovimientoStock(long idMovimientoStock) {
        this.idMovimientoStock = idMovimientoStock;
    }

    @Basic
    @Column(name = "idVenta")
    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    @Basic
    @Column(name = "fechaHora")
    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Basic
    @Column(name = "idTurno")
    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    @Basic
    @Column(name = "fechaHoraAnulacion")
    public Timestamp getFechaHoraAnulacion() {
        return fechaHoraAnulacion;
    }

    public void setFechaHoraAnulacion(Timestamp fechaHoraAnulacion) {
        this.fechaHoraAnulacion = fechaHoraAnulacion;
    }

    @Basic
    @Column(name = "entrada")
    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimientoStock that = (MovimientoStock) o;
        return idMovimientoStock == that.idMovimientoStock &&
                Objects.equals(idVenta, that.idVenta) &&
                Objects.equals(fechaHora, that.fechaHora);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMovimientoStock, idVenta, fechaHora);
    }

}
