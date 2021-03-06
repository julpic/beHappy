package modules.gestionStock.ejb;

import modules.gestionFranquicias.ejb.FranquiciaEJB;
import modules.gestionStock.dbEntities.UnidadMedida;
import utilities.GeneradorID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UnidadMedidaEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    GeneradorID genID;

    public UnidadMedida find(long id) {
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

    public boolean create(UnidadMedida um) {
        Long id = buscarNuevoID();
        if (id > 0){
            um.setIdUnidad(id);
            entityManager.persist(um);
            return true;
        }else{
            return false;
        }
    }

    public long buscarNuevoID(){
        return genID.buscarID(buscarUltimoID());}

    private long buscarUltimoID() {
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(um.idUnidad) FROM UnidadMedida um");
        if(q.getSingleResult() == null){
            return 0;
        }
        return q.getSingleResult();
    }

    public void update(long id, UnidadMedida um) {
        UnidadMedida x = entityManager.find(UnidadMedida.class, id);
        if (x != null) {
            x.setNombre(um.getNombre());
            entityManager.merge(x);
        }
    }


}
