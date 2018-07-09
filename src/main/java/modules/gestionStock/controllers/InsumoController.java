package modules.gestionStock.controllers;

import modules.gestionStock.ejb.StockEJB;
import modules.gestionStock.modelEntities.Insumo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class InsumoController {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    StockEJB rs;

    //Hay que mostrar el insumo con su unidad de medida
    public Insumo find(int id) {
        return rs.buscarInsumo(id);
    }

    public List<Insumo> findAll() {
        return rs.buscarInsumos();
    }

    public void create(Insumo i) {
        rs.crearInsumo(i);
    }

    public List<Insumo> buscarInsumosConStockInsuficiente(){
        return rs.buscarInsumosConStockInsuficiente();
    }

    public void update(int id, Insumo i) {
        rs.modificarInsumo(id, i);
    }

    public void remove(int id) {
        rs.eliminarInsumo(id);
    }
}
