package modules.gestionStock.services;

import modules.gestionStock.controllers.MovimientoStockController;
import modules.gestionStock.modelEntities.MovimientoStock;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

public class MovimientoStockService {
    @Inject
    MovimientoStockController msController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public MovimientoStock get(@PathParam("id") int id) {
        return msController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<MovimientoStock> getAll() {
        return msController.findAll();
    }

    @POST
    @Consumes("application/json")
    public void create(MovimientoStock ms) {
        msController.create(ms);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, MovimientoStock incoming) {
        msController.update(id, incoming);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        msController.remove(id);
    }
}
