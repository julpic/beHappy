package modules.gestionUsuarios.services;

import com.google.gson.Gson;
import modules.gestionUsuarios.controllers.TurnoController;
import modules.gestionUsuarios.modelEntities.TurnoModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/turno")
public class TurnoService {
    @Inject
    TurnoController turnoController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") long id) {
        TurnoModel t = turnoController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(t);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<TurnoModel> turnos = turnoController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(turnos);
        return json;
    }

    @GET
    @Path("/sesion/{id}")
    @Produces("application/json")
    public String getAll(@PathParam("id") long idSesion) {
        List<TurnoModel> turnos = turnoController.findAll(idSesion);
        Gson gson = new Gson();
        String json = gson.toJson(turnos);
        return json;
    }

    @POST
    public long create() {
        return turnoController.create();
    }

    @DELETE
    public Response remove() {
        if (turnoController.remove()) return Response.accepted().build();
        return Response.notModified().build();

    }
}
