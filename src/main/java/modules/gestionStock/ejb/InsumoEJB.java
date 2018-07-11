package modules.gestionStock.ejb;

import modules.gestionStock.dbEntities.Insumo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class InsumoEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public Insumo find(int id) {
        return entityManager.find(Insumo.class, id);
    }

    public List<Insumo> findAll() {
        Query q = entityManager.createQuery("SELECT i FROM Insumo i WHERE i.alta = true");
        return q.getResultList();
    }

    public List<Insumo> findInsStock() {
        Query q = entityManager.createQuery("SELECT i FROM Insumo i WHERE i.cantidadStock <= i.stockMinimo");
        return q.getResultList();
    }

    public void create(Insumo i) {
        if (entityManager.find(Insumo.class, i.getIdInsumo()) == null) {
            entityManager.persist(i);
        }
    }

    public void update(int id, Insumo i) {
        Insumo x = entityManager.find(Insumo.class, id);
        if (x != null) {
            x.setNombre(i.getNombre());
            x.setCantidadStock(i.getCantidadStock());
            x.setStockMinimo(i.getStockMinimo());
            x.setIdUnidadMedida(i.getIdUnidadMedida());
            entityManager.merge(x);
        }
    }

    public void remove(int id) {
        Insumo x = entityManager.find(Insumo.class, id);
        if (x != null) {
            x.darDeBaja();
            entityManager.merge(x);
        }
    }

    public void updateStock(int idInsumo, int cantidad, boolean entrada) {
        Insumo i = find(idInsumo);
        if (entrada) {
            i.setCantidadStock(i.getCantidadStock() + cantidad);
        } else {
            i.setCantidadStock(i.getCantidadStock() - cantidad);
        }
        entityManager.merge(i);
    }
}
