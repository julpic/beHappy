package modules.gestionFranquicias.services;

import com.google.gson.Gson;
import modules.gestionFranquicias.controllers.EmpleadoController;
import modules.gestionFranquicias.dbEntities.Empleado;
import modules.gestionFranquicias.modelEntities.EmpleadoModel;


import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/empleado")
public class EmpleadoService {
    @Inject
    EmpleadoController empleadoController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") long id) {
        EmpleadoModel e = empleadoController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(e);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<EmpleadoModel> empleados = empleadoController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(empleados);
        return json;
    }

    @POST
    @Consumes("application/json")
    public void create(String json) {
        Gson gson = new Gson();
        EmpleadoModel e = gson.fromJson(json,EmpleadoModel.class);
        empleadoController.create(e);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") long id, String json) {
        Gson gson = new Gson();
        EmpleadoModel e = gson.fromJson(json,EmpleadoModel.class);
        empleadoController.update(id, e);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") long id) {
        empleadoController.remove(id);
    }
}
