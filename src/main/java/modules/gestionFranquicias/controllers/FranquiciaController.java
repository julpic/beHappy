package modules.gestionFranquicias.controllers;

import modules.gestionFranquicias.dbEntities1.Franquicia;
import modules.gestionFranquicias.ejb.FranquiciaEJB;
import modules.gestionStock.dbEntities.Insumo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class FranquiciaController {
    @Inject
    FranquiciaEJB franquiciaEJB;

    public Franquicia find(int id) {
        return franquiciaEJB.find(id);
    }

    public List<Franquicia> findAll() {
        return franquiciaEJB.findAll();
    }

    public void create(Franquicia f) {
        franquiciaEJB.create(f);
    }

    public void update(int id, Insumo i) {
        franquiciaEJB.update(id, i);
    }

    public void remove(int id) { franquiciaEJB.remove(id); }

}
