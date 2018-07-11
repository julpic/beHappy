package modules.gestionStock.ejb;

import modules.gestionStock.controllers.DetalleMovimientoStockController;
import modules.gestionStock.controllers.MovimientoStockController;
import modules.gestionStock.dbEntities.DetalleMovimientoStock;
import modules.gestionStock.dbEntities.MovimientoStock;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MovimientoStockEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    DetalleMovimientoStockController detalleMovimientoStockController;
    @Inject
    MovimientoStockController movimientoStockController;

    public MovimientoStock find(int id) {
        return entityManager.find(MovimientoStock.class, id);
    }

    private List<DetalleMovimientoStock> findDetalles(int idMovimiento) {
        return detalleMovimientoStockController.findAll(idMovimiento);
/*        DetalleMovimientoStockEJB rdms = new DetalleMovimientoStockEJB();
        InsumoEJB ri = new InsumoEJB();
        List<DetalleMovimientoStock> detallesDAO = rdms.buscarDetallesDeMovimiento(idMovimiento);
        ArrayList<DetalleMovimientoStock> detalles = new ArrayList<DetalleMovimientoStock>();

        for (DetalleMovimientoStock detDao : detallesDAO) {
            DetalleMovimientoStock det = detDao.getDetalleMovimiento(ri.buscarInsumo(detDao.getIdInsumo()));
            detalles.add(det);
        }
        return detalles;*/
    }

    public List<MovimientoStock> findAll() {
        return movimientoStockController.findAll();
    }

    private int buscarUltimoID() {
        Query q = entityManager.createQuery("SELECT MAX(i.idMovimiento) FROM DetalleMovimientoStock i");
        return (Integer) q.getSingleResult();
    }

    public void create(MovimientoStock ms) {
        if (entityManager.find(MovimientoStock.class, ms.getIdMovimientoStock()) == null) {
            entityManager.persist(ms);
        }
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
