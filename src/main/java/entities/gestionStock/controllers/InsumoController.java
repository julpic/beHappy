package entities.gestionStock.controllers;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class InsumoController {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    //Hay que mostrar el insumo con su unidad de medida
    public Insumo find(int id) {
        return entityManager.find(Insumo.class, id);
    }

    public List<Insumo> findAll() {
        Query q = entityManager.createQuery("SELECT i FROM Insumo i");
        return q.getResultList();
    }

    public void create(Insumo i) {
        if (entityManager.find(Insumo.class, i.getIdInsumo()) == null)
            entityManager.persist(i);
    }

    public void update(int id, Insumo i) {
        Insumo x = entityManager.find(Insumo.class, id);
        if (x != null) {
            x.setNombre(i.getNombre());
            x.setCantidadStock(i.getCantidadStock());
            entityManager.merge(x);
        }
    }

    public void remove(int id) {
        Insumo x = entityManager.find(Insumo.class, id);
        if (x != null) entityManager.remove(x);
    }
}
