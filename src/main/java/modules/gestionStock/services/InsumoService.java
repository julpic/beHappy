package modules.gestionStock.services;

import modules.gestionStock.modelEntities.Insumo;
import modules.gestionStock.controllers.InsumoController;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/insumo")
public class InsumoService {
    @Inject
    InsumoController iController;

    @GET
    @Path("/test")
    public void test() {
        System.out.println("Nice!");
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Insumo get(@PathParam("id") int id) {
        return iController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<Insumo> getAll() {
        return iController.findAll();
    }

    @POST
    @Consumes("application/json")
    public void create(Insumo i) {
        iController.create(i);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, Insumo i) {
        iController.update(id, i);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        iController.remove(id);
    }

}
