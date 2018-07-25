package modules.gestionUsuarios.modelEntities;

import modules.gestionUsuarios.dbEntities.Perfil;
import java.util.List;

public class UsuarioModel {
    private long idUsuario;
    private long idEmpleado;
    private long idFranquicia;
    private String password;
    private String usuario;
    private List<Perfil> Perfiles;
}
