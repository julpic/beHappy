package modules.gestionUsuarios.controllers;

import modules.gestionFranquicias.dbEntities.Empleado;
import modules.gestionUsuarios.dbEntities.Usuario;
import modules.gestionUsuarios.ejb.PerfilEJB;
import modules.gestionUsuarios.ejb.UsuarioEJB;
import modules.gestionUsuarios.modelEntities.PerfilModel;
import modules.gestionUsuarios.modelEntities.UsuarioModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UsuarioController {
    @Inject
    UsuarioEJB usuarioEJB;
    @Inject
    PerfilController perfilController;

    public UsuarioModel find(long id) {
        Usuario u = usuarioEJB.find(id);
        UsuarioModel um = new UsuarioModel(u);
        um.setPerfiles(perfilController.findAll(id));
        return um;
    }

    public UsuarioModel find(Empleado e) {
        Usuario u = usuarioEJB.find(e);
        UsuarioModel um = new UsuarioModel(u);
        um.setPerfiles(perfilController.findAll(u.getIdUsuario()));
        return um;
    }

    public UsuarioModel find(String nombre) {
        Usuario u = usuarioEJB.find(nombre);
        UsuarioModel um = new UsuarioModel(u);
        um.setPerfiles(perfilController.findAll(u.getIdUsuario()));
        return um;
    }

    public List<UsuarioModel> findAll() {
        List<Usuario> usuarios = usuarioEJB.findAll();
        ArrayList<UsuarioModel> usuariosModel = new ArrayList<UsuarioModel>();
        for (Usuario u : usuarios){
            List<PerfilModel> pm = perfilController.findAll(u.getIdUsuario());
            UsuarioModel um = new UsuarioModel(u);
            um.setPerfiles(pm);
            usuariosModel.add(um);
        }
        return usuariosModel;
    }

    public void create(UsuarioModel um) {
        Usuario u = um.getDBEntity();
        usuarioEJB.create(u);
    }

    public void update(long id, UsuarioModel um) {
        Usuario u = um.getDBEntity();
        usuarioEJB.update(id, u);
    }

    public boolean inicioSesionValido(String usuario, String password){
        if(usuarioEJB.nombreExiste(usuario)){
            if (usuarioEJB.passwordValida(usuario,password)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

}
