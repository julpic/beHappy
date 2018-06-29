package entities.gestionUsuario;

import javax.persistence.*;

@Entity
@Table(name = "Perfiles", schema = "BeFruit", catalog = "")
public class Perfil {
    private int idPerfil;
    private String nombre;

    @Id
    @Column(name = "idPerfil")
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Perfil perfil = (Perfil) o;

        if (idPerfil != perfil.idPerfil) return false;
        if (nombre != null ? !nombre.equals(perfil.nombre) : perfil.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPerfil;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
