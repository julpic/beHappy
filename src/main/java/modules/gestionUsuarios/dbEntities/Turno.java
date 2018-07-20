package modules.gestionUsuarios.dbEntities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Turnos", schema = "BeFruit")
public class Turno {
    private long idTurno;
    private long idSesion;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFin;

    @Id
    @Column(name = "idTurno")
    public long getIdTurno() { return idTurno; }

    public void setIdTurno(long idTurno) { this.idTurno = idTurno; }

    @Basic
    @Column(name = "idSesion")
    public long getIdSesion() { return idSesion; }

    public void setIdSesion(long idSesion) { this.idSesion = idSesion; }

    @Basic
    @Column(name = "fechaHoraInicio")
    public Timestamp getFechaHoraInicio() { return fechaHoraInicio; }

    public void setFechaHoraInicio(Timestamp fechaHoraInicio) { this.fechaHoraInicio = fechaHoraInicio; }

    @Basic
    @Column(name = "fechaHoraFin")
    public Timestamp getFechaHoraFin() { return fechaHoraFin; }

    public void setFechaHoraFin(Timestamp fechaHoraFin) { this.fechaHoraFin = fechaHoraFin; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turno turno = (Turno) o;
        return idTurno == turno.idTurno &&
                idSesion == turno.idSesion &&
                Objects.equals(fechaHoraInicio, turno.fechaHoraInicio) &&
                Objects.equals(fechaHoraFin, turno.fechaHoraFin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTurno, idSesion, fechaHoraInicio, fechaHoraFin);
    }
}
