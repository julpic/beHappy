package modules.gestionFranquicias.services;

import modules.gestionFranquicias.controllers.EmpleadoController;
import modules.gestionFranquicias.dbEntities1.Empleado;

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
    public Empleado get(@PathParam("id") int id) { return empleadoController.find(id); }

    @GET
    @Produces("application/json")
    public List<Empleado> getAll() { return empleadoController.findAll(); }

    @POST
    @Consumes("application/json")
    public void create(Empleado e) {
        empleadoController.create(e);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, Empleado e) {
        empleadoController.update(id, e);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        empleadoController.remove(id);
    }
}
