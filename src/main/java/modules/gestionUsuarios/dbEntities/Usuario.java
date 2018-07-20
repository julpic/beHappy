package modules.gestionUsuarios.dbEntities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Usuarios", schema = "BeFruit")
public class Usuario {
    private long idUsuario;
    private long idEmpleado;
    private long idFranquicia;
    private String password;
    private String usuario;


    @Id
    @Column(name = "idUsuario")
    public long getIdUsuario() { return idUsuario; }

    public void setIdUsuario(long idUsuario) { this.idUsuario = idUsuario; }

    @Basic
    @Column(name = "idEmpleado")
    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Basic
    @Column(name = "idFranquicia")
    public long getIdFranquicia() { return idFranquicia; }

    public void setIdFranquicia(int idFranquicia) { this.idFranquicia = idFranquicia; }

    @Basic
    @Column(name = "password")
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() { return usuario; }

    public void setUsuario(String usuario) { this.usuario = usuario; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return idUsuario == usuario1.idUsuario &&
                idEmpleado == usuario1.idEmpleado &&
                idFranquicia == usuario1.idFranquicia &&
                Objects.equals(password, usuario1.password) &&
                Objects.equals(usuario, usuario1.usuario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUsuario, idEmpleado, idFranquicia, password, usuario);
    }
}
