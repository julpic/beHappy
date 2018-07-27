package modules.seguridad;

import modules.gestionUsuarios.controllers.UsuarioController;
import modules.gestionUsuarios.modelEntities.UsuarioModel;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
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
    private static final String EMP_ROLE = "emploee";
    @Inject
    UsuarioController usuarioController;


    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
        if (authHeader != null && authHeader.size() > 0) {
            String authToken = authHeader.get(0);
            authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
            String decodedString = new String(Base64.getDecoder().decode(authToken));
            StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
            String username = tokenizer.nextToken();
            UsuarioModel u = usuarioController.find(username);
            if (u != null) {
                List<String> perfiles = u.getPerfilesString();
                //La estructura condicional de abajo se ejecuta si y solo si existe el usuario
                if (containerRequestContext.getUriInfo().getPath().contains(ADMIN_ROLE) &&
                        perfiles.contains(ADMIN_ROLE)) return;
                else if (containerRequestContext.getUriInfo().getPath().contains(OWNER_ROLE) &&
                        (perfiles.contains(ADMIN_ROLE) ||
                                perfiles.contains(OWNER_ROLE))) return;
                else if ((perfiles.contains(ADMIN_ROLE) ||
                                perfiles.contains(OWNER_ROLE) ||
                                perfiles.contains(EMP_ROLE))) return;
            }
        }
/*        Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
                .entity("Not authorized.")
                .build();
        containerRequestContext.abortWith(unauthorizedStatus);*/
    }
}
