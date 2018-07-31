package modules.gestionUsuarios.services;

import com.google.gson.Gson;
import modules.gestionUsuarios.controllers.SesionController;
import modules.gestionUsuarios.modelEntities.SesionModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sesion")
public class SesionService {
    @Context
    HttpHeaders header;
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

    @POST
    public Response create() {
        //result puede ser
        // -1: hay sesion iniciada (no crea una nueva sesion)
        // 0: usuario o password no valido
        // 1: sesion creada exitosamente
        long result = sesionController.create(header);
        return Response.ok(result).build();
    }

    @DELETE
    public Response remove() {
        if (sesionController.remove()) return Response.accepted().build();
        return Response.notModified().build();

    }
}
