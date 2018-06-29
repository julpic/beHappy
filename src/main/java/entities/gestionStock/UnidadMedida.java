package entities.gestionStock;

import javax.persistence.*;

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

        if (idUnidad != that.idUnidad) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUnidad;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
