package entities.gestionStock;


import java.util.Objects;


public class Insumo {
    private int idInsumo;
    private String nombre;
    private int cantidadStock;
    private int stockMinimo;
    private UnidadMedida UnidadMedida;


    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public entities.gestionStock.UnidadMedida getUnidadMedida() {
        return UnidadMedida;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setUnidadMedida(entities.gestionStock.UnidadMedida unidadMedida) {
        UnidadMedida = unidadMedida;
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

    public void cancelarMovimiento(int cantidad, boolean entrada){
        if (entrada){
            this.cantidadStock =- cantidad;
        }else{
            this.cantidadStock =+ cantidad;
        }
    }

    public void registrarMovimiento(int cantidad, boolean entrada){
        if (entrada){
            this.cantidadStock =+ cantidad;
        }else{
            this.cantidadStock =- cantidad;
        }
    }
}
