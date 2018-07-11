package modules.gestionStock.services;

import modules.gestionStock.controllers.DetalleMovimientoStockController;
import modules.gestionStock.dbEntities.DetalleMovimientoStock;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/detalleMovimientoStock")
public class DetalleMovimientoStockService {
    @Inject
    DetalleMovimientoStockController detalleMovimientoStockController;


    @POST
    @Consumes("application/json")
    public void create(List<DetalleMovimientoStock> detalles) {
        detalleMovimientoStockController.create(detalles);
    }
}
