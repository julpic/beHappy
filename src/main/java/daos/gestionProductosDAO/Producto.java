package entities.gestionProductos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Productos", schema = "BeFruit", catalog = "")
public class Producto {
    private int idProducto;
    private String nombre;

    @Id
    @Column(name = "idProducto")
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
        Producto producto = (Producto) o;
        return idProducto == producto.idProducto &&
                Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProducto, nombre);
    }
}
