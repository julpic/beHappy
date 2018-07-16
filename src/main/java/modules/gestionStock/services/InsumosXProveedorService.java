package modules.gestionStock.services;

import modules.gestionStock.ModelEntities.InsumoModel;
import modules.gestionStock.controllers.InsumoController;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/insumosXPorveedor")
public class InsumosXProveedorService {
    @Inject
    InsumoController insumoController;

    //Devuelve todos los insumos que cierto proveedor provee (valga la redundancia)
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public List<InsumoModel> getAll(@PathParam("id") int idProveedor) {
        return insumoController.findAll(idProveedor);
    }

}
