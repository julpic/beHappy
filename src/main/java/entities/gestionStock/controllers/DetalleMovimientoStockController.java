package entities.gestionStock.controllers;

import javax.ejb.Stateless;

@Stateless
public class DetalleMovimientoStockController {
/*
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

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

    public void remove(DetalleMovimientoStockDAO d, boolean entrada) {
            Insumo insumoACambiar = buscarInsumo(d);
            insumoACambiar.cancelarMovimiento(d.getCantidad(), entrada);
            entityManager.merge(insumoACambiar);
    }

    private Insumo buscarInsumo(DetalleMovimientoStockDAO detalle){
        int idInsumo = detalle.getInsumo().getIdInsumo();
        return entityManager.find(Insumo.class, idInsumo);
    }


*/

}
