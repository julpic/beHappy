package entities.gestionUsuario;

import javax.persistence.*;
import java.util.Objects;

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
        return idPerfil == perfil.idPerfil &&
                Objects.equals(nombre, perfil.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPerfil, nombre);
    }
}
