package entities.gestionUsuario;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Usuarios", schema = "BeFruit", catalog = "")
public class Usuario {
    private int idUsuario;
    private String password;
    private String usuario;

    @Id
    @Column(name = "idUsuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return idUsuario == usuario1.idUsuario &&
                Objects.equals(password, usuario1.password) &&
                Objects.equals(usuario, usuario1.usuario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUsuario, password, usuario);
    }
}
