package modules.gestionUsuarios.controllers;

import modules.gestionUsuarios.dbEntities.Usuario;
import modules.gestionUsuarios.ejb.PerfilEJB;
import modules.gestionUsuarios.ejb.UsuarioEJB;
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

}
