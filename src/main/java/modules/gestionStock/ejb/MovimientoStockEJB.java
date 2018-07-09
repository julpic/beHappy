package modules.gestionStock.ejb;

import modules.gestionStock.dbEntities.DetalleMovimientoStockDB;
import modules.gestionStock.dbEntities.MovimientoStockDB;
import modules.gestionStock.modelEntities.DetalleMovimientoStock;
import modules.gestionStock.modelEntities.MovimientoStock;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MovimientoStockEJB {

    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public MovimientoStock buscarMovimientoStock(int id){
        MovimientoStockDB msDao = entityManager.find(MovimientoStockDB.class, id);
        return msDao.getMoviminetoStock(buscarDetalles(id));
    }

    private List<DetalleMovimientoStock> buscarDetalles(int idMovimiento) {
        DetalleMovimientoStockEJB rdms = new DetalleMovimientoStockEJB();
        InsumoEJB ri = new InsumoEJB();
        List<DetalleMovimientoStockDB> detallesDAO = rdms.buscarDetallesDeMovimiento(idMovimiento);
        ArrayList<DetalleMovimientoStock> detalles = new ArrayList<DetalleMovimientoStock>();

        for(DetalleMovimientoStockDB detDao : detallesDAO){
            DetalleMovimientoStock det = detDao.getDetalleMovimiento(ri.buscarInsumo(detDao.getIdInsumo()));
            detalles.add(det);
        }
        return detalles;
    }

    public List<MovimientoStock> buscarMovimientosStock() {
        Integer ultimoId = buscarUltimoID();
        ArrayList<MovimientoStock> movimientos = new ArrayList<MovimientoStock>();

        for(int id = 0; id <= ultimoId; id++){
            movimientos.add(buscarMovimientoStock(id));
        }

        return movimientos;
    }

    private int buscarUltimoID() {
        Query q = entityManager.createQuery("SELECT MAX(i.idMovimiento) FROM DetalleMovimientoStockDB i");
        return (Integer) q.getSingleResult();

    }


    public int crearMovimientoStock(MovimientoStock ms) {
        int idMovimiento = buscarUltimoID() + 1;
        ms.setIdMovimientoStock(idMovimiento);
        if (entityManager.find(MovimientoStockDB.class, ms.getIdMovimientoStock()) == null) {
            MovimientoStockDB msDAO = new MovimientoStockDB(ms, idMovimiento);
            entityManager.persist(msDAO);
        }
        return idMovimiento;
    }

    public void anularMovimientoStock(int id, MovimientoStock ms) {
       MovimientoStockDB x = entityManager.find(MovimientoStockDB.class, id);

       if (x != null) {
            x.setFechaHoraAnulacion(java.sql.Timestamp.valueOf(ms.getFehcaHoraAnulacion().toString()));
            entityManager.merge(x);
        }
    }

}
