package modules.gestionUsuarios.ejb;

import modules.gestionUsuarios.dbEntities.Perfil;
import modules.gestionUsuarios.dbEntities.Usuario;
import utilities.GeneradorID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PerfilEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    @Inject
    GeneradorID genID;

    public Perfil find(long id) {
        return entityManager.find(Perfil.class, id);
    }

    public Perfil find(Usuario u){
        Query q = entityManager.createQuery("SELECT p FROM Perfil p, PerfilesXUsuarios pxu WHERE p.idPerfil = pxu.idPerfil AND " +
                ":idUsuario = pxu.idUsuario").setParameter("idUsuario", u.getIdUsuario());
        return (Perfil) q.getSingleResult();
    }

    public List<Perfil> findAll() {
        Query q = entityManager.createQuery("SELECT p FROM Perfil p");
        return q.getResultList();
    }

    public boolean create(Perfil p) {
        if (!nombreExiste(p.getNombre())) {
            p.setIdPerfil(buscarNuevoID());
            entityManager.persist(p);
            return true;
        }
        return false;
    }

    public boolean nombreExiste(String nombre){
        Query q = entityManager.createQuery("SELECT p FROM Perfil p WHERE :nombre = p.nombre")
                .setParameter("nombre", nombre);
        if (q == null){
            return true;
        }
        return false;
    }

    public long buscarNuevoID(){
        return genID.buscarID(buscarUltimoID());
    }

    private long buscarUltimoID() {
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(p.idPerfil) FROM Perfil p");
        if(q.getSingleResult() == null){
            return 0;
        }
        return q.getSingleResult();
    }

    public boolean update(long id, Perfil p) {
        Perfil x = entityManager.find(Perfil.class, id);
        if (x != null) {
            x.setNombre(p.getNombre());
            entityManager.merge(x);
            return true;
        }
        return false;
    }
}
