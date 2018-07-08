package entities.gestionStock.controllers;

import entities.gestionStock.DetalleMovimientoStock;
import entities.gestionStock.Insumo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DetalleMovimientoStockController {
/*
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public List<DetalleMovimientoStock> find(int idMovimiento) {
        Query q = entityManager.createQuery("SELECT i FROM DetalleMovimientoStock i WHERE i.idMovimiento = :idMov")
                .setParameter("idMov", idMovimiento);
        return  q.getResultList();
    }

    public void create(List<DetalleMovimientoStock> detalles) {
        int idDetalle = 0;
        for (DetalleMovimientoStock d : detalles){
            d.setIdDetalleMovimientoStock(idDetalle);
            idDetalle ++;
                entityManager.persist(d);
        }
    }

    public void remove(DetalleMovimientoStock d, boolean entrada) {
            Insumo insumoACambiar = buscarInsumo(d);
            insumoACambiar.cancelarMovimiento(d.getCantidad(), entrada);
            entityManager.merge(insumoACambiar);
    }

    private Insumo buscarInsumo(DetalleMovimientoStock detalle){
        int idInsumo = detalle.getInsumo().getIdInsumo();
        return entityManager.find(Insumo.class, idInsumo);
    }


*/

}
