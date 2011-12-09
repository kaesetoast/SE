/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Idee;

/**
 *
 * @author batzen
 */
@Stateless
public class IdeeFacade extends AbstractFacade<Idee> {
    @PersistenceContext(unitName = "finger5PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public IdeeFacade() {
        super(Idee.class);
    }
    
}
