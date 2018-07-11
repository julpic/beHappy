package modules.gestionStock.controllers;


import modules.gestionStock.dbEntities.DetalleMovimientoStock;
import modules.gestionStock.dbEntities.MovimientoStock;
import modules.gestionStock.ejb.MovimientoStockEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Stateless
public class MovimientoStockController {
    @Inject
    MovimientoStockEJB movimientoStockEJB;
    @Inject
    DetalleMovimientoStockController detalleMovimientoStockController;

    public MovimientoStock find(int id) {
        return movimientoStockEJB.find(id);
    }

    public List<MovimientoStock> findAll() {
        return movimientoStockEJB.findAll();
    }

    public void create(MovimientoStock ms) {
        movimientoStockEJB.create(ms);
    }

    public void remove(int id) {
        MovimientoStock actual = find(id);
        List<DetalleMovimientoStock> detalles = detalleMovimientoStockController.findAll(id);

        restoreStock(detalles);
        actual.setFechaHoraAnulacion(new Timestamp(System.currentTimeMillis()));

        movimientoStockEJB.cancel(id, actual);
    }

    private void restoreStock(List<DetalleMovimientoStock> detalles) {
        for (DetalleMovimientoStock d : detalles) {
            detalleMovimientoStockController.remove(d);
        }
    }
}
