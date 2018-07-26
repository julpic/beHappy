package modules.gestionUsuarios.controllers;

import modules.gestionUsuarios.dbEntities.Usuario;
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
        List<PerfilModel> perfiles = perfilController.findAll(u.getIdUsuario());
        if (perfiles != null) {
            um.setPerfiles(perfiles);
        }
        return um;
    }

    public UsuarioModel findUser(long idEmpleado, long idFranquicia) {
        Usuario u = usuarioEJB.findUser(idEmpleado, idFranquicia);
        UsuarioModel um = new UsuarioModel(u);
        List<PerfilModel> perfiles = perfilController.findAll(u.getIdUsuario());
        if (perfiles != null) {
            um.setPerfiles(perfiles);
        }
        return um;
    }

    public UsuarioModel find(String nombre) {
        Usuario u = usuarioEJB.find(nombre);
        UsuarioModel um = new UsuarioModel(u);
        List<PerfilModel> perfiles = perfilController.findAll(u.getIdUsuario());
        if (perfiles != null) {
            um.setPerfiles(perfiles);
        }
        return um;
    }

    public List<UsuarioModel> findAll() {
        List<Usuario> usuarios = usuarioEJB.findAll();
        ArrayList<UsuarioModel> usuariosModel = new ArrayList<UsuarioModel>();
        for (Usuario u : usuarios) {
            List<PerfilModel> pm = perfilController.findAll(u.getIdUsuario());
            UsuarioModel um = new UsuarioModel(u);
            if (pm != null) {
                um.setPerfiles(pm);
            }
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

    public boolean inicioSesionValido(String usuario, String password) {
        if (usuarioEJB.nombreExiste(usuario)) {
            return (usuarioEJB.passwordValida(usuario, password)) ? true : false;
        }
        return false;
    }

}