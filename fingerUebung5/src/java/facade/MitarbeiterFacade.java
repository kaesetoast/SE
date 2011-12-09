/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Mitarbeiter;

/**
 *
 * @author batzen
 */
@Stateless
public class MitarbeiterFacade extends AbstractFacade<Mitarbeiter> {
    @PersistenceContext(unitName = "finger5PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MitarbeiterFacade() {
        super(Mitarbeiter.class);
    }
    
}
