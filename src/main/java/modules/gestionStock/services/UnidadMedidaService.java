package modules.gestionStock.services;

import modules.gestionStock.controllers.UnidadMedidaController;
import modules.gestionStock.dbEntities.UnidadMedida;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/unidadMedida")
public class UnidadMedidaService {
    @Inject
    UnidadMedidaController unidadMedidaController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public UnidadMedida get(@PathParam("id") int id) {
        return unidadMedidaController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<UnidadMedida> getAll() {
        return unidadMedidaController.findAll();
    }

    @POST
    @Consumes("application/json")
    public void create(UnidadMedida um) {
        unidadMedidaController.create(um);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, UnidadMedida incoming) {
        unidadMedidaController.update(id, incoming);
    }


}