package modules.gestionUsuarios.services;

import com.google.gson.Gson;
import modules.gestionUsuarios.controllers.PerfilController;
import modules.gestionUsuarios.modelEntities.PerfilModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/perfil")
public class PerfilService {
    @Inject
    PerfilController perfilController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") long id) {
        PerfilModel p = perfilController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(p);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<PerfilModel> perfiles = perfilController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(perfiles);
        return json;
    }

    @GET
    @Path("/usuario/{id}")
    @Produces("application/json")
    public String getAll(@PathParam("id") long idUsuario) {
        List<PerfilModel> perfiles = perfilController.findAll(idUsuario);
        Gson gson = new Gson();
        String json = gson.toJson(perfiles);
        return json;
    }
    

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") long id, String json) {
        Gson gson = new Gson();
        PerfilModel e = gson.fromJson(json,PerfilModel.class);
        perfilController.update(id, e);
    }
    
}
