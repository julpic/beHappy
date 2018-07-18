package modules.seguridad;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
    private static final String ADMIN_ROLE = "admin";
    private static final String OWNER_ROLE = "owner";


    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
        if (authHeader != null && authHeader.size() > 0) {
            String authToken = authHeader.get(0);
            authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
            String decodedString = new String(Base64.getDecoder().decode(authToken));
            StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
            String username = tokenizer.nextToken();
            String password = tokenizer.nextToken();
            //Buscar en base de datos el rol
            //La estructura condicional de abajo se ejecuta si y solo si existe el usuario
            if (containerRequestContext.getUriInfo().getPath().contains(ADMIN_ROLE) &&
                    true /*usuario tiene rol admin?*/) return;
            else if (containerRequestContext.getUriInfo().getPath().contains(OWNER_ROLE) &&
                    true /*usuario tiene rol admin or owner?*/) return;
            else {
                return; //si no requiere permisos especiales Y el usuario existe return;
            }
            //if (username.equals("user") && password.equals("pass")) return;
        }
/*        Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
                .entity("Not authorized.")
                .build();
        containerRequestContext.abortWith(unauthorizedStatus);*/
    }
}
