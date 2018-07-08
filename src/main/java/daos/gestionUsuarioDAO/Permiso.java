package entities.gestionUsuario;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Permisos", schema = "BeFruit", catalog = "")
public class Permiso {
    private int idPermiso;
    private String nombre;
    private String descripcion;

    @Id
    @Column(name = "idPermiso")
    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permiso permiso = (Permiso) o;
        return idPermiso == permiso.idPermiso &&
                Objects.equals(nombre, permiso.nombre) &&
                Objects.equals(descripcion, permiso.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPermiso, nombre, descripcion);
    }
}
