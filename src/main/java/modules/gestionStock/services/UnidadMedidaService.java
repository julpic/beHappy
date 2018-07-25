package modules.gestionStock.services;

import com.google.gson.Gson;
import modules.gestionStock.ModelEntities.UnidadMedidaModel;
import modules.gestionStock.controllers.UnidadMedidaController;
import modules.gestionStock.dbEntities.UnidadMedida;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/unidadMedida")
public class UnidadMedidaService {
    @Inject
    UnidadMedidaController unidadMedidaController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") long id) {
        UnidadMedidaModel umm = unidadMedidaController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(umm);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<UnidadMedidaModel> unidades = unidadMedidaController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(unidades);
        return json;
    }

    @POST
    @Consumes("application/json")
    public Response create(String json) {
        Gson gson = new Gson();
        UnidadMedidaModel um = gson.fromJson(json, UnidadMedidaModel.class);
        if ( unidadMedidaController.create(um)) return javax.ws.rs.core.Response.accepted().build();
        return javax.ws.rs.core.Response.notModified().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") long id, String json) {
        Gson gson = new Gson();
        UnidadMedidaModel um = gson.fromJson(json, UnidadMedidaModel.class);
        unidadMedidaController.update(id, um);

    }

}
/*
{
      "idUnidad": 1001,
      "nombre": "Paquetes"
    }
 */