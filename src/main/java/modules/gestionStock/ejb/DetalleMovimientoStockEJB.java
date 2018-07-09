package modules.gestionStock.ejb;

import modules.gestionStock.dbEntities.DetalleMovimientoStockDB;
import modules.gestionStock.modelEntities.DetalleMovimientoStock;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class DetalleMovimientoStockEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public List<DetalleMovimientoStockDB> buscarDetallesDeMovimiento(int idMovimiento) {
        Query q = entityManager.createQuery("SELECT i FROM DetalleMovimientoStockDB i WHERE i.idMovimiento = :idMov")
                .setParameter("idMov", idMovimiento);
        return  q.getResultList();
    }

    public void crearDetallesDeUnMovimiento(int idMovimiento, List<DetalleMovimientoStock> detalles){
        int idDetalle = 0;
        for(DetalleMovimientoStock det : detalles){
            DetalleMovimientoStockDB detDAO = new DetalleMovimientoStockDB(det, idDetalle, idMovimiento);
            entityManager.persist(detDAO);
            idDetalle ++;
        }
    }
}



