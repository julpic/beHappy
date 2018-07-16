package modules.gestionFranquicias.services;

import modules.gestionFranquicias.controllers.FranquiciaController;

import modules.gestionFranquicias.modelEntities.FranquiciaModel;

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
    public FranquiciaModel get(@PathParam("id") int id) {
        return franquiciaController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<FranquiciaModel> getAll() { return franquiciaController.findAll(); }

    @GET
    @Path("proveedor/{id}")
    @Produces("application/json")
    public List<FranquiciaModel> getAll(@PathParam("id") int idProveedor) { return franquiciaController.findAll(idProveedor); }

    @POST
    @Consumes("application/json")
    public void create(FranquiciaModel f) {
        franquiciaController.create(f);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, FranquiciaModel f) {
        franquiciaController.update(id, f);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        franquiciaController.remove(id);
    }
}
