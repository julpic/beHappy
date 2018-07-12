package modules.gestionFranquicias.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProveedorEJB {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

}
