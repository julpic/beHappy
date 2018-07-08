package entities.gestionMovimientosCaja;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MovmientosCaja", schema = "BeFruit", catalog = "")
public class MovmientoCaja {
    private int idMovmientoCaja;
    private Timestamp fechaHora;
    private BigInteger montoReal;
    private BigInteger montoSupesto;

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
    public BigInteger getMontoReal() {
        return montoReal;
    }

    public void setMontoReal(BigInteger montoReal) {
        this.montoReal = montoReal;
    }

    @Basic
    @Column(name = "montoSupesto")
    public BigInteger getMontoSupesto() {
        return montoSupesto;
    }

    public void setMontoSupesto(BigInteger montoSupesto) {
        this.montoSupesto = montoSupesto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovmientoCaja that = (MovmientoCaja) o;
        return idMovmientoCaja == that.idMovmientoCaja &&
                Objects.equals(fechaHora, that.fechaHora) &&
                Objects.equals(montoReal, that.montoReal) &&
                Objects.equals(montoSupesto, that.montoSupesto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMovmientoCaja, fechaHora, montoReal, montoSupesto);
    }
}
