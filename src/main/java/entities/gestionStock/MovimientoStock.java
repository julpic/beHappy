package entities.gestionStock;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "MovimientosStock", schema = "BeFruit", catalog = "")
public class MovimientoStock {
    private int idMovimientoStock;
    private Integer idVenta;
    private Timestamp fechaHora;
    private Timestamp fechaHoraAnulacion;
    private boolean entrada;
    private List<DetalleMovimientoStock> detallesMovimiento;

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
    @Column(name = "fechaHoraAnulacion")
    public Timestamp getFechaHoraAnulacion() { return fechaHoraAnulacion; }

    public void setFechaHoraAnulacion(Timestamp fechaHoraAnulacion) {
        this.fechaHoraAnulacion = fechaHoraAnulacion;
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
    @Column(name = "entrada")
    public boolean getEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    public void addDetalle(DetalleMovimientoStock detalle){
        this.detallesMovimiento.add(detalle);
    }

    @SuppressWarnings("JpaAttributeTypeInspection")
    public List<DetalleMovimientoStock> getDetalles(){
        return this.detallesMovimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovimientoStock that = (MovimientoStock) o;

        if (idMovimientoStock != that.idMovimientoStock) return false;
        if (idVenta != null ? !idVenta.equals(that.idVenta) : that.idVenta != null) return false;
        if (fechaHora != null ? !fechaHora.equals(that.fechaHora) : that.fechaHora != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMovimientoStock;
        result = 31 * result + (idVenta != null ? idVenta.hashCode() : 0);
        result = 31 * result + (fechaHora != null ? fechaHora.hashCode() : 0);
        return result;
    }
}
