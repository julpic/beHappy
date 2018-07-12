package modules.gestionFranquicias.ejb;

import modules.gestionFranquicias.dbEntities1.Franquicia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class FranquiciaEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public Franquicia find(int id) {
        return entityManager.find(Franquicia.class, id);
    }

    public List<Franquicia> findAll() {
        Query q = entityManager.createQuery("SELECT f FROM Franquicia f WHERE f.alta = true");
        return q.getResultList();
    }

    public void create(Franquicia f) {
        if (entityManager.find(Franquicia.class, f.getIdFranquicia()) == null) {
            entityManager.persist(f);
        }
    }

    public void update(int id, Franquicia f) {
        Franquicia x = entityManager.find(Franquicia.class, id);
        if (x != null) {
            x.setApellidoDueno(f.getApellidoDueno());
            x.setCuit(f.getCuit());
            x.setDireccion(f.getDireccion());
            x.seteMailDueno(f.geteMailDueno());
            x.setNombreDueno(f.getNombreDueno());
            x.setAlta(f.getAlta());
            entityManager.merge(x);
        }
    }

    public void remove(int id) {
        Franquicia x = entityManager.find(Franquicia.class, id);
        if (x != null) {
            x.darDeBaja();
            entityManager.merge(x);
        }
    }
}
