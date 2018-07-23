package modules.gestionUsuarios.ejb;

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
}
