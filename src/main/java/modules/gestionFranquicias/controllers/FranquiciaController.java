package modules.gestionFranquicias.controllers;

import modules.gestionFranquicias.dbEntities.Empleado;
import modules.gestionFranquicias.dbEntities.Franquicia;
import modules.gestionFranquicias.ejb.FranquiciaEJB;
import modules.gestionFranquicias.modelEntities.EmpleadoModel;
import modules.gestionFranquicias.modelEntities.FranquiciaModel;
import utilities.CuitValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class FranquiciaController {
    @Inject
    FranquiciaEJB franquiciaEJB;
    @Inject
    EmpleadoController empleadoController;

    public FranquiciaModel find(long id) {
        Franquicia f =  franquiciaEJB.find(id);
        List<EmpleadoModel> e = empleadoController.findAll(id);
        FranquiciaModel fm = new FranquiciaModel(f,e);
        return fm;
    }

    public Long find() {
        Long f =  franquiciaEJB.findIDFranquicia();
       return f;
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

    public List<FranquiciaModel> findAll(long idProveedor) {
        List<Franquicia> franquicias =  franquiciaEJB.findAll(idProveedor);
        ArrayList<FranquiciaModel> franquiciasModel = new ArrayList<FranquiciaModel>();

        for(Franquicia f: franquicias){
            List<EmpleadoModel> e = empleadoController.findAll(f.getIdFranquicia());
            FranquiciaModel fm = new FranquiciaModel(f,e);
            franquiciasModel.add(fm);
        }

        return franquiciasModel;
    }


    public boolean create(FranquiciaModel fm)
    {   Franquicia f = fm.getDBEntity();
        if (CuitValidator.validarCuit(f.getCuit())) {
            franquiciaEJB.create(f);
            return true;
        }
        return false;
    }

    public boolean update(long id, FranquiciaModel fm) {
        Franquicia f = fm.getDBEntity();
        if (CuitValidator.validarCuit(f.getCuit())) {
            franquiciaEJB.update(id, f);
            return true;
        }
        return false;
    }

    public void remove(long id) { franquiciaEJB.remove(id); }

}
