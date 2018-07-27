package modules.gestionUsuarios.ejb;

import modules.gestionUsuarios.dbEntities.Sesion;
import utilities.GeneradorID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Stateless
public class SesionEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;
    @Inject
    GeneradorID genID;
    @Inject
    TurnoEJB turnoEJB;


    public Sesion find(long id) {
        return entityManager.find(Sesion.class, id);
    }

    public List<Sesion> findAll() {
        Query q = entityManager.createQuery("SELECT s FROM Sesion s");
        return q.getResultList();
    }

    public List<Sesion> findAll(long idUsuario) {
        Query q = entityManager.createQuery("SELECT s FROM Sesion s WHERE s.idUsuario = :idUsuario")
                .setParameter("idUsuario", idUsuario);
        return q.getResultList();
    }

    public void create(Sesion s) {
        entityManager.persist(s);
    }


    public Sesion sesionIniciada() {
        Query q = entityManager.createQuery("SELECT s FROM Sesion s WHERE s.fechaHoraFin IS NULL");
        Sesion s;
        try {
            s = (Sesion) q.getSingleResult();
        } catch (NoResultException e) {
            s = null;
        }
        return s;
    }

    public long buscarNuevoID() {
        return genID.buscarID(buscarUltimoID());
    }

    private long buscarUltimoID() {
        TypedQuery<Long> q = (TypedQuery<Long>) entityManager.createQuery("SELECT MAX(s.idSesion) FROM Sesion s");
        if (q.getSingleResult() == null) {
            return 0;
        }
        return q.getSingleResult();
    }

    public void cancel() {
        Sesion x = sesionIniciada();
        x.setFechaHoraFin(new Timestamp(System.currentTimeMillis()));
        entityManager.merge(x);

    }
}
