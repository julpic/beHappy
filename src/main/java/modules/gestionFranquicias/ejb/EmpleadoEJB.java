package modules.gestionFranquicias.ejb;

import modules.gestionFranquicias.dbEntities1.Empleado;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class EmpleadoEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    public Empleado find(int id) {
        TypedQuery<Empleado> q = (TypedQuery) entityManager.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado = :id").setParameter("id",id);
        return q.getSingleResult();
    }

    public List<Empleado> findAll() {
        Query q = entityManager.createQuery("SELECT e FROM Empleado e WHERE e.alta = true");
        return q.getResultList();
    }

    public void create(Empleado e) {
        Query q = entityManager.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado = :id").setParameter("id",e.getIdEmpleado());
        if ( q.getResultList().isEmpty()) {
            entityManager.persist(e);
        }
    }


    public void update(int id, Empleado e) {
        TypedQuery<Empleado> q = (TypedQuery) entityManager.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado = :id").setParameter("id",id);
        Empleado x = q.getSingleResult();
        if (x != null) {
            x.setIdFranquicia(e.getIdFranquicia());
            x.setApellido(e.getApellido());
            x.setDni(e.getDni());
            x.seteMail(e.geteMail());
            x.setFechaNacimiento(e.getFechaNacimiento());
            x.setNombre(e.getNombre());
            x.setTelefonoContacto(e.getTelefonoContacto());
            x.setAlta(e.getAlta());
            entityManager.merge(x);

        }
    }

    public void remove(int id) {
        TypedQuery<Empleado> q = (TypedQuery) entityManager.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado = :id").setParameter("id",id);
        Empleado x = q.getSingleResult();
        if (x != null) {
            x.darDeBaja();
            entityManager.merge(x);
        }
    }
}
