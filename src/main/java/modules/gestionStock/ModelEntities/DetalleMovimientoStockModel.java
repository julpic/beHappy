package modules.gestionStock.ModelEntities;

import modules.gestionStock.dbEntities.DetalleMovimientoStock;

public class DetalleMovimientoStockModel {
    private long idDetalleMovimientoStock;
    private InsumoModel insumo;
    private int cantidad;

    public DetalleMovimientoStockModel(DetalleMovimientoStock det, InsumoModel i) {
        this.idDetalleMovimientoStock = det.getIdDetalleMovimientoStock();
        this. insumo = i;
        this.cantidad = det.getCantidad();
    }

    public DetalleMovimientoStock getDBEntity(long idMovimiento){
        DetalleMovimientoStock det = new DetalleMovimientoStock();
        det.setIdDetalleMovimientoStock(this.idDetalleMovimientoStock);
        det.setIdMovimiento(idMovimiento);
        det.setIdInsumo(this.insumo.getIdInsumo());
        det.setCantidad(this.cantidad);
        return det;
    }
}
