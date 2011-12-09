package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Kommentar extends Beitrag implements Serializable {

    @Id
    @GeneratedValue (strategy= GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    private Beitrag beitrag;

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
     * @return the beitrag
     */
    public Beitrag getBeitrag() {
        return beitrag;
    }

    /**
     * @param beitrag the beitrag to set
     */
    public void setBeitrag(Beitrag beitrag) {
        this.beitrag = beitrag;
    }

}