package modules.gestionStock.services;

import modules.gestionStock.controllers.DetalleMovimientoStockController;
import modules.gestionStock.modelEntities.DetalleMovimientoStock;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/detalleMovimientoStock")
public class DetalleMovimientoStockService {
    @Inject
    DetalleMovimientoStockController dmsController;


    @POST
    @Consumes("application/json")
    public void create(List<DetalleMovimientoStock> dms, int idMovimiento, boolean entrada) {
        dmsController.create(dms, idMovimiento, entrada);
    }
}
