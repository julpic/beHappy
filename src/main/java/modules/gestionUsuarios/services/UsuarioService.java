package modules.gestionUsuarios.services;

import com.google.gson.Gson;
import modules.gestionUsuarios.controllers.UsuarioController;
import modules.gestionUsuarios.modelEntities.UsuarioModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/usuario")
public class UsuarioService {
    @Inject
    UsuarioController usuarioController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") long id) {
        UsuarioModel u = usuarioController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(u);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<UsuarioModel> perfiles = usuarioController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(perfiles);
        return json;
    }

    @GET
    @Path("/nombre/{nom}")
    @Produces("application/json")
    public String getAll(@PathParam("nom") String nombre) {
        UsuarioModel perfiles = usuarioController.find(nombre);
        Gson gson = new Gson();
        String json = gson.toJson(perfiles);
        return json;
    }

    @POST
    @Consumes("application/json")
    public void create(String json) {
        Gson gson = new Gson();
        UsuarioModel e = gson.fromJson(json,UsuarioModel.class);
        usuarioController.create(e);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") long id, String json) {
        Gson gson = new Gson();
        UsuarioModel e = gson.fromJson(json,UsuarioModel.class);
        usuarioController.update(id, e);
    }
}
/*
Password usuarios:
User: diego 
Password: diego

User: micka
Password: micka

User: juan
Password: juan
 */
