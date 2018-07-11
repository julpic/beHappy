package modules.gestionStock.controllers;

import modules.gestionStock.dbEntities.UnidadMedida;
import modules.gestionStock.ejb.UnidadMedidaEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UnidadMedidaController {
    @Inject
    UnidadMedidaEJB unidadMedidaEJB;

    public UnidadMedida find(int id) {
        return unidadMedidaEJB.find(id);
    }

    public List<UnidadMedida> findAll() {
        return unidadMedidaEJB.findAll();
    }

    public void create(UnidadMedida um) {
        unidadMedidaEJB.create(um);
    }

    public void update(int id, UnidadMedida um) {
        unidadMedidaEJB.update(id, um);
    }

}
