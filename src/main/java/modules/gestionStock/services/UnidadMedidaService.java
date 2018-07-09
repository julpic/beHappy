package modules.gestionStock.services;

import modules.gestionStock.controllers.UnidadMedidaController;
import modules.gestionStock.modelEntities.UnidadMedida;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/unidadMedida")
public class UnidadMedidaService {
    @Inject
    UnidadMedidaController umController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public UnidadMedida get(@PathParam("id") int id) {
        return umController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<UnidadMedida> getAll() {
        return umController.findAll();
    }

    @POST
    @Consumes("application/json")
    public void create(UnidadMedida um) {
        umController.create(um);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, UnidadMedida incoming) {
        umController.update(id,incoming);
    }


}