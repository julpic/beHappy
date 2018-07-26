package modules;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/test")
public class RestHello {
    @Inject
    Testeandos t;
    @Context
    HttpHeaders h;

    @GET
    @Path("/sayHello")
    public String doGet() {
        return "Hello World!";
    }

    @GET
    @Path("header")
    @Produces("application/json")
    public Response get() {
        return Response.ok(t.getHeader(h)).build();
    }
}
