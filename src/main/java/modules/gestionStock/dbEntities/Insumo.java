package modules.gestionStock.dbEntities;

import javax.persistence.*;

@Entity
@Table(name = "Insumos", schema = "BeFruit")
public class Insumo {
    private long idInsumo;
    private String nombre;
    private int cantidadStock;
    private int stockMinimo;
    private long idUnidadMedida;
    private boolean alta;

    public Insumo() {
    }

    public void darDeBaja() {
        this.alta = false;
    }

    @Id
    @Column(name = "idInsumo")
    public long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(long idInsumo) {
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

    @Basic
    @Column(name = "stockMinimo")

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    @Basic
    @Column(name = "idUnidadMedida")
    public long getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(long idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    @Basic
    @Column(name = "alta")
    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

}
