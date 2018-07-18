package modules.gestionUsuarios.ejb;

import modules.gestionFranquicias.dbEntities.Empleado;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UsuarioEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public Empleado find(int id) {
        return entityManager.find(Empleado.class, id);
    }

    public List<Empleado> findAll() {
        Query q = entityManager.createQuery("SELECT u FROM Empleado e, Usuario u WHERE e.idEmpleado = u.idEmpleado AND " +
                "e.idFranquicia = u.idFranquicia AND e.alta = true");
        return q.getResultList();
    }

}
