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

/*
    public void crearMovimientoStock(Insumo i) {
        if (entityManager.find(InsumoDAO.class, i.getIdInsumo()) == null) {
            InsumoDAO iDao = new InsumoDAO(i);
            entityManager.persist(iDao);
        }
    }

    public void modificarModificarMovimiento(int id, Insumo i) {
        InsumoDAO x = entityManager.find(InsumoDAO.class, id);
        if (x != null) {
            x.setNombre(i.getNombre());
            x.setCantidadStock(i.getCantidadStock());
            x.setStockMinimo(i.getStockMinimo());
            RepositorioUnidadMedida rs = new RepositorioUnidadMedida();
            int idUm = rs.buscarIDUnidadMedida(i.getUnidadMedida().getNombre());
            x.setIdUnidadMedida(idUm);
            entityManager.merge(x);
        }
    }

    public void AnularMovimiento(int id) {
        InsumoDAO x = entityManager.find(InsumoDAO.class, id);
        if (x != null){
            x.darDeBaja();
            entityManager.merge(x);
        }
    }
    */
}
