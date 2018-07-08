package entities.gestionStock;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UnidadesMedida", schema = "BeFruit", catalog = "")
public class UnidadMedida {
    private int idUnidad;
    private String nombre;

    @Id
    @Column(name = "idUnidad")
    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
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
        UnidadMedida that = (UnidadMedida) o;
        return idUnidad == that.idUnidad &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUnidad, nombre);
    }
}
