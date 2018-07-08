package entities.gestionMovimientosCaja;

import javax.persistence.*;
import java.util.Objects;

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
        return idTipoMovmiento == that.idTipoMovmiento &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTipoMovmiento, descripcion, nombre);
    }
}
