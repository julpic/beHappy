package modules.gestionFranquicias.services;

import com.google.gson.Gson;
import modules.gestionFranquicias.controllers.ProveedorController;
import modules.gestionFranquicias.dbEntities.Proveedor;
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
    public String get(@PathParam("id") long id) {
        ProveedorModel p = proveedorController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(p);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<ProveedorModel> proveedores = proveedorController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(proveedores);
        return json;
    }

    //Si el parametro insumo es igual a true devuelve los proveedores que entregan dicho insumo
    //Si el parametro insumo es igual a false devuelve todos los proveedores de dicha franquicia
    @GET
    @Path("compuesto/{id}")
    @Produces("application/json")
    public String getAll(@PathParam("id") long idInsumo, boolean insumo) {
        List<ProveedorModel> proveedores = proveedorController.findAll(idInsumo,insumo);
        Gson gson = new Gson();
        String json = gson.toJson(proveedores);
        return json;
    }

    //Si el cuit es valido respuesta 202 Accepted
    //caso contrario 304 Not Modified
    @POST
    @Consumes("application/json")
    public Response create(String json) {
        Gson gson = new Gson();
        ProveedorModel p = gson.fromJson(json, ProveedorModel.class);
        if (proveedorController.create(p)) return Response.accepted().build();
        return Response.notModified().build();
    }

    @POST
    @Path("/insumo")
    @Consumes("application/json")
    public Response create(long idInsumo, long idProveedor) {
        if (proveedorController.create(idInsumo, idProveedor)) return Response.accepted().build();
        return Response.notModified().build();
    }

    //Si el cuit es valido respuesta 202 Accepted
    //caso contrario 304 Not Modified
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public Response update(@PathParam("id") long id, String json) {
        Gson gson = new Gson();
        ProveedorModel p = gson.fromJson(json, ProveedorModel.class);
        if (proveedorController.update(id, p)) return Response.accepted().build();
        return Response.notModified().build();
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") long id) {
        proveedorController.remove(id);
    }
}
/*
{
    "idProveedor":0,
    "cuit":"27-93720820-6",
    "razonSocial":"Crespo inc.",
    "eMail":"mickaelacrespo@gmail.com",
    "telefonoContacto":"155100391",
    "alta":"true"
}
 */