package modules.gestionStock.services;

import modules.gestionStock.ModelEntities.InsumoModel;
import modules.gestionStock.controllers.InsumoController;


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
    public InsumoModel get(@PathParam("id") int id) {
        return insumoController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<InsumoModel> getAll() {
        return insumoController.findAll();
    }

    @POST
    @Consumes("application/json")
    public void create(InsumoModel i) {
        insumoController.create(i);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, InsumoModel i) {
        insumoController.update(id, i);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        insumoController.remove(id);
    }

}
