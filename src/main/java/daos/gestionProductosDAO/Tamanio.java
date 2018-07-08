package entities.gestionProductos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

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
        return idTam == tamanio.idTam &&
                Objects.equals(nombre, tamanio.nombre) &&
                Objects.equals(precio, tamanio.precio);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTam, nombre, precio);
    }
}
