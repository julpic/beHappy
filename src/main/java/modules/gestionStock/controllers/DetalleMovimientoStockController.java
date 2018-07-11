package modules.gestionStock.controllers;

import modules.gestionStock.dbEntities.DetalleMovimientoStock;
import modules.gestionStock.dbEntities.MovimientoStock;
import modules.gestionStock.ejb.DetalleMovimientoStockEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DetalleMovimientoStockController {
    @Inject
    DetalleMovimientoStockEJB detalleMovimientoStockEJB;
    @Inject
    InsumoController insumoController;
    @Inject
    MovimientoStockController movimientoStockController;

    public List<DetalleMovimientoStock> findAll(int idMovimiento){
        return detalleMovimientoStockEJB.findAll(idMovimiento);
    }

    public void create(List<DetalleMovimientoStock> detalles) {
        int idInsumo;
        int cantidad;
        MovimientoStock x = movimientoStockController.find(detalles.get(0).getIdMovimiento());
        for (DetalleMovimientoStock det : detalles) {
            idInsumo = det.getIdInsumo();
            cantidad = det.getCantidad();
            insumoController.updateStock(idInsumo, cantidad, x.isEntrada());
        }
        detalleMovimientoStockEJB.createAll(detalles);
    }

    public void removeAll(List<DetalleMovimientoStock> detalles) {
        for (DetalleMovimientoStock det : detalles) {
            remove(det);
        }
    }

    public void remove(DetalleMovimientoStock det) {
        int idInsumo = det.getIdInsumo();
        int cantidad = det.getCantidad();
        insumoController.updateStock(idInsumo, cantidad, true);
    }

}
