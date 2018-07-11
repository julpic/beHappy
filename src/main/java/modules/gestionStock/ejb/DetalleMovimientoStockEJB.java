package modules.gestionStock.ejb;

import modules.gestionStock.dbEntities.DetalleMovimientoStock;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DetalleMovimientoStockEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public List<DetalleMovimientoStock> findAll(int idMovimiento) {
        Query q = entityManager.createQuery("SELECT i FROM DetalleMovimientoStock i WHERE i.idMovimiento = :idMov")
                .setParameter("idMov", idMovimiento);
        return q.getResultList();
    }

    //preguntar si desde el front le pueden dar un valor de 0 a n en el id de cada detalle
    public void createAll(List<DetalleMovimientoStock> detalles) {
        int idDetalle = 0;
        for (DetalleMovimientoStock det : detalles) {
            det.setIdDetalleMovimientoStock(idDetalle);
            entityManager.persist(det);
            idDetalle++;
        }
    }
}



