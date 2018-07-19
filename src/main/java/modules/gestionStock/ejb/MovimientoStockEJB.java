package modules.gestionStock.ejb;

import modules.gestionStock.controllers.MovimientoStockController;
import modules.gestionStock.dbEntities.DetalleMovimientoStock;
import modules.gestionStock.dbEntities.MovimientoStock;
import utilities.GeneradorID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

@Stateless
public class MovimientoStockEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    DetalleMovimientoStockEJB detalleMovimientoStockEJB;
    @Inject
    MovimientoStockController movimientoStockController;

    public MovimientoStock find(int id) {
        return entityManager.find(MovimientoStock.class, id);
    }

    private List<DetalleMovimientoStock> findDetalles(int idMovimiento) {
        return detalleMovimientoStockEJB.findAll(idMovimiento);
    }

    public List<MovimientoStock> findAll() {
        Query q = entityManager.createQuery("SELECT i FROM MovimientoStock i");
        return q.getResultList();
    }

    public int buscarNuevoID(){
        GeneradorID genID = new GeneradorID();
        return genID.buscarID(buscarUltimoID());
    }

    private int buscarUltimoID() {
        TypedQuery<Integer> q = (TypedQuery<Integer>) entityManager.createQuery("SELECT MAX(i.idMovimientoStock) FROM MovimientoStock i");
        if(q.getSingleResult() == null){
            return 0;
        }
        return (Integer) q.getSingleResult();
    }

    public void create(MovimientoStock ms) {
        ms.setIdMovimientoStock(buscarNuevoID());
            entityManager.persist(ms);
    }

    //Se restaura el stock antes del movimiento?
    public void cancel(int id, MovimientoStock ms) {
        MovimientoStock x = entityManager.find(MovimientoStock.class, id);
        if (x != null) {
            x.setFechaHoraAnulacion(java.sql.Timestamp.valueOf(ms.getFechaHoraAnulacion().toString()));
            entityManager.merge(x);
        }
    }

}
