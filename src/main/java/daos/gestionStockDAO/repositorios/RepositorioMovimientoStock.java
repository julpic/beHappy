package daos.gestionStockDAO.repositorios;

import daos.gestionStockDAO.services.DetalleMovimientoStockDAO;
import daos.gestionStockDAO.services.MovimientoStockDAO;
import entities.gestionStock.DetalleMovimientoStock;
import entities.gestionStock.MovimientoStock;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMovimientoStock {

    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public MovimientoStock buscarMovimientoStock(int id){
        MovimientoStockDAO msDao = entityManager.find(MovimientoStockDAO.class, id);
        return msDao.getMoviminetoStock(buscarDetalles(id));
    }

    private List<DetalleMovimientoStock> buscarDetalles(int idMovimiento) {
        RepositorioDetalleMovimientoStock rdms = new RepositorioDetalleMovimientoStock();
        RepositorioInsumo ri = new RepositorioInsumo();
        List<DetalleMovimientoStockDAO> detallesDAO = rdms.buscarDetallesDeMovimiento(idMovimiento);
        ArrayList<DetalleMovimientoStock> detalles = new ArrayList<DetalleMovimientoStock>();

        for(DetalleMovimientoStockDAO detDao : detallesDAO){
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
        Query q = entityManager.createQuery("SELECT MAX(i.idMovimiento) FROM DetalleMovimientoStockDAO i");
        return (Integer) q.getSingleResult();

    }


    public int crearMovimientoStock(MovimientoStock ms) {
        int idMovimiento = buscarUltimoID() + 1;
        ms.setIdMovimientoStock(idMovimiento);
        if (entityManager.find(MovimientoStockDAO.class, ms.getIdMovimientoStock()) == null) {
            MovimientoStockDAO msDAO = new MovimientoStockDAO(ms, idMovimiento);
            entityManager.persist(msDAO);
        }
        return idMovimiento;
    }

    /*public void remove(int id) {
        MovimientoStock actual = buscarMovimientoStock(id);
        boolean entrada = actual.isEntrada();

        List<DetalleMovimientoStock> detalles = buscarDetalles(actual.getIdMovimientoStock());

        revertirDetalles(detalles, entrada);

        Date date = new Date();
        Timestamp fechaAnulacion = new Timestamp(date.getTime());
        actual.setFechaHoraAnulacion(fechaAnulacion);
        entityManager.merge(actual);
    }

    private void revertirDetalles(List<DetalleMovimientoStockDAO> detalles, boolean entrada) {
        DetalleMovimientoStockController detalleController = new DetalleMovimientoStockController();

        for (DetalleMovimientoStockDAO d : detalles) {
            detalleController.remove(d, entrada);
        }*/
}
