package modules.gestionFranquicias.controllers;

import modules.gestionFranquicias.dbEntities.Empleado;
import modules.gestionFranquicias.ejb.EmpleadoEJB;
import modules.gestionFranquicias.modelEntities.EmpleadoModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class EmpleadoController {
    @Inject
    EmpleadoEJB empleadoEJB;

    public EmpleadoModel find(long id) {
        Empleado e = empleadoEJB.find(id);
        EmpleadoModel em = new EmpleadoModel(e);
        return em;

    }

    public List<EmpleadoModel> findAll() {
        List<Empleado> empleados = empleadoEJB.findAll();
        ArrayList<EmpleadoModel> empleadosModel = new ArrayList<EmpleadoModel>();
        for(Empleado e: empleados){
            EmpleadoModel em = new EmpleadoModel(e);
            empleadosModel.add(em);
        }
        return empleadosModel;
    }

    public List<EmpleadoModel> findAll(long idFranquicia) {
        List<Empleado> empleados = empleadoEJB.findAll(idFranquicia);
        ArrayList<EmpleadoModel> empleadosModel = new ArrayList<EmpleadoModel>();
        for(Empleado e: empleados){
            EmpleadoModel em = new EmpleadoModel(e);
            empleadosModel.add(em);
        }
        return empleadosModel;
    }

    public void create(EmpleadoModel e) { empleadoEJB.create(e.getDBEntity());
    }

    public void update(long id, EmpleadoModel e) { empleadoEJB.update(id, e.getDBEntity()); }

    public void remove(long id) { empleadoEJB.remove(id); }
}
