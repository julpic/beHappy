package modules.gestionStock.ejb;

import modules.gestionStock.dbEntities.UnidadMedida;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UnidadMedidaEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public UnidadMedida find(int id) {
        return entityManager.find(UnidadMedida.class, id);
    }

/*    public int buscarIDUnidadMedida(String nombreU){
        TypedQuery<Integer> q = (TypedQuery<Integer>) entityManager.createQuery("SELECT um.idUnidad FROM UnidadMedida um WHERE um.nombre = :nombreU")
                .setParameter("nombreU", nombreU);
        return q.getSingleResult();
    }*/

    public List<UnidadMedida> findAll() {
        Query q = entityManager.createQuery("SELECT i FROM UnidadMedida i");
        return q.getResultList();
    }

    public void create(UnidadMedida um) {
        if (entityManager.find(UnidadMedida.class, um.getIdUnidad()) == null) {
            entityManager.persist(um);
        }
    }

    private int buscarUltimoID() {
        Query q = entityManager.createQuery("SELECT MAX(um.idUnidad) FROM UnidadMedida um");
        return (Integer) q.getSingleResult();
    }

    public void update(int id, UnidadMedida um) {
        UnidadMedida x = entityManager.find(UnidadMedida.class, id);
        if (x != null) {
            x.setNombre(um.getNombre());
            entityManager.merge(x);
        }
    }


}
