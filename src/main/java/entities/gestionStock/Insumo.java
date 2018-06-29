package entities.gestionStock;

import javax.persistence.*;

@Entity
@Table(name = "Insumos", schema = "BeFruit", catalog = "")
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

        if (idInsumo != insumo.idInsumo) return false;
        if (nombre != null ? !nombre.equals(insumo.nombre) : insumo.nombre != null) return false;
        if (cantidadStock != null ? !cantidadStock.equals(insumo.cantidadStock) : insumo.cantidadStock != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInsumo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (cantidadStock != null ? cantidadStock.hashCode() : 0);
        return result;
    }
}
