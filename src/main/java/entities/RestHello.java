package entities;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class RestHello {
    @GET
    public String doGet(){
        return "Hello World!";
    }
}
