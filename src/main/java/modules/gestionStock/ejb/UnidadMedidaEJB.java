package modules.gestionStock.ejb;

import modules.gestionStock.dbEntities.UnidadMedidaDB;
import modules.gestionStock.modelEntities.UnidadMedida;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UnidadMedidaEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public UnidadMedida buscarUnidadMedida(int id){
        UnidadMedidaDB umDao = entityManager.find(UnidadMedidaDB.class, id);
        return umDao.createUnidadMedida();
    }

    public int buscarIDUnidadMedida(String nombreU){
        TypedQuery<Integer> q = (TypedQuery<Integer>) entityManager.createQuery("SELECT um.idUnidad FROM UnidadMedidaDB um WHERE um.nombre = :nombreU")
                .setParameter("nombreU", nombreU);
        return q.getSingleResult();
    }

    public List<UnidadMedida> buscarUnidadesMedida(){
        List<UnidadMedidaDB> unidadesDAO = entityManager.createQuery("SELECT i FROM UnidadMedidaDB i").getResultList();
        ArrayList<UnidadMedida> unidades = new ArrayList<UnidadMedida>();
        UnidadMedidaEJB rs = new UnidadMedidaEJB();
        for(UnidadMedidaDB uDAO: unidadesDAO){
            unidades.add(uDAO.createUnidadMedida());
        }

        return unidades;
    }

    public void crearUnidadMedida(UnidadMedida um) {
        if (entityManager.find(UnidadMedidaDB.class, um.getNombre()) == null) {
            int idUnidad = buscarUltimoID() + 1;
            UnidadMedidaDB umDao = new UnidadMedidaDB(um, idUnidad);
            entityManager.persist(umDao);
        }
    }

    private int buscarUltimoID() {
        Query q = entityManager.createQuery("SELECT MAX(um.idUnidad) FROM UnidadMedidaDB um");
        return (Integer) q.getSingleResult();
    }

    public void modificarUnidadMedida(int id, UnidadMedida um) {
        UnidadMedidaDB x = entityManager.find(UnidadMedidaDB.class, id);
        if (x != null) {
            x.setNombre(um.getNombre());
            entityManager.merge(x);
        }
    }


}
