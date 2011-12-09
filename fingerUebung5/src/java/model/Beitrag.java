package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Beitrag extends AbstractBeitrag implements Serializable {

    @OneToMany
    private Collection<Kommentar> myKommentare;
    @OneToMany
    private Collection<Bild> myBilder;

    /**
     * @return the myKommentare
     */
    public Collection<Kommentar> getMyKommentare() {
	return myKommentare;
    }

    /**
     * @param myKommentare the myKommentare to set
     */
    public void setMyKommentare(Collection<Kommentar> myKommentare) {
	this.myKommentare = myKommentare;
    }

    /**
     * @return the myBilder
     */
    public Collection<Bild> getMyBilder() {
	return myBilder;
    }

    /**
     * @param myBilder the myBilder to set
     */
    public void setMyBilder(Collection<Bild> myBilder) {
	this.myBilder = myBilder;
    }
}