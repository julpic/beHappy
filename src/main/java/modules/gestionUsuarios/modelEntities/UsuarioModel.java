package modules.gestionUsuarios.modelEntities;

import modules.gestionUsuarios.dbEntities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    private long idUsuario;
    private long idEmpleado;
    private long idFranquicia;
    private String password;
    private String usuario;
    private List<PerfilModel> Perfiles;


    public UsuarioModel(Usuario u) {
        this.idUsuario = u.getIdUsuario();
        this.idEmpleado = u.getIdEmpleado();
        this.idFranquicia = u.getIdFranquicia();
        this.password = u.getPassword();
        this.usuario = u.getUsuario();
    }

    public List<PerfilModel> getPerfiles() {
        return Perfiles;
    }

    public void setPerfiles(List<PerfilModel> perfiles) {
        Perfiles = perfiles;
    }

    public List<String> getPerfilesString() {
        List<String> perfiles = new ArrayList<>();
        for (PerfilModel p : Perfiles) {
            perfiles.add(p.getNombre());
        }
        return perfiles;
    }

    public Usuario getDBEntity() {
        Usuario u = new Usuario();

        u.setIdEmpleado(this.idEmpleado);
        u.setIdUsuario(this.idUsuario);
        u.setIdFranquicia(this.idFranquicia);
        u.setPassword(this.password);
        u.setUsuario(this.usuario);

        return u;
    }
}
