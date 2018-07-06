package entities.gestionStock.services;

import entities.gestionStock.Insumo;

import javax.ws.rs.*;

@Path("/unidadMedida")
public class UnidadMedidaService {
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public void get(@PathParam("id") int id) {

    }

    @GET
    @Produces("application/json")
    public void getAll() {

    }

    @POST
    @Consumes("application/json")
    public void create() {

    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") int id, Insumo incoming) {

    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id) {

    }

}