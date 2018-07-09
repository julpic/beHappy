package modules.gestionStock.ejb;

import modules.gestionStock.modelEntities.DetalleMovimientoStock;
import modules.gestionStock.modelEntities.Insumo;
import modules.gestionStock.modelEntities.MovimientoStock;
import modules.gestionStock.modelEntities.UnidadMedida;

import javax.persistence.PersistenceContext;
import java.util.List;

public class StockEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")


    //Accesos a la base de datos pertinentes al Insumo
    public Insumo buscarInsumo(int id) {
        InsumoEJB ri = new InsumoEJB();
        return ri.buscarInsumo(id);
    }

    public List<Insumo> buscarInsumos() {
        InsumoEJB ri = new InsumoEJB();
        return ri.buscarInsumos();
    }

    public List<Insumo> buscarInsumosConStockInsuficiente() {
        InsumoEJB ri = new InsumoEJB();
        return ri.buscarInsumosConStockInsuficiente();
    }


    public void crearInsumo(Insumo i) {
        InsumoEJB ri = new InsumoEJB();
        ri.crearInsumo(i);
    }

    public void modificarInsumo(int id, Insumo i) {
        InsumoEJB ri = new InsumoEJB();
        ri.modificarInsumo(id, i);
    }

    public void eliminarInsumo(int id) {
        InsumoEJB ri = new InsumoEJB();
        ri.eliminarInsumo(id);
    }

    //Accesos a la base de datos pertinentes a la UnidadMedida
    public UnidadMedida buscarUnidadMedida(int id) {
        UnidadMedidaEJB rum = new UnidadMedidaEJB();
        return rum.buscarUnidadMedida(id);
    }

    public List<UnidadMedida> buscarUnidadesMedida() {
        UnidadMedidaEJB rum = new UnidadMedidaEJB();
        return rum.buscarUnidadesMedida();
    }

    public void crearUnidadMedida(UnidadMedida um) {
        UnidadMedidaEJB rum = new UnidadMedidaEJB();
        rum.crearUnidadMedida(um);
    }

    public void modificarUnidadMedida(int id, UnidadMedida um) {
        UnidadMedidaEJB rum = new UnidadMedidaEJB();
        rum.modificarUnidadMedida(id, um);
    }

    //Accesos a la base de datos pertinentes al Movimiento de Stock
    public MovimientoStock buscarMovimientoStock(int id) {
        MovimientoStockEJB rms = new MovimientoStockEJB();
        return rms.buscarMovimientoStock(id);
    }

    public List<MovimientoStock> buscarMovimientosStock() {
        MovimientoStockEJB rms = new MovimientoStockEJB();
        return rms.buscarMovimientosStock();
    }

    public int crearMovimientoStock(MovimientoStock ms) {
        MovimientoStockEJB rms = new MovimientoStockEJB();
        return rms.crearMovimientoStock(ms);
    }

    //Accesos a la base de datos pertinentes a los detalles
    public void crearDetallesMovimientoStock(List<DetalleMovimientoStock> detalles, int idMovimiento) {
        DetalleMovimientoStockEJB rDet = new DetalleMovimientoStockEJB();
        rDet.crearDetallesDeUnMovimiento(idMovimiento, detalles);
    }


}
