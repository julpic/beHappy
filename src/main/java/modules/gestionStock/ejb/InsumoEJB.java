package modules.gestionStock.ejb;

import modules.gestionStock.dbEntities.InsumoDB;
import modules.gestionStock.modelEntities.Insumo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class InsumoEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public Insumo buscarInsumo(int id){
        InsumoDB iDao = entityManager.find(InsumoDB.class, id);
        UnidadMedidaEJB rs = new UnidadMedidaEJB();
        return iDao.getInsumo(rs.buscarUnidadMedida(iDao.getIdUnidadMedida()));
    }

    public List<Insumo> buscarInsumos() {
        List<InsumoDB> insumosDAO = entityManager.createQuery("SELECT i FROM InsumoDB i WHERE i.alta = true").getResultList();
        ArrayList<Insumo> insumos = new ArrayList<Insumo>();
        UnidadMedidaEJB rs = new UnidadMedidaEJB();
        for(InsumoDB iDAO: insumosDAO){
            insumos.add(iDAO.getInsumo(rs.buscarUnidadMedida(iDAO.getIdUnidadMedida())));
        }
        return insumos;
    }

    public List<Insumo> buscarInsumosConStockInsuficiente(){
        List<InsumoDB> insumosDAO = entityManager.createQuery("SELECT i FROM InsumoDB i WHERE i.cantidadStock <= i.stockMinimo").getResultList();
        ArrayList<Insumo> insumos = new ArrayList<Insumo>();
        UnidadMedidaEJB rs = new UnidadMedidaEJB();
        for(InsumoDB iDAO: insumosDAO){
            insumos.add(iDAO.getInsumo(rs.buscarUnidadMedida(iDAO.getIdUnidadMedida())));
        }
        return insumos;
    }

    public void crearInsumo(Insumo i) {
        if (entityManager.find(InsumoDB.class, i.getIdInsumo()) == null) {
            InsumoDB iDao = new InsumoDB(i);
            entityManager.persist(iDao);
        }
    }

    public void modificarInsumo(int id, Insumo i) {
        InsumoDB x = entityManager.find(InsumoDB.class, id);
        if (x != null) {
            x.setNombre(i.getNombre());
            x.setCantidadStock(i.getCantidadStock());
            x.setStockMinimo(i.getStockMinimo());
            UnidadMedidaEJB rs = new UnidadMedidaEJB();
            int idUm = rs.buscarIDUnidadMedida(i.getUnidadMedida().getNombre());
            x.setIdUnidadMedida(idUm);
            entityManager.merge(x);
        }
    }

    public void eliminarInsumo(int id) {
        InsumoDB x = entityManager.find(InsumoDB.class, id);
        if (x != null){
            x.darDeBaja();
            entityManager.merge(x);
        }
    }
}
