/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.util.PaginationHelper;
import facade.IdeeFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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
    
    public String getItems() {
        List<Idee> ideen = ideeFacade.findAll();
        StringBuilder erg = new StringBuilder();
        erg.append("<table><thead><tr><th>Datum</th></tr></thead><tbody>");
        for (Idee idee : ideen) {
               erg.append("<tr><td>" + idee.getDatum().toString() + "</td></tr>");
        }
        erg.append("</tbody></table>");
        return erg.toString();
    }
    
}
