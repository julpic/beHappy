package modules.gestionStock.services;

import com.google.gson.Gson;
import modules.gestionStock.ModelEntities.InsumoModel;
import modules.gestionStock.controllers.InsumoController;



import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/insumo")
public class InsumoService {
    @Inject
    InsumoController insumoController;

    @GET
    @Path("secured/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") int id) {
        InsumoModel im = insumoController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(im);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<InsumoModel> insumos = insumoController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(insumos);
        return json;
    }

    //Devuelve todos los insumos que cierto proveedor provee (valga la redundancia)
    @GET
    @Path("proveedor/{id}")
    @Produces("application/json")
    public String getAll(@PathParam("id") int idProveedor) {
        List<InsumoModel> insumos = insumoController.findAll(idProveedor);
        Gson gson = new Gson();
        String json = gson.toJson(insumos);
        return json;
    }

    @POST
    @Consumes("application/json")
    public void create(String json) {
        Gson gson = new Gson();
        InsumoModel i = gson.fromJson(json, InsumoModel.class);
        insumoController.create(i);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, String json) {
        Gson gson = new Gson();
        InsumoModel i = gson.fromJson(json, InsumoModel.class);
        insumoController.update(id, i);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        insumoController.remove(id);
    }

}
