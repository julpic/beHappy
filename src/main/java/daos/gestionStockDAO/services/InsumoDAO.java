package daos.gestionStockDAO.services;

import entities.gestionStock.Insumo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Insumos", schema = "BeFruit", catalog = "")
public class InsumoDAO {
    private int idInsumo;
    private String nombre;
    private int cantidadStock;
    private int stockMinimo;
    private int idUnidadMedida;
    private boolean alta;

    public InsumoDAO(Insumo i) {
        this.idInsumo = i.getIdInsumo();
        this.nombre = i.getNombre();
        this.cantidadStock = i.getCantidadStock();
        this.stockMinimo = i.getStockMinimo();
        this.idUnidadMedida = i.getUnidadMedida().getIdUnidad();
        this.alta = true;
    }

    public void darDeBaja(){
        this.alta = false;
    }

    @Id
    @Column(name = "idInsumo")
    public int getIdInsumo() { return idInsumo; }

    public void setIdInsumo(int idInsumo) { this.idInsumo = idInsumo; }

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

    public int getStockMinimo() { return stockMinimo; }

    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    @Basic
    @Column(name = "idUnidadMedida")
    public void setIdUnidadMedida(int idUnidadMedida) { this.idUnidadMedida = idUnidadMedida; }

    public int getIdUnidadMedida() { return idUnidadMedida; }


    @Basic
    @Column(name = "alta")
    public void setAlta(boolean alta) { this.alta = alta; }

    public boolean isAlta() { return alta; }

    public Insumo getInsumo(){
        Insumo i = new Insumo();
        i.setNombre(this.nombre);
        i.setCantidadStock(this.cantidadStock);
        i.setIdInsumo(this.idInsumo);
        i.setStockMinimo(this.stockMinimo);
        //i.setUnidadMedida(); Falta ver como buscar la unidad de medida, habria que pasarla por parametro

        return i;
    }
}
