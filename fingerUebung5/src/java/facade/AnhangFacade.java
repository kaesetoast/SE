/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Anhang;

/**
 *
 * @author batzen
 */
@Stateless
public class AnhangFacade extends AbstractFacade<Anhang> {
    @PersistenceContext(unitName = "finger5PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AnhangFacade() {
        super(Anhang.class);
    }
    
}
