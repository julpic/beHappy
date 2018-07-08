package entities.gestionStock.controllers;

import daos.gestionStockDAO.repositorios.RepositorioStock;
import entities.gestionStock.DetalleMovimientoStock;
import entities.gestionStock.Insumo;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class DetalleMovimientoStockController {

    public void create(List<DetalleMovimientoStock> detalles, boolean entrada, int idMovimiento){
        RepositorioStock rs = new RepositorioStock();
        for(DetalleMovimientoStock det : detalles){
            det.getInsumo().registrarMovimiento(det.getCantidad(), entrada);
        }
        rs.crearDetallesMovimientoStock(detalles, idMovimiento);
    }

    public void remove(DetalleMovimientoStock d, boolean entrada) {
            Insumo insumoACambiar = buscarInsumo(d);
            insumoACambiar.cancelarMovimiento(d.getCantidad(), entrada);
            InsumoController ic = new InsumoController();
            ic.update(insumoACambiar.getIdInsumo(), insumoACambiar);
    }

    private Insumo buscarInsumo(DetalleMovimientoStock detalle){
        int idInsumo = detalle.getInsumo().getIdInsumo();
        InsumoController ic = new InsumoController();
        return ic.find(idInsumo);
    }




}
