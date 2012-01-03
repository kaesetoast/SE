/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.IdeeFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Idee;

/**
 *
 * @author batzen
 */

@ManagedBean(name = "ideenpoolController")
@SessionScoped
public class IdeenpoolController implements Serializable {
    @EJB
    private IdeeFacade ideeFacade;

    public IdeenpoolController() {
    }

    private IdeeFacade getFacade() {
        return ideeFacade;
    }

    public List<Idee> getItems() {
        List<Idee> ideen = ideeFacade.findAll();
        return ideen;
    }
}
