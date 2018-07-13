package modules.gestionFranquicias.services;

import modules.gestionFranquicias.controllers.FranquiciaController;
import modules.gestionFranquicias.dbEntities.Franquicia;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/franquicia")
public class FranquiciaService {
    @Inject
    FranquiciaController franquiciaController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Franquicia get(@PathParam("id") int id) {
        return franquiciaController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<Franquicia> getAll() { return franquiciaController.findAll(); }

    @POST
    @Consumes("application/json")
    public void create(Franquicia f) {
        franquiciaController.create(f);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, Franquicia f) {
        franquiciaController.update(id, f);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        franquiciaController.remove(id);
    }
}
