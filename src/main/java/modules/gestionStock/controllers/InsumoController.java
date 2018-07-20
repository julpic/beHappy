package modules.gestionStock.controllers;

import modules.gestionStock.ModelEntities.InsumoModel;
import modules.gestionStock.ModelEntities.UnidadMedidaModel;
import modules.gestionStock.dbEntities.Insumo;
import modules.gestionStock.dbEntities.UnidadMedida;
import modules.gestionStock.ejb.InsumoEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class InsumoController {
    @Inject
    InsumoEJB insumoEJB;
    @Inject
    UnidadMedidaController unidadMedidaController;


    public InsumoModel find(long id) {

        Insumo i = insumoEJB.find(id);
        UnidadMedidaModel umm = unidadMedidaController.find(i.getIdUnidadMedida());
        InsumoModel im = new InsumoModel(i,umm);
        return im;

    }

    public List<InsumoModel> findAll() {
        List<Insumo> insumos = insumoEJB.findAll();
        ArrayList<InsumoModel> insumosModels = new ArrayList<InsumoModel>();
        for (Insumo i : insumos){
            UnidadMedidaModel umm = unidadMedidaController.find(i.getIdUnidadMedida());
            InsumoModel im = new InsumoModel(i,umm);
            insumosModels.add(im);
        }
        return insumosModels;
    }

    public List<InsumoModel> findAll(long idProveedor) {
        List<Insumo> insumos = insumoEJB.findAll(idProveedor);
        ArrayList<InsumoModel> insumosModels = new ArrayList<InsumoModel>();
        for (Insumo i : insumos){
            UnidadMedidaModel umm = unidadMedidaController.find(i.getIdUnidadMedida());
            InsumoModel im = new InsumoModel(i,umm);
            insumosModels.add(im);
        }
        return insumosModels;
    }

    public void create(InsumoModel im) {
        Insumo i = im.getDBEntity();
        insumoEJB.create(i);
    }

    public List<Insumo> buscarInsumosConStockInsuficiente() {
        return insumoEJB.findInsStock();
    }

    public void update(long id, InsumoModel im) {
        Insumo i = im.getDBEntity();
        insumoEJB.update(id, i);
    }

    public void remove(long id) {
        insumoEJB.remove(id);
    }

    public void updateStock(long idInsumo, int cantidad, boolean entrada) {
        insumoEJB.updateStock(idInsumo, cantidad, entrada);
    }
}
