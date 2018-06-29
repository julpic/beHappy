package entities.gestionUsuario;

import javax.persistence.*;

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

        if (idUsuario != usuario1.idUsuario) return false;
        if (password != null ? !password.equals(usuario1.password) : usuario1.password != null) return false;
        if (usuario != null ? !usuario.equals(usuario1.usuario) : usuario1.usuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsuario;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        return result;
    }
}
