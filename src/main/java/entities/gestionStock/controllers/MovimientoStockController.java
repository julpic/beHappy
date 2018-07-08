package entities.gestionStock.controllers;

import javax.ejb.Stateless;

@Stateless
public class MovimientoStockController {
/*    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    //Se debe devolver el movimiento solicitado junto con sus correspondientes detalles
    //Ver que el metodo siguiente lo cumpla
    public MovimientoStockDAO find(int id) {
        MovimientoStockDAO actual = entityManager.find(MovimientoStockDAO.class, id);
        List<DetalleMovimientoStockDAO> detalles = buscarDetalles(actual.getIdMovimientoStock());

        for (DetalleMovimientoStockDAO d : detalles) {
            actual.addDetalle(d);
        }
        return actual;
    }

    private List<DetalleMovimientoStockDAO> buscarDetalles(int idMovimiento) {
        DetalleMovimientoStockController detalleController = new DetalleMovimientoStockController();
        return detalleController.find(idMovimiento);
    }

    //Se deben devolver los movimientos junto con sus correspondientes detalles
    //Ver que el metodo siguiente lo cumpla
    public List<MovimientoStockDAO> findAll() {
        List<MovimientoStockDAO> movimientos = entityManager.createQuery("SELECT i FROM MovimientoStockDAO i").getResultList();
        for (MovimientoStockDAO m : movimientos) {
            List<DetalleMovimientoStockDAO> detalles = buscarDetalles(m.getIdMovimientoStock());
            for (DetalleMovimientoStockDAO d : detalles) {
                m.addDetalle(d);
            }
        }
        return movimientos;
    }

    //Cuando se creen los movimientos tambien se deben crear sus detalles
    //Retorna el numero de movimiento para luego poder hacer los detalles
    public int create(MovimientoStockDAO ms) {
        int idMovimiento = buscarUltimoID() + 1;
        ms.setIdMovimientoStock(idMovimiento);
        if (entityManager.find(MovimientoStockDAO.class, ms.getIdMovimientoStock()) == null) {
            entityManager.persist(ms);
        }
        return idMovimiento;
    }

    private int buscarUltimoID() {
        Query q = entityManager.createQuery("SELECT MAX(i.idMovimiento) FROM DetalleMovimientoStockDAO i");
        return (Integer) q.getSingleResult();

    }

    //Cambiar para que el remove haga un set con la fecha actual a la columna FechaAnulacion y que recorran todos los detalles
    //Cuando se recorren los detalles se debe deshacer el movimiento, para eso se ve si el movimiento es una entrada o salida
    //Revisar este metodo
    public void remove(int id) {
        MovimientoStockDAO actual = find(id);
        boolean entrada = actual.getEntrada();
        List<DetalleMovimientoStockDAO> detalles = buscarDetalles(actual.getIdMovimientoStock());

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
        }
    }*/

}
