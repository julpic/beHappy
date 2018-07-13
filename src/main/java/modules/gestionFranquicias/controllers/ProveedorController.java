package modules.gestionFranquicias.controllers;

import modules.gestionFranquicias.dbEntities.Proveedor;
import modules.gestionFranquicias.ejb.ProveedorEJB;
import utilities.CuitValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ProveedorController {
    @Inject
    ProveedorEJB proveedorEJB;

    public Proveedor find(int id) {
        return proveedorEJB.find(id);
    }

    public List<Proveedor> findAll() {
        return proveedorEJB.findAll();
    }

    public boolean create(Proveedor e) {
        if (CuitValidator.validarCuit(e.getCuit())) {
            e.setAlta(true);
            proveedorEJB.create(e);
            return true;
        }
        return false;
    }

    public boolean update(int id, Proveedor e) {
        if (CuitValidator.validarCuit(e.getCuit())) {
            proveedorEJB.update(id, e);
            return true;
        }
        return false;
    }

    public void remove(int id) {
        proveedorEJB.remove(id);
    }

}
