package modules.gestionStock.services;

import com.google.gson.Gson;
import modules.gestionStock.ModelEntities.MovimientoStockModel;
import modules.gestionStock.controllers.MovimientoStockController;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/movimientoStock")
public class MovimientoStockService {
    @Inject
    MovimientoStockController movimientoStockController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") int id) {
        MovimientoStockModel msm = movimientoStockController.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(msm);
        return json;
    }

    @GET
    @Produces("application/json")
    public String getAll() {
        List<MovimientoStockModel> movimientos = movimientoStockController.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(movimientos);
        return json;
    }

    @POST
    @Consumes("application/json")
    public void create(String json) {
        Gson gson = new Gson();
        MovimientoStockModel ms = gson.fromJson(json, MovimientoStockModel.class);
        movimientoStockController.create(ms);
    }


    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {
        movimientoStockController.remove(id);
    }
}
/*{
   "idMovimientoStock":"1",
   "idVenta":"null",
   "idTurno":"null",
   "fechaHora":"2018-07-11T17:01:00.000Z",
   "fechaHoraAnulacion":"null",
   "entrada":true
}*/