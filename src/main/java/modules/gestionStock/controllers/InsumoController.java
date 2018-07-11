package modules.gestionStock.controllers;

import modules.gestionStock.dbEntities.Insumo;
import modules.gestionStock.ejb.InsumoEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class InsumoController {
    @Inject
    InsumoEJB insumoEJB;

    //Hay que mostrar el insumo con su unidad de medida
    public Insumo find(int id) {
        return insumoEJB.find(id);
    }

    public List<Insumo> findAll() {
        return insumoEJB.findAll();
    }

    public void create(Insumo i) {
        insumoEJB.create(i);
    }

    public List<Insumo> buscarInsumosConStockInsuficiente() {
        return insumoEJB.findInsStock();
    }

    public void update(int id, Insumo i) {
        insumoEJB.update(id, i);
    }

    public void remove(int id) {
        insumoEJB.remove(id);
    }

    public void updateStock(int idInsumo, int cantidad, boolean entrada) {
        insumoEJB.updateStock(idInsumo, cantidad, entrada);
    }
}
