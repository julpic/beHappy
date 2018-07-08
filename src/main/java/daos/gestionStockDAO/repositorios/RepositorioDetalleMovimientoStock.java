package daos.gestionStockDAO.repositorios;

import daos.gestionStockDAO.services.DetalleMovimientoStockDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class RepositorioDetalleMovimientoStock {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public List<DetalleMovimientoStockDAO> buscarDetallesDeMovimiento(int idMovimiento) {
        Query q = entityManager.createQuery("SELECT i FROM DetalleMovimientoStockDAO i WHERE i.idMovimiento = :idMov")
                .setParameter("idMov", idMovimiento);
        return  q.getResultList();
    }


}
