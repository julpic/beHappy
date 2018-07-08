package daos.gestionStockDAO.repositorios;

import entities.gestionStock.Insumo;
import entities.gestionStock.MovimientoStock;
import entities.gestionStock.UnidadMedida;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class RepositorioStock {
    @PersistenceContext(name = "beFruitPersistenceUnit")


    //Accesos a la base de datos pertinentes al Insumo
    public Insumo buscarInsumo(int id){
        RepositorioInsumo ri = new RepositorioInsumo();
        return ri.buscarInsumo(id);
    }

    public List<Insumo> buscarInsumos(){
        RepositorioInsumo ri = new RepositorioInsumo();
        return ri.buscarInsumos();
    }


    public void crearInsumo(Insumo i) {
        RepositorioInsumo ri = new RepositorioInsumo();
        ri.crearInsumo(i);
    }

    public void modificarInsumo(int id, Insumo i) {
        RepositorioInsumo ri = new RepositorioInsumo();
        ri.modificarInsumo(id,i);
    }

    public void eliminarInsumo(int id) {
        RepositorioInsumo ri = new RepositorioInsumo();
        ri.eliminarInsumo(id);
    }

    //Accesos a la base de datos pertinentes a la UnidadMedida
    public UnidadMedida buscarUnidadMedida(int id){
        RepositorioUnidadMedida rum = new RepositorioUnidadMedida();
        return rum.buscarUnidadMedida(id);
    }

    public void crearUnidadMedida(UnidadMedida um) {
        RepositorioUnidadMedida rum = new RepositorioUnidadMedida();
        rum.crearUnidadMedida(um);
    }

    public void modificarUnidadMedida(int id,  UnidadMedida um) {
        RepositorioUnidadMedida rum = new RepositorioUnidadMedida();
        rum.modificarUnidadMedida(id, um);
    }

    //Accesos a la base de datos pertinentes al Movimiento de Stock
    public MovimientoStock buscarMovimientoStock(int id){
        RepositorioMovimientoStock rms = new RepositorioMovimientoStock();
        return rms.buscarMovimientoStock(id);
    }

    public List<MovimientoStock> buscarMovimientosStock() {
        RepositorioMovimientoStock rms = new RepositorioMovimientoStock();
        return rms.buscarMovimientosStock();
    }

    public int crearMovimientoStock(MovimientoStock ms) {
        RepositorioMovimientoStock rms = new RepositorioMovimientoStock();
        return rms.crearMovimientoStock(ms);
    }



}
