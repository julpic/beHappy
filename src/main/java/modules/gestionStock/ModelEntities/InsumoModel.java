package modules.gestionStock.ModelEntities;

import modules.gestionStock.dbEntities.Insumo;

public class InsumoModel {
    private long idInsumo;
    private String nombre;
    private int cantidadStock;
    private int stockMinimo;
    private UnidadMedidaModel unidadMedida;
    private boolean alta;

    public InsumoModel(Insumo i, UnidadMedidaModel um) {
        this.idInsumo = i.getIdInsumo();
        this.nombre = i.getNombre();
        this.cantidadStock = i.getCantidadStock();
        this.stockMinimo = i.getStockMinimo();
        this.unidadMedida = um;
        this.alta = i.isAlta();
    }

    public long getIdInsumo() {
        return idInsumo;
    }

    public Insumo getDBEntity(){
        Insumo i = new Insumo();
        i.setIdInsumo(this.idInsumo);
        i.setNombre(this.nombre);
        i.setCantidadStock(this.cantidadStock);
        i.setStockMinimo(this.stockMinimo);
        i.setIdUnidadMedida(this.unidadMedida.getIdUnidad());
        i.setAlta(this.alta);
        return i;
    }
}
