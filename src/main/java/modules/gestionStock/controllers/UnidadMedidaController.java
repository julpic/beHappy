package modules.gestionStock.controllers;

import modules.gestionStock.ModelEntities.UnidadMedidaModel;
import modules.gestionStock.dbEntities.UnidadMedida;
import modules.gestionStock.ejb.UnidadMedidaEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UnidadMedidaController {
    @Inject
    UnidadMedidaEJB unidadMedidaEJB;

    public UnidadMedidaModel find(long id) {
        UnidadMedidaModel umm = new UnidadMedidaModel(unidadMedidaEJB.find(id));
        return umm;

    }

    public List<UnidadMedidaModel> findAll() {
        List<UnidadMedida> unidadMedidas = unidadMedidaEJB.findAll();
        ArrayList<UnidadMedidaModel> unidadesModel = new ArrayList<UnidadMedidaModel>();
        for(UnidadMedida um : unidadMedidas){
            UnidadMedidaModel umm = new UnidadMedidaModel(um);
            unidadesModel.add(umm);
        }
        return unidadesModel;
    }

    public boolean create(UnidadMedidaModel um) { return unidadMedidaEJB.create(um.getDBEntity()); }

    public void update(long id, UnidadMedidaModel um) {
        unidadMedidaEJB.update(id, um.getDBEntity());
    }

}
