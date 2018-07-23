package modules.gestionUsuarios.ejb;

import modules.gestionFranquicias.dbEntities.Empleado;
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
public class UsuarioEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    GeneradorID genID;

    public Usuario find(long id) {
        return entityManager.find(Usuario.class, id);
    }

    public Usuario find(Empleado e){
        Query q = entityManager.createQuery("SELECT u FROM Empleado e, Usuario u WHERE :idEmpleado = u.idEmpleado AND " +
                ":idFranquicia = u.idFranquicia").setParameter("idEmpleado", e.getIdEmpleado())
                .setParameter("idFranquicia", e.getIdFranquicia());
        return (Usuario) q.getSingleResult();
    }

    public List<Usuario> findAll() {
        Query q = entityManager.createQuery("SELECT u FROM Empleado e, Usuario u WHERE e.idEmpleado = u.idEmpleado AND " +
                "e.idFranquicia = u.idFranquicia AND e.alta = true");
        return q.getResultList();
    }

    public void create(Usuario u) {
        u.setIdUsuario(buscarNuevoID());
        if (entityManager.find(Usuario.class, u.getIdUsuario()) == null) {
            entityManager.persist(u);
        }
    }

    public long buscarNuevoID(){
        return genID.buscarID(buscarUltimoID());
    }

    private long buscarUltimoID() {
        TypedQuery<Integer> q = (TypedQuery<Integer>) entityManager.createQuery("SELECT MAX(u.idUsuario) FROM Usuario u");
        if(q.getSingleResult() == null){
            return 0;
        }
        return (Integer) q.getSingleResult();
    }

}
