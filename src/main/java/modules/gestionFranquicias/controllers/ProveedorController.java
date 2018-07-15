package modules.gestionFranquicias.controllers;

import modules.gestionFranquicias.dbEntities.Proveedor;
import modules.gestionFranquicias.ejb.ProveedorEJB;
import modules.gestionFranquicias.modelEntities.ProveedorModel;
import utilities.CuitValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProveedorController {
    @Inject
    ProveedorEJB proveedorEJB;

    public ProveedorModel find(int id) {
        Proveedor p = proveedorEJB.find(id);
        ProveedorModel pm = new ProveedorModel(p);
        return pm;
    }

    public List<ProveedorModel> findAll() {
        List<Proveedor> proveedores = proveedorEJB.findAll();
        ArrayList<ProveedorModel> proveedoresModel = new ArrayList<ProveedorModel>();
        for(Proveedor e: proveedores){
            ProveedorModel em = new ProveedorModel(e);
            proveedoresModel.add(em);
        }
        return proveedoresModel;
    }

    public List<ProveedorModel> findAll(int idInsumo) {
        List<Proveedor> proveedores = proveedorEJB.findAll(idInsumo);
        ArrayList<ProveedorModel> proveedoresModel = new ArrayList<ProveedorModel>();
        for(Proveedor e: proveedores){
            ProveedorModel em = new ProveedorModel(e);
            proveedoresModel.add(em);
        }
        return proveedoresModel;
    }

    public boolean create(ProveedorModel p) {
        Proveedor e = p.getDBEntity();
        if (CuitValidator.validarCuit(e.getCuit())) {
            e.setAlta(true);
            proveedorEJB.create(e);
            return true;
        }
        return false;
    }

    public boolean update(int id, ProveedorModel p) {
        Proveedor e = p.getDBEntity();
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
