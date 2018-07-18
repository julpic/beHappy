package modules.gestionUsuarios.dbEntities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Turnos", schema = "BeFruit")
public class Turno {
    private int idTurno;
    private int idSesion;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFin;

    @Id
    @Column(name = "idTurno")
    public int getIdTurno() { return idTurno; }

    public void setIdTurno(int idTurno) { this.idTurno = idTurno; }

    @Basic
    @Column(name = "idSesion")
    public int getIdSesion() { return idSesion; }

    public void setIdSesion(int idSesion) { this.idSesion = idSesion; }

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
