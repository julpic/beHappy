package modules.gestionUsuarios.modelEntities;

import modules.gestionUsuarios.dbEntities.Usuario;

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

    public void setPerfiles(List<PerfilModel> perfiles) {
        Perfiles = perfiles;
    }

    public List<PerfilModel> getPerfiles() {
        return Perfiles;
    }

    public Usuario getDBENtity(){
        Usuario u = new Usuario();

        u.setIdEmpleado(this.idEmpleado);
        u.setIdUsuario(this.idUsuario);
        u.setIdFranquicia(this.idFranquicia);
        u.setPassword(this.password);
        u.setUsuario(this.usuario);

        return u;
    }
}
