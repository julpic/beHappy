package modules.gestionStock.controllers;


import modules.gestionStock.ModelEntities.DetalleMovimientoStockModel;
import modules.gestionStock.ModelEntities.MovimientoStockModel;
import modules.gestionStock.dbEntities.DetalleMovimientoStock;
import modules.gestionStock.dbEntities.MovimientoStock;
import modules.gestionStock.ejb.MovimientoStockEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MovimientoStockController {
    @Inject
    MovimientoStockEJB movimientoStockEJB;
    @Inject
    DetalleMovimientoStockController detalleMovimientoStockController;

    public MovimientoStockModel find(int id) {
        MovimientoStock ms = movimientoStockEJB.find(id);
        List<DetalleMovimientoStockModel> detalles  = detalleMovimientoStockController.findAll(id);
        MovimientoStockModel msm = new MovimientoStockModel(ms,detalles);
        return msm;
    }

    public List<MovimientoStockModel> findAll() {
        List<MovimientoStock> movimientos = movimientoStockEJB.findAll();
        ArrayList<MovimientoStockModel> movimientosModel = new ArrayList<MovimientoStockModel>();
        for(MovimientoStock mov: movimientos){
            List<DetalleMovimientoStockModel> detalles  = detalleMovimientoStockController.findAll(mov.getIdMovimientoStock());
            MovimientoStockModel msm = new MovimientoStockModel(mov,detalles);
            movimientosModel.add(msm);
        }
        return movimientosModel;
    }

    public void create(MovimientoStockModel msm) {
        movimientoStockEJB.create(msm.getDBEntity());
    }

    public void remove(int id) {
        MovimientoStockModel movModel = find(id);
        MovimientoStock actual = movModel.getDBEntity();
        List<DetalleMovimientoStockModel> detallesModel = detalleMovimientoStockController.findAll(id);
        ArrayList<DetalleMovimientoStock> detalles = new ArrayList<DetalleMovimientoStock>();

        for (DetalleMovimientoStockModel detModel : detallesModel) {
            DetalleMovimientoStock det = detModel.getDBEntity(id);
            detalles.add(det);
        }

        restoreStock(detalles, id);
        actual.setFechaHoraAnulacion(new Timestamp(System.currentTimeMillis()));
        movimientoStockEJB.cancel(id, actual);
    }

    private void restoreStock(List<DetalleMovimientoStock> detalles, int idMovimiento) {
        for (DetalleMovimientoStock d : detalles) {
            detalleMovimientoStockController.restore(d, idMovimiento);
        }
    }
}
