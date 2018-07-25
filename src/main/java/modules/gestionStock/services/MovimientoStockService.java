package modules.gestionStock.services;

import com.google.gson.Gson;
import modules.gestionStock.ModelEntities.MovimientoStockModel;
import modules.gestionStock.controllers.MovimientoStockController;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movimientoStock")
public class MovimientoStockService {
    @Inject
    MovimientoStockController movimientoStockController;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") long id) {
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
    public long create(String json) {
        Gson gson = new Gson();
        MovimientoStockModel ms = gson.fromJson(json, MovimientoStockModel.class);
        return movimientoStockController.create(ms);
    }


    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") long id) {
        movimientoStockController.remove(id);
    }
}

/*
{
    "idMovimientoStock":"0",
    "idVenta":"-1",
    "idTurno":"1-",
    "fechaHora":"2012-04-23T18:25:43.511Z",
    "entrada":"true",
    "detalles":[

    ]
}

 */
