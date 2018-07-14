package modules.gestionStock.controllers;

import modules.gestionStock.ModelEntities.InsumoModel;
import modules.gestionStock.ModelEntities.UnidadMedidaModel;
import modules.gestionStock.dbEntities.Insumo;
import modules.gestionStock.dbEntities.UnidadMedida;
import modules.gestionStock.ejb.InsumoEJB;
import modules.gestionStock.ejb.UnidadMedidaEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class InsumoController {
    @Inject
    InsumoEJB insumoEJB;
    UnidadMedidaEJB unidadMedidaEJB;


    public InsumoModel find(int id) {

        Insumo i = insumoEJB.find(id);
        UnidadMedidaModel umm = new UnidadMedidaModel(unidadMedidaEJB.find(i.getIdUnidadMedida()));
        InsumoModel im = new InsumoModel(i,umm);
        return im;

    }

    public List<InsumoModel> findAll() {
        List<Insumo> insumos = insumoEJB.findAll();
        ArrayList<InsumoModel> insumosModels = new ArrayList<InsumoModel>();
        for (Insumo i : insumos){
            UnidadMedidaModel umm = new UnidadMedidaModel(unidadMedidaEJB.find(i.getIdUnidadMedida()));
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

    public void update(int id, InsumoModel im) {
        Insumo i = im.getDBEntity();
        insumoEJB.update(id, i);
    }

    public void remove(int id) {
        insumoEJB.remove(id);
    }

    public void updateStock(int idInsumo, int cantidad, boolean entrada) {
        insumoEJB.updateStock(idInsumo, cantidad, entrada);
    }
}
