package modules.gestionFranquicias.ejb;

import modules.gestionFranquicias.dbEntities.InsumosXProveedor;
import modules.gestionFranquicias.dbEntities.Proveedor;
import utilities.GeneradorID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProveedorEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    GeneradorID genID;

    public Proveedor find(long id) {
        return entityManager.find(Proveedor.class, id);
    }

    public List<Proveedor> findAll() {
        Query q = entityManager.createQuery("SELECT i from Proveedor i");
        return q.getResultList();
    }

    public List<Proveedor> findAll(long idExterno, boolean insumo) {
        Query q;
        if (insumo) {
            q = entityManager.createQuery("SELECT i FROM Proveedor i, InsumosXProveedor ip WHERE i.idProveedor = ip.idProveedor AND ip.idInsumo = :idInsumo")
                    .setParameter("idInsumo", idExterno);
        } else {
            q = entityManager.createQuery("SELECT i FROM Proveedor i, ProveedoresXFranquica pf WHERE i.idProveedor = pf.idProveedor AND pf.idFranquicia = :idFranquicia")
                    .setParameter("idFranquicia", idExterno);
        }
        return q.getResultList();
    }

    public void create(Proveedor p) {
        p.setIdProveedor(buscarNuevoID());
        entityManager.persist(p);
    }

    public Long buscarUltimoID(){
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(p.idProveedor) FROM Proveedor p");
        if(q.getSingleResult() == null){
            return (long) 0;
        }
        return q.getSingleResult();
    }

    public Long buscarNuevoID(){
        return genID.buscarID(buscarUltimoID());
    }

    public boolean create(long idInsumo, long idProveedor) {
        InsumosXProveedor ixp = new InsumosXProveedor();
        ixp.setIdInsumo(idInsumo);
        ixp.setIdProveedor(idProveedor);
        InsumosXProveedor x = entityManager.find(InsumosXProveedor.class, ixp);
        if (x == null) {
            entityManager.persist(ixp);
            return true;
        }
        return false;
    }

    public void update(long id, Proveedor p) {
        Proveedor x = entityManager.find(Proveedor.class, id);
        if (x != null) {
            x.setCuit(p.getCuit());
            x.seteMail(p.geteMail());
            x.setRazonSocial(p.getRazonSocial());
            x.setTelefonoContacto(p.getTelefonoContacto());
            entityManager.merge(x);
        }
    }

    public void remove(long id) {
        Proveedor x = entityManager.find(Proveedor.class, id);
        if (x != null) {
            x.setAlta(false);
            entityManager.merge(x);
        }
    }
}
