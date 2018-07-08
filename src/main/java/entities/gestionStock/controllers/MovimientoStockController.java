package entities.gestionStock.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Stateless
public class MovimientoStockController {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    //Se debe devolver el movimiento solicitado junto con sus correspondientes detalles
    //Ver que el metodo siguiente lo cumpla
    public MovimientoStock find(int id) {
        MovimientoStock actual = entityManager.find(MovimientoStock.class, id);
        List<DetalleMovimientoStock> detalles = buscarDetalles(actual.getIdMovimientoStock());

        for (DetalleMovimientoStock d: detalles) {
            actual.addDetalle(d);
        }
        return actual;
    }

    private List<DetalleMovimientoStock> buscarDetalles(int idMovimiento){
        DetalleMovimientoStockController detalleController = new DetalleMovimientoStockController();
        return  detalleController.find(idMovimiento);
    }

    //Se deben devolver los movimientos junto con sus correspondientes detalles
    //Ver que el metodo siguiente lo cumpla
    public List<MovimientoStock> findAll() {
        List<MovimientoStock> movimientos = entityManager.createQuery("SELECT i FROM MovimientoStock i").getResultList();
        for (MovimientoStock m: movimientos) {
            List<DetalleMovimientoStock> detalles = buscarDetalles(m.getIdMovimientoStock());
            for (DetalleMovimientoStock d: detalles) {
                m.addDetalle(d);
            }
        }
        return movimientos;
    }

    //Cuando se creen los movimientos tambien se deben crear sus detalles
    //Retorna el numero de movimiento para luego poder hacer los detalles
    public int create(MovimientoStock ms) {
        int idMovimiento = buscarUltimoID() + 1;
        ms.setIdMovimientoStock(idMovimiento);
        if (entityManager.find(MovimientoStock.class, ms.getIdMovimientoStock()) == null){
            entityManager.persist(ms);
        }
        return idMovimiento;
    }

    private int buscarUltimoID(){
        Query q = entityManager.createQuery("SELECT MAX(i.idMovimiento) FROM DetalleMovimientoStock i");
        return (Integer) q.getSingleResult();

    }

    //Cambiar para que el remove haga un set con la fecha actual a la columna FechaAnulacion y que recorran todos los detalles
    //Cuando se recorren los detalles se debe deshacer el movimiento, para eso se ve si el movimiento es una entrada o salida
    //Revisar este metodo
    public void remove(int id) {
        MovimientoStock actual = find(id);
        boolean entrada = actual.getEntrada();
        List<DetalleMovimientoStock> detalles = buscarDetalles(actual.getIdMovimientoStock());

        revertirDetalles(detalles, entrada);

        Date date = new Date();
        Timestamp fechaAnulacion = new Timestamp(date.getTime());
        actual.setFechaHoraAnulacion(fechaAnulacion);
        entityManager.merge(actual);
    }

    private void revertirDetalles(List<DetalleMovimientoStock> detalles, boolean entrada){
        DetalleMovimientoStockController detalleController = new DetalleMovimientoStockController();

        for (DetalleMovimientoStock d: detalles) {
            detalleController.remove(d, entrada);
        }
    }

}
