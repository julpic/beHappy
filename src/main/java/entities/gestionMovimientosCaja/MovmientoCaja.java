package entities.gestionMovimientosCaja;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "MovmientosCaja", schema = "BeFruit", catalog = "")
public class MovmientoCaja {
    private int idMovmientoCaja;
    private Timestamp fechaHora;
    private BigDecimal montoReal;
    private BigDecimal montoSupesto;

    @Id
    @Column(name = "idMovmientoCaja")
    public int getIdMovmientoCaja() {
        return idMovmientoCaja;
    }

    public void setIdMovmientoCaja(int idMovmientoCaja) {
        this.idMovmientoCaja = idMovmientoCaja;
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
    @Column(name = "montoReal")
    public BigDecimal getMontoReal() {
        return montoReal;
    }

    public void setMontoReal(BigDecimal montoReal) {
        this.montoReal = montoReal;
    }

    @Basic
    @Column(name = "montoSupesto")
    public BigDecimal getMontoSupesto() {
        return montoSupesto;
    }

    public void setMontoSupesto(BigDecimal montoSupesto) {
        this.montoSupesto = montoSupesto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovmientoCaja that = (MovmientoCaja) o;

        if (idMovmientoCaja != that.idMovmientoCaja) return false;
        if (fechaHora != null ? !fechaHora.equals(that.fechaHora) : that.fechaHora != null) return false;
        if (montoReal != null ? !montoReal.equals(that.montoReal) : that.montoReal != null) return false;
        if (montoSupesto != null ? !montoSupesto.equals(that.montoSupesto) : that.montoSupesto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMovmientoCaja;
        result = 31 * result + (fechaHora != null ? fechaHora.hashCode() : 0);
        result = 31 * result + (montoReal != null ? montoReal.hashCode() : 0);
        result = 31 * result + (montoSupesto != null ? montoSupesto.hashCode() : 0);
        return result;
    }
}
