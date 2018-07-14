package modules.gestionFranquicias.services;

import modules.gestionFranquicias.controllers.ProveedorController;
import modules.gestionFranquicias.modelEntities.ProveedorModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/proveedor")
public class ProveedorService {
    @Inject
    ProveedorController proveedorController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public ProveedorModel get(@PathParam("id") int id) {
        return proveedorController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<ProveedorModel> getAll() {
        return proveedorController.findAll();
    }

    //Si el cuit es valido respuesta 202 Accepted
    //caso contrario 304 Not Modified
    @POST
    @Consumes("application/json")
    public Response create(ProveedorModel p) {
        if (proveedorController.create(p)) return Response.accepted().build();
        return Response.notModified().build();
    }

    //Si el cuit es valido respuesta 202 Accepted
    //caso contrario 304 Not Modified
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public Response update(@PathParam("id") int id, ProveedorModel p) {
        if (proveedorController.update(id, p)) return Response.accepted().build();
        return Response.notModified().build();
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        proveedorController.remove(id);
    }
}
