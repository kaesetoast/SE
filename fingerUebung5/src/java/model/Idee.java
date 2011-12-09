package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Idee extends Beitrag implements Serializable {

    @Id
    @GeneratedValue (strategy= GenerationType.SEQUENCE)
    private long id;
    @OneToMany
    private Collection<Anhang> myAnhaenge;

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
     * @return the myAnhaenge
     */
    public Collection<Anhang> getMyAnhaenge() {
        return myAnhaenge;
    }

    /**
     * @param myAnhaenge the myAnhaenge to set
     */
    public void setMyAnhaenge(Collection<Anhang> myAnhaenge) {
        this.myAnhaenge = myAnhaenge;
    }
}