package daos.gestionStockDAO.repositorios;

import daos.gestionStockDAO.services.InsumoDAO;
import daos.gestionStockDAO.services.UnidadMedidaDAO;
import entities.gestionStock.Insumo;
import entities.gestionStock.UnidadMedida;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class RepositorioUnidadMedida {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public UnidadMedida buscarUnidadMedida(int id){
        UnidadMedidaDAO umDao = entityManager.find(UnidadMedidaDAO.class, id);
        return umDao.getUnidadMedida();
    }

    //Este metodo no esta listo
    public UnidadMedida buscarUnidadMedida(String nombre){
        Query q = entityManager.createQuery("SELECT um FROM UnidadesMedida um WHERE um.nombre = nombre");
        return (Integer) q.getSingleResult();
    }

    public void crearUnidadMedida(UnidadMedida um) {
        if (entityManager.find(UnidadMedidaDAO.class, um.getNombre()) == null) {
            int idUnidad = buscarUltimoID() + 1;
            UnidadMedidaDAO umDao = new UnidadMedidaDAO(um, idUnidad);
            entityManager.persist(um);
        }
    }

    private int buscarUltimoID() {
        Query q = entityManager.createQuery("SELECT MAX(um.idUnidad) FROM UnidadesMedida um");
        return (Integer) q.getSingleResult();
    }

    public void modificarUnidadMedida(int id, Insumo i) {
        UnidadMedidaDAO x = entityManager.find(UnidadMedidaDAO.class, id);
        if (x != null) {
            x.setNombre(i.getNombre());
            entityManager.merge(x);
        }
    }


}
