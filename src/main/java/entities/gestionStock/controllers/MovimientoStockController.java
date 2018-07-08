package entities.gestionStock.controllers;

import daos.gestionStockDAO.repositorios.RepositorioMovimientoStock;
import entities.gestionStock.DetalleMovimientoStock;
import entities.gestionStock.MovimientoStock;

import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

@Stateless
public class MovimientoStockController {
    RepositorioMovimientoStock rms = new RepositorioMovimientoStock();


    public MovimientoStock find(int id) {
       return rms.buscarMovimientoStock(id);
    }

    public List<MovimientoStock> findAll() {
        return rms.buscarMovimientosStock();
    }

    public int create(MovimientoStock ms) {
        return rms.crearMovimientoStock(ms);
    }

    public void remove(int id) {
        MovimientoStock actual = find(id);
        boolean entrada = actual.isEntrada();
        List<DetalleMovimientoStock> detalles = actual.getDetalles();

        revertirDetalles(detalles, entrada);
        actual.anular();
    }

    private void revertirDetalles(List<DetalleMovimientoStock> detalles, boolean entrada) {
        DetalleMovimientoStockController detalleController = new DetalleMovimientoStockController();
        for (DetalleMovimientoStock d : detalles) {
            detalleController.remove(d, entrada);
        }
    }
}
