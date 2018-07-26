package modules.gestionUsuarios.services;

import com.google.gson.Gson;
import modules.gestionUsuarios.controllers.SesionController;
import modules.gestionUsuarios.modelEntities.SesionModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sesion")
public class SesionService {
    @Inject
    SesionController sesionController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") long id) {
        SesionModel s = sesionController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(s);
        return json;
    }

    @GET
    @Path("/actual")
    @Produces("application/json")
    public String get() {
        SesionModel s = sesionController.sesionActual();
        Gson gson = new Gson();
        String json = gson.toJson(s);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<SesionModel> sesiones = sesionController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(sesiones);
        return json;
    }

    //Falta para iniciar la sesion, no se como pasar el httpHeader al metodo del controller

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") long id) {
        if (sesionController.remove()) return Response.accepted().build();
        return Response.notModified().build();

    }
}
