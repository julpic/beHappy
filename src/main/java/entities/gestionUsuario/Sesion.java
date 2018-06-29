package entities.gestionUsuario;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Sesiones", schema = "BeFruit", catalog = "")
public class Sesion {
    private int idSesion;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFin;

    @Id
    @Column(name = "idSesion")
    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
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

        Sesion sesion = (Sesion) o;

        if (idSesion != sesion.idSesion) return false;
        if (fechaHoraInicio != null ? !fechaHoraInicio.equals(sesion.fechaHoraInicio) : sesion.fechaHoraInicio != null)
            return false;
        if (fechaHoraFin != null ? !fechaHoraFin.equals(sesion.fechaHoraFin) : sesion.fechaHoraFin != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSesion;
        result = 31 * result + (fechaHoraInicio != null ? fechaHoraInicio.hashCode() : 0);
        result = 31 * result + (fechaHoraFin != null ? fechaHoraFin.hashCode() : 0);
        return result;
    }
}
