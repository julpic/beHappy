package modules.gestionStock.services;

import modules.gestionStock.controllers.DetalleMovimientoStockController;
import modules.gestionStock.dbEntities.DetalleMovimientoStock;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/detalleMovimientoStock")
public class DetalleMovimientoStockService {
    @Inject
    DetalleMovimientoStockController detalleMovimientoStockController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public List<DetalleMovimientoStock> get(@PathParam("id") int idMovimiento) {
        return detalleMovimientoStockController.findAll(idMovimiento);
    }


    //Muestra todos los detalles que pertenezcan a un movimiento que no fue anulado
    @GET
    @Produces("application/json")
    public List<DetalleMovimientoStock> get() {
        return detalleMovimientoStockController.findAll();
    }


    @POST
    @Consumes("application/json")
    public void create(List<DetalleMovimientoStock> detalles) {
        detalleMovimientoStockController.create(detalles);
    }
}
