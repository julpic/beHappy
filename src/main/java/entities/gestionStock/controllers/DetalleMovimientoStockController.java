package entities.gestionStock.controllers;

import entities.gestionStock.DetalleMovimientoStock;
import entities.gestionStock.Insumo;

import javax.ejb.Stateless;

@Stateless
public class DetalleMovimientoStockController {
/*
    public List<DetalleMovimientoStockDAO> find(int idMovimiento) {
        Query q = entityManager.createQuery("SELECT i FROM DetalleMovimientoStockDAO i WHERE i.idMovimiento = :idMov")
                .setParameter("idMov", idMovimiento);
        return  q.getResultList();
    }

    public void create(List<DetalleMovimientoStockDAO> detalles) {
        int idDetalle = 0;
        for (DetalleMovimientoStockDAO d : detalles){
            d.setIdDetalleMovimientoStock(idDetalle);
            idDetalle ++;
                entityManager.persist(d);
        }
    }
*/
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
