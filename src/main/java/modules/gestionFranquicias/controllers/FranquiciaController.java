package modules.gestionFranquicias.controllers;

import modules.gestionFranquicias.dbEntities.Empleado;
import modules.gestionFranquicias.dbEntities.Franquicia;
import modules.gestionFranquicias.ejb.FranquiciaEJB;
import modules.gestionFranquicias.modelEntities.EmpleadoModel;
import modules.gestionFranquicias.modelEntities.FranquiciaModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class FranquiciaController {
    @Inject
    FranquiciaEJB franquiciaEJB;
    EmpleadoController empleadoController;

    public FranquiciaModel find(int id) {
        Franquicia f =  franquiciaEJB.find(id);
        List<EmpleadoModel> e = empleadoController.findAll(id);
        FranquiciaModel fm = new FranquiciaModel(f,e);
        return fm;
    }

    public List<FranquiciaModel> findAll() {
        List<Franquicia> franquicias =  franquiciaEJB.findAll();
        ArrayList<FranquiciaModel> franquiciasModel = new ArrayList<FranquiciaModel>();

        for(Franquicia f: franquicias){
            List<EmpleadoModel> e = empleadoController.findAll(f.getIdFranquicia());
            FranquiciaModel fm = new FranquiciaModel(f,e);
            franquiciasModel.add(fm);
        }

        return franquiciasModel;
    }

    public void create(FranquiciaModel f) {
        franquiciaEJB.create(f.getDBEntity());
    }

    public void update(int id, FranquiciaModel f) {
        franquiciaEJB.update(id, f.getDBEntity());
    }

    public void remove(int id) { franquiciaEJB.remove(id); }

}
