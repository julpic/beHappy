package entities.gestionMovimientosCaja;

import javax.persistence.*;

@Entity
@Table(name = "TiposMovmientos", schema = "BeFruit", catalog = "")
public class TipoMovmiento {
    private int idTipoMovmiento;
    private String descripcion;
    private String nombre;

    @Id
    @Column(name = "idTipoMovmiento")
    public int getIdTipoMovmiento() {
        return idTipoMovmiento;
    }

    public void setIdTipoMovmiento(int idTipoMovmiento) {
        this.idTipoMovmiento = idTipoMovmiento;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

        TipoMovmiento that = (TipoMovmiento) o;

        if (idTipoMovmiento != that.idTipoMovmiento) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTipoMovmiento;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
