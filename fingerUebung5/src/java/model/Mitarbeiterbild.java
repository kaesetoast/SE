/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author batzen
 */
@Entity
public class Mitarbeiterbild extends Bild implements Serializable {

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (id != null ? id.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Mitarbeiterbild)) {
	    return false;
	}
	Mitarbeiterbild other = (Mitarbeiterbild) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "model.Mitarbeiterbild[ id=" + id + " ]";
    }
}
