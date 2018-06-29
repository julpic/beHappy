package entities.gestionUsuario;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Turnos", schema = "BeFruit", catalog = "")
public class Turno {
    private int idTurno;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFin;

    @Id
    @Column(name = "idTurno")
    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    @Basic
    @Column(name = "fechaHoraInicio")
    public Timestamp getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Timestamp fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    @Basic
    @Column(name = "fechaHoraFin")
    public Timestamp getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Timestamp fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Turno turno = (Turno) o;

        if (idTurno != turno.idTurno) return false;
        if (fechaHoraInicio != null ? !fechaHoraInicio.equals(turno.fechaHoraInicio) : turno.fechaHoraInicio != null)
            return false;
        if (fechaHoraFin != null ? !fechaHoraFin.equals(turno.fechaHoraFin) : turno.fechaHoraFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTurno;
        result = 31 * result + (fechaHoraInicio != null ? fechaHoraInicio.hashCode() : 0);
        result = 31 * result + (fechaHoraFin != null ? fechaHoraFin.hashCode() : 0);
        return result;
    }
}
