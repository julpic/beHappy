package modules.gestionStock.controllers;

import modules.gestionStock.ejb.StockEJB;
import modules.gestionStock.modelEntities.UnidadMedida;

import java.util.List;

public class UnidadMedidaController {
    StockEJB rs = new StockEJB();


    public UnidadMedida find(int id) {
        return rs.buscarUnidadMedida(id);
    }

    public List<UnidadMedida> findAll() {
        return rs.buscarUnidadesMedida();
    }

    public void create(UnidadMedida um) {
        rs.crearUnidadMedida(um);
    }


}
