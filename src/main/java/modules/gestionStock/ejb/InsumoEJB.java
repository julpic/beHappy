package modules.gestionStock.ejb;

import modules.gestionFranquicias.ejb.FranquiciaEJB;
import modules.gestionStock.dbEntities.Insumo;
import utilities.GeneradorID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class InsumoEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    GeneradorID genID;

    public Insumo find(long id) {
        return entityManager.find(Insumo.class, id);
    }

    public List<Insumo> findAll() {
        Query q = entityManager.createQuery("SELECT i FROM Insumo i WHERE i.alta = true");
        return q.getResultList();
    }

    public List<Insumo> findAll(long idProveedor) {
        Query q = entityManager.createQuery("SELECT i FROM Insumo i , InsumosXProveedor ip WHERE i.idInsumo = ip.idInsumo AND i.alta = true AND ip.idProveedor = :idProveedor")
                .setParameter("idProveedor", idProveedor);
        return q.getResultList();
    }

    public List<Insumo> findInsStock() {
        Query q = entityManager.createQuery("SELECT i FROM Insumo i WHERE i.cantidadStock <= i.stockMinimo");
        return q.getResultList();
    }

    public void create(Insumo i) {
        i.setIdInsumo(buscarNuevoID());
        if (entityManager.find(Insumo.class, i.getIdInsumo()) == null) {
            entityManager.persist(i);
        }
    }

    public long buscarNuevoID(){
        return genID.buscarID(buscarUltimoID());
    }

    private long buscarUltimoID() {
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(i.idInsumo) FROM Insumo i");
        if(q.getSingleResult() == null){
            return 0;
        }
        return q.getSingleResult();
    }


    public void update(long id, Insumo i) {
        Insumo x = entityManager.find(Insumo.class, id);
        if (x != null) {
            x.setNombre(i.getNombre());
            x.setCantidadStock(i.getCantidadStock());
            x.setStockMinimo(i.getStockMinimo());
            x.setIdUnidadMedida(i.getIdUnidadMedida());
            entityManager.merge(x);
        }
    }

    public void remove(long id) {
        Insumo x = entityManager.find(Insumo.class, id);
        if (x != null) {
            x.darDeBaja();
            entityManager.merge(x);
        }
    }

    public void updateStock(long idInsumo, int cantidad, boolean entrada) {
        Insumo i = find(idInsumo);
        if (entrada) {
            i.setCantidadStock(i.getCantidadStock() + cantidad);
        } else {
            i.setCantidadStock(i.getCantidadStock() - cantidad);
        }
        entityManager.merge(i);
    }
}
