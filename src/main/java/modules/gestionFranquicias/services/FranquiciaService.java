package modules.gestionFranquicias.services;

import com.google.gson.Gson;
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
    public String get(@PathParam("id") int id) {
        FranquiciaModel f = franquiciaController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(f);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<FranquiciaModel> franquicias = franquiciaController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(franquicias);
        return  json;
    }

    @GET
    @Path("proveedor/{id}")
    @Produces("application/json")
    public String getAll(@PathParam("id") int idProveedor) {
        List<FranquiciaModel> franquicias = franquiciaController.findAll(idProveedor);
        Gson gson = new Gson();
        String json = gson.toJson(franquicias);
        return json;
    }

    @POST
    @Consumes("application/json")
    public void create(String json) {
        Gson gson = new Gson();
        FranquiciaModel f = gson.fromJson(json, FranquiciaModel.class);
        franquiciaController.create(f);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, String json) {
        Gson gson = new Gson();
        FranquiciaModel f = gson.fromJson(json, FranquiciaModel.class);
        franquiciaController.update(id, f);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        franquiciaController.remove(id);
    }
}
