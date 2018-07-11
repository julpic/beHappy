package modules.gestionStock.services;

import modules.gestionStock.controllers.InsumoController;
import modules.gestionStock.dbEntities.Insumo;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/insumo")
public class InsumoService {
    @Inject
    InsumoController insumoController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Insumo get(@PathParam("id") int id) {
        return insumoController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<Insumo> getAll() {
        return insumoController.findAll();
    }

    @POST
    @Consumes("application/json")
    public void create(Insumo i) {
        insumoController.create(i);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, Insumo i) {
        insumoController.update(id, i);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        insumoController.remove(id);
    }

}
