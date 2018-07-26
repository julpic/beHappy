package modules;

import javax.ejb.Stateless;
import javax.ws.rs.core.HttpHeaders;
import java.util.Date;

@Stateless
public class Testeandos {
    public String getHeader(HttpHeaders headers) {
        return headers.getRequestHeader("Authorization").get(0);
        //getRequestHeader("Authorization").get(0)
    }
}
