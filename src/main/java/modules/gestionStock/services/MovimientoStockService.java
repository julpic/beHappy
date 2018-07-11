package modules.gestionStock.services;

import modules.gestionStock.controllers.MovimientoStockController;
import modules.gestionStock.dbEntities.MovimientoStock;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/movimientoStock")
public class MovimientoStockService {
    @Inject
    MovimientoStockController movimientoStockController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public MovimientoStock get(@PathParam("id") int id) {
        return movimientoStockController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<MovimientoStock> getAll() {
        return movimientoStockController.findAll();
    }

    @POST
    @Consumes("application/json")
    public void create(MovimientoStock ms) {
        movimientoStockController.create(ms);
    }


    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        movimientoStockController.remove(id);
    }
}
