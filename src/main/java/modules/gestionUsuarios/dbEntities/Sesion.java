package modules.gestionUsuarios.dbEntities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Sesiones", schema = "BeFruit")
public class Sesion {
    private int idSesion;
    private int idUsuario;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFin;

    @Id
    @Column(name = "idSesion")
    public int getIdSesion() { return idSesion; }

    public void setIdSesion(int idSesion) { this.idSesion = idSesion; }

    @Basic
    @Column(name = "idUsuario")
    public int getIdUsuario() { return idUsuario; }

    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

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
        Sesion sesion = (Sesion) o;
        return idSesion == sesion.idSesion &&
                idUsuario == sesion.idUsuario &&
                Objects.equals(fechaHoraInicio, sesion.fechaHoraInicio) &&
                Objects.equals(fechaHoraFin, sesion.fechaHoraFin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSesion, idUsuario, fechaHoraInicio, fechaHoraFin);
    }
}
