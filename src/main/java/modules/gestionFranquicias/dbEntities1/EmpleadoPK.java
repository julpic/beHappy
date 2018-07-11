package modules.gestionFranquicias.dbEntities1;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmpleadoPK implements Serializable{
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
        return idEmpleado == that.idEmpleado &&
                idFranquicia == that.idFranquicia;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEmpleado, idFranquicia);
    }
}
