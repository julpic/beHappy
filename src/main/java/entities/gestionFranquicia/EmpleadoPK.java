package entities.gestionFranquicia;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EmpleadoPK implements Serializable {
    private int idEmpleado;
    private int idFranquicia;

    @Column(name = "idEmpleado")
    @Id
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Column(name = "idFranquicia")
    @Id
    public int getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(int idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadoPK that = (EmpleadoPK) o;

        if (idEmpleado != that.idEmpleado) return false;
        if (idFranquicia != that.idFranquicia) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpleado;
        result = 31 * result + idFranquicia;
        return result;
    }
}
