package modules.gestionFranquicias.dbEntities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmpleadoPK implements Serializable{
    private long idEmpleado;
    private long idFranquicia;

    @Column(name = "idEmpleado")
    @Id
    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Column(name = "idFranquicia")
    @Id
    public long getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(long idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoPK that = (EmpleadoPK) o;
        return idEmpleado == that.idEmpleado &&
                idFranquicia == that.idFranquicia;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEmpleado, idFranquicia);
    }
}
