package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Mitarbeiter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String abteilung;
    private int personalnr;
    @OneToOne
    private Mitarbeiterbild bild;
    // Bidirektional macht hier Sinn
    @OneToMany(mappedBy = "autor")
    private Collection<Beitrag> myBeitraege;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the abteilung
     */
    public String getAbteilung() {
        return abteilung;
    }

    /**
     * @param abteilung the abteilung to set
     */
    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    /**
     * @return the personalnr
     */
    public int getPersonalnr() {
        return personalnr;
    }

    /**
     * @param personalnr the personalnr to set
     */
    public void setPersonalnr(int personalnr) {
        this.personalnr = personalnr;
    }

    /**
     * @return the bild
     */
    public Mitarbeiterbild getBild() {
        return bild;
    }

    /**
     * @param bild the bild to set
     */
    public void setBild(Mitarbeiterbild bild) {
        this.bild = bild;
    }

    /**
     * @return the myBeitraege
     */
    public Collection<Beitrag> getMyBeitraege() {
        return myBeitraege;
    }

    /**
     * @param myBeitraege the myBeitraege to set
     */
    public void setMyBeitraege(Collection<Beitrag> myBeitraege) {
        this.myBeitraege = myBeitraege;
    }
    
    @Override
    public String toString () {
        return getName();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mitarbeiter) {
            Mitarbeiter ob = (Mitarbeiter) obj;
            if (ob.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }

}