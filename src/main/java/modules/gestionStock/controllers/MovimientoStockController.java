package modules.gestionStock.controllers;


import modules.gestionStock.ejb.StockEJB;
import modules.gestionStock.modelEntities.DetalleMovimientoStock;
import modules.gestionStock.modelEntities.MovimientoStock;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class MovimientoStockController {
    StockEJB rms = new StockEJB();


    public MovimientoStock find(int id) {
       return rms.buscarMovimientoStock(id);
    }

    public List<MovimientoStock> findAll() {
        return rms.buscarMovimientosStock();
    }

    public int create(MovimientoStock ms) {
        return rms.crearMovimientoStock(ms);
    }

    public void remove(int id) {
        MovimientoStock actual = find(id);
        boolean entrada = actual.isEntrada();
        List<DetalleMovimientoStock> detalles = actual.getDetalles();

        revertirDetalles(detalles, entrada);
        actual.anular();
    }

    private void revertirDetalles(List<DetalleMovimientoStock> detalles, boolean entrada) {
        DetalleMovimientoStockController detalleController = new DetalleMovimientoStockController();
        for (DetalleMovimientoStock d : detalles) {
            detalleController.remove(d, entrada);
        }
    }
}
