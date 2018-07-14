package modules.gestionFranquicias.ejb;

import modules.gestionFranquicias.dbEntities.Proveedor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ProveedorEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public Proveedor find(int id) {
        return entityManager.find(Proveedor.class, id);
    }

    public List<Proveedor> findAll() {
        Query q = entityManager.createQuery("SELECT i from Proveedor i");
        return q.getResultList();
    }

    public void create(Proveedor p) {
        Proveedor x = entityManager.find(Proveedor.class, p.getIdProveedor());
        if (x == null) {
            entityManager.persist(p);
        }
    }

    public void update(int id, Proveedor p) {
        Proveedor x = entityManager.find(Proveedor.class, id);
        if (x != null) {
            x.setCuit(p.getCuit());
            x.seteMail(p.geteMail());
            x.setRazonSocial(p.getRazonSocial());
            x.setTelefonoContacto(p.getTelefonoContacto());
            entityManager.merge(x);
        }
    }

    public void remove(int id) {
        Proveedor x = entityManager.find(Proveedor.class, id);
        if (x != null) {
            x.setAlta(false);
            entityManager.merge(x);
        }
    }
}
