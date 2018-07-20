package modules.gestionUsuarios.dbEntities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Perfiles", schema = "BeFruit")
public class Perfil {
    private long idPerfil;
    private String nombre;

    @Id
    @Column(name = "idPerfil")
    public long getIdPerfil() { return idPerfil; }

    public void setIdPerfil(long idPerfil) { this.idPerfil = idPerfil; }

    @Basic
    @Column(name = "nombre")
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

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
