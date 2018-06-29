package entities.gestionUsuario;

import javax.persistence.*;

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

        if (idPermiso != permiso.idPermiso) return false;
        if (nombre != null ? !nombre.equals(permiso.nombre) : permiso.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(permiso.descripcion) : permiso.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPermiso;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }
}
