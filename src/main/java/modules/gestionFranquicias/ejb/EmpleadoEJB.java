package modules.gestionFranquicias.ejb;

import modules.gestionFranquicias.dbEntities.Empleado;
import utilities.GeneradorID;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class EmpleadoEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    GeneradorID genID;

    public Empleado find(long id) {
        TypedQuery<Empleado> q = (TypedQuery) entityManager.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado = :id").setParameter("id",id);
        return q.getSingleResult();
    }

    public List<Empleado> findAll() {
        Query q = entityManager.createQuery("SELECT e FROM Empleado e");
        return q.getResultList();
    }

    public List<Empleado> findAll(long idFranquicia) {
        Query q = entityManager.createQuery("SELECT e FROM Empleado e WHERE e.idFranquicia = :id")
                .setParameter("id", idFranquicia);
        return q.getResultList();
    }

    public Long buscarUltimoID(long idFranquicia){
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(e.idEmpleado) FROM Empleado e WHERE e.idFranquicia = :id")
                .setParameter("id", idFranquicia);
        if(q.getSingleResult() == null){
            return (long) 0;
        }
        return q.getSingleResult();
    }

    public Long buscarNuevoID(long idFranquicia){
        return genID.buscarID(buscarUltimoID(idFranquicia), idFranquicia);
    }


    public void create(Empleado e) {
        Query q = entityManager.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado = :id").setParameter("id",e.getIdEmpleado());
        if ( q.getResultList().isEmpty()) {
            e.setIdEmpleado(buscarNuevoID(e.getIdFranquicia()));
            entityManager.persist(e);
        }
    }


    public void update(long id, Empleado e) {
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

    public void remove(long id) {
        TypedQuery<Empleado> q = (TypedQuery) entityManager.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado = :id").setParameter("id",id);
        Empleado x = q.getSingleResult();
        if (x != null) {
            x.darDeBaja();
            entityManager.merge(x);
        }
    }
}
