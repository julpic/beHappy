package modules.gestionFranquicias.services;

import modules.gestionFranquicias.controllers.EmpleadoController;
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
    public EmpleadoModel get(@PathParam("id") int id) { return empleadoController.find(id); }

    @GET
    @Produces("application/json")
    public List<EmpleadoModel> getAll() { return empleadoController.findAll(); }

    @POST
    @Consumes("application/json")
    public void create(EmpleadoModel e) {
        empleadoController.create(e);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, EmpleadoModel e) {
        empleadoController.update(id, e);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        empleadoController.remove(id);
    }
}
