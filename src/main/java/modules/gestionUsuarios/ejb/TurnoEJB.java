package modules.gestionUsuarios.ejb;

import modules.gestionUsuarios.dbEntities.Turno;
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
public class TurnoEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    GeneradorID genID;
    @Inject
    SesionEJB sesionEJB;

    public Turno find(long id) {
        return entityManager.find(Turno.class, id);
    }

    public List<Turno> findAll() {
        Query q = entityManager.createQuery("SELECT t FROM Turno t");
        return q.getResultList();
    }

    public List<Turno> findAll(long idSesion) {
        Query q = entityManager.createQuery("SELECT t FROM Turno t WHERE t.idSesion = :idSesion")
                .setParameter("idSesion", idSesion);
        return q.getResultList();
    }

    public void create(Turno t) {
        entityManager.persist(t);
    }

    public boolean hayTurnoIniciado() {
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(t.idTurno) FROM Turno t WHERE t.fechaHoraFin = :NULL");
        if (q.getSingleResult() == null) {
            return true;
        }
        return false;
    }

    public Turno turnoIniciado() {
        TypedQuery<Turno> q = (TypedQuery<Turno>) entityManager.createQuery("SELECT t FROM Turno t WHERE t.fechaHoraFin = :NULL");
        return q.getSingleResult();
    }

    public long buscarNuevoID() {
        return genID.buscarID(buscarUltimoID());
    }

    private long buscarUltimoID() {
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(t.idTurno) FROM Turno t");
        if (q.getSingleResult() == null) {
            return 0;
        }
        return q.getSingleResult();
    }

    public void cancel() {
        Turno x = turnoIniciado();
        x.setFechaHoraFin(new Timestamp(System.currentTimeMillis()));
        entityManager.merge(x);
    }
}
