package daos.gestionStockDAO.repositorios;

import daos.gestionStockDAO.services.InsumoDAO;
import entities.gestionStock.Insumo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RepositorioInsumo {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public Insumo buscarInsumo(int id){
        InsumoDAO iDao = entityManager.find(InsumoDAO.class, id);
        return iDao.getInsumo();
    }

    public List<Insumo> buscarInsumos() {
        List<InsumoDAO> insumosDAO = entityManager.createQuery("SELECT i FROM Insumos i").getResultList();
        ArrayList<Insumo> insumos = new ArrayList<Insumo>();
        for(InsumoDAO iDAO: insumosDAO){
            insumos.add(iDAO.getInsumo());
        }
        return insumos;
    }

    public void crearInsumo(Insumo i) {
        if (entityManager.find(InsumoDAO.class, i.getIdInsumo()) == null) {
            InsumoDAO iDao = new InsumoDAO(i);
            entityManager.persist(iDao);
        }
    }

    public void modificarInsumo(int id, Insumo i) {
        Insumo x = entityManager.find(Insumo.class, id);
        if (x != null) {

            x.setNombre(i.getNombre());
            x.setCantidadStock(i.getCantidadStock());
            entityManager.merge(x);
        }
    }

    public void eliminarInsumo(int id) {
        InsumoDAO x = entityManager.find(InsumoDAO.class, id);
        if (x != null){
            x.darDeBaja();
            entityManager.merge(x);
        }
    }
}
