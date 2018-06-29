package entities.gestionProductos;

import javax.persistence.*;

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

        if (idProducto != producto.idProducto) return false;
        if (nombre != null ? !nombre.equals(producto.nombre) : producto.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProducto;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
