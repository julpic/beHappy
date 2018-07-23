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

    public boolean create(Usuario u) {
        if (!nombreExiste(u.getUsuario())) {
            u.setIdUsuario(buscarNuevoID());
            entityManager.persist(u);
            return true;
        }
        return false;
    }

    public boolean nombreExiste(String usuario){
        Query q = entityManager.createQuery("SELECT u FROM Empleado e, Usuario u WHERE :nombre = u.usuario AND " +
                "e.alta = TRUE").setParameter("nombre", usuario);
        if (q == null){
            return true;
        }
        return false;
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

    public void update(long id, Usuario u) {
        Usuario x = entityManager.find(Usuario.class, id);
        if (x != null) {
            x.setUsuario(u.getUsuario());
            x.setPassword(u.getPassword());
            entityManager.merge(x);
        }
    }

}
