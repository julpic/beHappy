package entities.gestionStock;

import javax.persistence.*;

@Entity
@Table(name = "Insumos", schema = "BeFruit", catalog = "")
public class Insumo {
    private int idInsumo;
    private String nombre;
    private int cantidadStock;

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
    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Insumo insumo = (Insumo) o;

        if (idInsumo != insumo.idInsumo) return false;
        if (nombre != null ? !nombre.equals(insumo.nombre) : insumo.nombre != null) return false;
        if (cantidadStock !=  insumo.cantidadStock)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInsumo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (cantidadStock);
        return result;
    }


    /**
     * Deshace lo realizado por el movimiento una vez que el movimiento es cancelado.
     * Si el movimiento era de entrada de stock entonces se resta la cantidad agregada.
     * Si el movimiento era de slaida entonces se suma la canridad restada anteriormente.
     * argument is a specifier that is relative to the url argument.
     *
     * @param  cantidad Cantidad agregada o sustraida en el movimiento
     * @param  esEntrada si es true entonces el movimiento cancelado era de entrada, si es false el movimiento cancelado era de salida
     */
    public void cancelarMovimiento(int cantidad, boolean esEntrada){
        if (esEntrada == true){
            this.cantidadStock -= cantidad;
        }else{
            this.cantidadStock -= cantidad;
        }
    }
}
