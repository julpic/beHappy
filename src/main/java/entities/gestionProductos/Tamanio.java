package entities.gestionProductos;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Tamanios", schema = "BeFruit", catalog = "")
public class Tamanio {
    private int idTam;
    private String nombre;
    private BigDecimal precio;

    @Id
    @Column(name = "idTam")
    public int getIdTam() {
        return idTam;
    }

    public void setIdTam(int idTam) {
        this.idTam = idTam;
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
    @Column(name = "precio")
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tamanio tamanio = (Tamanio) o;

        if (idTam != tamanio.idTam) return false;
        if (nombre != null ? !nombre.equals(tamanio.nombre) : tamanio.nombre != null) return false;
        if (precio != null ? !precio.equals(tamanio.precio) : tamanio.precio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTam;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        return result;
    }
}
