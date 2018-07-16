package modules.gestionFranquicias.services;

import modules.gestionFranquicias.controllers.ProveedorController;
import modules.gestionFranquicias.modelEntities.ProveedorModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/insumosXPorveedor")
public class InsumosXProveedorService {
    @Inject
    ProveedorController proveedorController;

    //Si el parametro insumo es igual a true devuelve los proveedores que entregan dicho insumo
    //Si el parametro insumo es igual a false devuelve todos los proveedores de dicha franquicia
    @GET
    @Path("/{id}")
     @Produces("application/json")
     public List<ProveedorModel> getAll(@PathParam("id") int idInsumo, boolean insumo) {
        return proveedorController.findAll(idInsumo,insumo);
       }

    @POST
    @Consumes("application/json")
    public Response create(int idInsumo, int idProveedor) {
        if (proveedorController.create(idInsumo, idProveedor)) return Response.accepted().build();
        return Response.notModified().build();
    }
}
