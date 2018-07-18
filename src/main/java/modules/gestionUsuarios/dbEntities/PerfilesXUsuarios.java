package modules.gestionUsuarios.dbEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PerfilesXUsuarios", schema = "BeFruit")
public class PerfilesXUsuarios implements Serializable {
    private int idUsuario;
    private int idPerfil;


    @Id
    @Column(name = "idUsuario")
    public int getIdUsuario() { return idUsuario; }

    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    @Id
    @Column(name = "idPerfil")
    public int getIdPerfil() { return idPerfil; }

    public void setIdPerfil(int idPerfil) { this.idPerfil = idPerfil; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilesXUsuarios that = (PerfilesXUsuarios) o;
        return idUsuario == that.idUsuario &&
                idPerfil == that.idPerfil;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUsuario, idPerfil);
    }
}

