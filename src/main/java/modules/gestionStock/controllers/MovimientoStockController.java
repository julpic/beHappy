package modules.gestionStock.controllers;


import modules.gestionStock.ModelEntities.DetalleMovimientoStockModel;
import modules.gestionStock.ModelEntities.MovimientoStockModel;
import modules.gestionStock.dbEntities.DetalleMovimientoStock;
import modules.gestionStock.dbEntities.MovimientoStock;
import modules.gestionStock.ejb.MovimientoStockEJB;
import modules.gestionUsuarios.controllers.TurnoController;
import modules.gestionUsuarios.dbEntities.Turno;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class MovimientoStockController {
    @Inject
    MovimientoStockEJB movimientoStockEJB;
    @Inject
    DetalleMovimientoStockController detalleMovimientoStockController;
    @Inject
    TurnoController turnoController;

    public MovimientoStockModel find(long id) {
        MovimientoStock ms = movimientoStockEJB.find(id);
        List<DetalleMovimientoStockModel> detalles  = detalleMovimientoStockController.findAll(id);
        MovimientoStockModel msm = new MovimientoStockModel(ms);
        if(detalles != null){
            msm.setDetalles(detalles);
        }
        return msm;
    }

    public List<MovimientoStockModel> findAll() {
        List<MovimientoStock> movimientos = movimientoStockEJB.findAll();
        ArrayList<MovimientoStockModel> movimientosModel = new ArrayList<MovimientoStockModel>();
        for(MovimientoStock mov: movimientos){
            List<DetalleMovimientoStockModel> detalles  = detalleMovimientoStockController.findAll(mov.getIdMovimientoStock());
            MovimientoStockModel msm = new MovimientoStockModel(mov);
            if(detalles != null){
                msm.setDetalles(detalles);
            }
            movimientosModel.add(msm);
        }
        return movimientosModel;
    }

    public long create(MovimientoStockModel msm) {
        Turno t = turnoController.turnoIniciado();
        if (t != null) {
            Date date = new Date();
            msm.setIdTurno(t.getIdTurno());
            msm.setFechaHora(date);
            return movimientoStockEJB.create(msm.getDBEntity());
        }
        return -1;
    }

    public void remove(long id) {
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

    private void restoreStock(List<DetalleMovimientoStock> detalles, long idMovimiento) {
        for (DetalleMovimientoStock d : detalles) {
            detalleMovimientoStockController.restore(d, idMovimiento);
        }
    }
}
