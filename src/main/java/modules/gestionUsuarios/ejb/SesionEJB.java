package modules.gestionUsuarios.ejb;

import modules.gestionUsuarios.dbEntities.Sesion;
import utilities.GeneradorID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

@Stateless
public class SesionEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    GeneradorID genID;


    public Sesion find(long id) {
        return entityManager.find(Sesion.class, id);
    }

    public List<Sesion> findAll() {
        Query q = entityManager.createQuery("SELECT s FROM Sesion s");
        return q.getResultList();
    }

    public long create(Sesion s) {
        if(haySesionIniciada()){
            return -1;
        }else{
            s.setIdSesion(buscarNuevoID());
            entityManager.persist(s);
            return s.getIdSesion();
        }
    }

    public boolean haySesionIniciada(){
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(s.idSesion) FROM Sesion s WHERE s.fechaHoraFin = :NULL");
        if(q.getSingleResult() == null){
            return true;
        }
        return false;
    }

    public Sesion sesionIniciada(){
        TypedQuery<Sesion> q = (TypedQuery<Sesion>) entityManager.createQuery("SELECT s FROM Sesion s WHERE s.fechaHoraFin = :NULL");
        return q.getSingleResult();
    }

    public long buscarNuevoID(){
        return genID.buscarID(buscarUltimoID());
    }

    private long buscarUltimoID() {
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(s.idSesion) FROM Sesion s");
        if(q.getSingleResult() == null){
            return 0;
        }
        return q.getSingleResult();
    }

    public boolean cancel() {

        if(haySesionIniciada()){
            Sesion x = sesionIniciada();
            x.setFechaHoraFin(new Timestamp(System.currentTimeMillis()));
            entityManager.merge(x);
            return true;
        }
        return false;
    }
}
