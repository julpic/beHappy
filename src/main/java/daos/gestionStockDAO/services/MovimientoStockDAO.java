package daos.gestionStockDAO.services;

import entities.gestionStock.DetalleMovimientoStock;
import entities.gestionStock.MovimientoStock;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MovimientosStock", schema = "BeFruit", catalog = "")
public class MovimientoStockDAO {
    private int idMovimientoStock;
    private Integer idVenta;
    private Integer idTurno;
    private Timestamp fechaHora;
    private Timestamp fechaHoraAnulacion;
    private boolean entrada;

    public MovimientoStockDAO(MovimientoStock ms, int id) {
        this.idMovimientoStock = id;
        this.fechaHora = java.sql.Timestamp.valueOf(ms.getFechaHora().toString());
        this.fechaHoraAnulacion = java.sql.Timestamp.valueOf(ms.getFehcaHoraAnulacion().toString());
        this.entrada = ms.isEntrada();
    }

    @Id
    @Column(name = "idMovimientoStock")
    public int getIdMovimientoStock() {
        return idMovimientoStock;
    }

    public void setIdMovimientoStock(int idMovimientoStock) {
        this.idMovimientoStock = idMovimientoStock;
    }

    @Basic
    @Column(name = "idVenta")
    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
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
    public Integer getIdTurno() { return idTurno; }

    public void setIdTurno(Integer idTurno) { this.idTurno = idTurno; }

    @Basic
    @Column(name = "fechaHoraAnulacion")
    public Timestamp getFechaHoraAnulacion() { return fechaHoraAnulacion; }

    public void setFechaHoraAnulacion(Timestamp fechaHoraAnulacion) { this.fechaHoraAnulacion = fechaHoraAnulacion; }

    @Basic
    @Column(name = "entrada")
    public boolean isEntrada() { return entrada; }

    public void setEntrada(boolean entrada) { this.entrada = entrada; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimientoStockDAO that = (MovimientoStockDAO) o;
        return idMovimientoStock == that.idMovimientoStock &&
                Objects.equals(idVenta, that.idVenta) &&
                Objects.equals(fechaHora, that.fechaHora);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMovimientoStock, idVenta, fechaHora);
    }

    public MovimientoStock getMoviminetoStock(List<DetalleMovimientoStock> detalles){
        MovimientoStock ms = new MovimientoStock();
        ms.setIdMovimientoStock(this.idMovimientoStock);
        ms.setFechaHora(this.fechaHora);
        ms.setFehcaHoraAnulacion(this.fechaHoraAnulacion);
        ms.setEntrada(this.entrada);
        ms.setDetalles(detalles);

        return ms;
    }
}
