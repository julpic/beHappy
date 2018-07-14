package modules.gestionStock.services;

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
    public MovimientoStockModel get(@PathParam("id") int id) {
        return movimientoStockController.find(id);
    }

    @GET
    @Produces("application/json")
    public List<MovimientoStockModel> getAll() {
        return movimientoStockController.findAll();
    }

    @POST
    @Consumes("application/json")
    public void create(MovimientoStockModel ms) {
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