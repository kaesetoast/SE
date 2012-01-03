/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Idee;
import model.Kommentar;

/**
 *
 * @author batzen
 */
@Stateless
public class KommentarFacade extends AbstractFacade<Kommentar> {

    @PersistenceContext(unitName = "finger5PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public KommentarFacade() {
        super(Kommentar.class);
    }

    public List<Kommentar> findByIdee(Idee idee) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Kommentar> root = cq.from(Kommentar.class);
        cq.select(root);
        cq.where(cb.equal(root.get("myKommentare"), cq));
        Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }
}
