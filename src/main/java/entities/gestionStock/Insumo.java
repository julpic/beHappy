package entities.gestionStock;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Insumos", schema = "BeFruit")
public class Insumo {
    private int idInsumo;
    private String nombre;
    private String cantidadStock;

    @Id
    @Column(name = "idInsumo")
    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
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
    @Column(name = "cantidadStock")
    public String getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(String cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumo insumo = (Insumo) o;
        return idInsumo == insumo.idInsumo &&
                Objects.equals(nombre, insumo.nombre) &&
                Objects.equals(cantidadStock, insumo.cantidadStock);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idInsumo, nombre, cantidadStock);
    }
}
