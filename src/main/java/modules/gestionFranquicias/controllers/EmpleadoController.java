package modules.gestionFranquicias.controllers;

import modules.gestionFranquicias.dbEntities.Empleado;
import modules.gestionFranquicias.ejb.EmpleadoEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EmpleadoController {
    @Inject
    EmpleadoEJB empleadoEJB;

    public Empleado find(int id) {
        return empleadoEJB.find(id);
    }

    public List<Empleado> findAll() {
        return empleadoEJB.findAll();
    }

    public void create(Empleado e) {
        empleadoEJB.create(e);
    }

    public void update(int id, Empleado e) { empleadoEJB.update(id, e); }

    public void remove(int id) { empleadoEJB.remove(id); }
}
