package modules.gestionStock.controllers;

import modules.gestionStock.ejb.StockEJB;
import modules.gestionStock.modelEntities.DetalleMovimientoStock;
import modules.gestionStock.modelEntities.Insumo;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class DetalleMovimientoStockController {

    public void create(List<DetalleMovimientoStock> detalles, int idMovimiento, boolean entrada){
        StockEJB rs = new StockEJB();
        for(DetalleMovimientoStock det : detalles){
            det.getInsumo().registrarMovimiento(det.getCantidad(), entrada);
        }
        rs.crearDetallesMovimientoStock(detalles, idMovimiento);
    }

    public void remove(DetalleMovimientoStock d, boolean entrada) {
            Insumo insumoACambiar = buscarInsumo(d);
            insumoACambiar.cancelarMovimiento(d.getCantidad(), entrada);
            InsumoController ic = new InsumoController();
            ic.update(insumoACambiar.getIdInsumo(), insumoACambiar);
    }

    private Insumo buscarInsumo(DetalleMovimientoStock detalle){
        int idInsumo = detalle.getInsumo().getIdInsumo();
        InsumoController ic = new InsumoController();
        return ic.find(idInsumo);
    }




}
