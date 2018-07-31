package modules.gestionUsuarios.controllers;

import modules.gestionUsuarios.dbEntities.Perfil;
import modules.gestionUsuarios.dbEntities.Usuario;
import modules.gestionUsuarios.ejb.PerfilEJB;
import modules.gestionUsuarios.modelEntities.PerfilModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PerfilController {
    @Inject
    PerfilEJB perfilEJB;


    public PerfilModel find(long id) {
        PerfilModel p = new PerfilModel(perfilEJB.find(id));
        return p;
    }

    public List<PerfilModel> findAll() {
        List<Perfil> perfiles = perfilEJB.findAll();
        ArrayList<PerfilModel> perfilesModel = new ArrayList<PerfilModel>();
        for(Perfil p : perfiles){
            PerfilModel pm = new PerfilModel(p);
            perfilesModel.add(pm);
        }
        return perfilesModel;
    }

    public List<PerfilModel> findAll(long idUsuario) {
        List<Perfil> perfiles = perfilEJB.findAll(idUsuario);
        ArrayList<PerfilModel> perfilesModel = new ArrayList<PerfilModel>();
        for(Perfil p : perfiles){
            PerfilModel pm = new PerfilModel(p);
            perfilesModel.add(pm);
        }
        return perfilesModel;
    }

    public boolean create(PerfilModel um) { return perfilEJB.create(um.getDBEntity()); }

    public void update(long id, PerfilModel um) {
        perfilEJB.update(id, um.getDBEntity());
    }
}
