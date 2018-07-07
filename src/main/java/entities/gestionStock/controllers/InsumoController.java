package entities.gestionStock.controllers;

import entities.gestionStock.Insumo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class InsumoController {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

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
        if (x != null)
            //Definir que es lo que se actualiza del insumo
            //Setear a x lo que se quiere actualizar de i
            entityManager.merge(x);
    }

    public void remove(int id) {
        Insumo x = entityManager.find(Insumo.class, id);
        if (x != null) entityManager.remove(x);
    }
}
