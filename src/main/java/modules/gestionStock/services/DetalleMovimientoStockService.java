package modules.gestionStock.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modules.gestionStock.ModelEntities.DetalleMovimientoStockModel;
import modules.gestionStock.controllers.DetalleMovimientoStockController;


import javax.inject.Inject;
import javax.ws.rs.*;
import java.lang.reflect.Type;
import java.util.List;

@Path("/detalleMovimientoStock")
public class DetalleMovimientoStockService {
    @Inject
    DetalleMovimientoStockController detalleMovimientoStockController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") long idMovimiento) {
        List<DetalleMovimientoStockModel> detalles = detalleMovimientoStockController.findAll(idMovimiento);
        Gson gson = new Gson();
        String json = gson.toJson(detalles);
        return json;
    }


    //Muestra todos los detalles que pertenezcan a un movimiento que no fue anulado
    @GET
    @Produces("application/json")
    public String get() {
        List<DetalleMovimientoStockModel> detalles = detalleMovimientoStockController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(detalles);
        return json;
    }


    @POST
    @Path("/movimiento/{id}")
    @Consumes("application/json")
    public void create(String json, @PathParam("id") long idMovimiento) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<DetalleMovimientoStockModel>>() {}.getType();
        List<DetalleMovimientoStockModel> detalles  = gson.fromJson(json, type);
        detalleMovimientoStockController.create(detalles,idMovimiento);
    }
}
