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
    @GeneratedValue (strategy= GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String abteilung;
    private int personalnr;
    @OneToOne
    private Mitarbeiterbild bild;
    @OneToMany (mappedBy="autor")
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
}