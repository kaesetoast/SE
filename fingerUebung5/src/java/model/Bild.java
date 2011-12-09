package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Bild implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    protected String url;
    @Temporal(TemporalType.DATE)
    protected Date datum;
    protected int laenge;
    protected int breite;
    protected String titel;

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @return the url
     */
    public String getUrl() {
	return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
	this.url = url;
    }

    /**
     * @return the datum
     */
    public Date getDatum() {
	return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
	this.datum = datum;
    }

    /**
     * @return the laenge
     */
    public int getLaenge() {
	return laenge;
    }

    /**
     * @param laenge the laenge to set
     */
    public void setLaenge(int laenge) {
	this.laenge = laenge;
    }

    /**
     * @return the breite
     */
    public int getBreite() {
	return breite;
    }

    /**
     * @param breite the breite to set
     */
    public void setBreite(int breite) {
	this.breite = breite;
    }

    /**
     * @return the titel
     */
    public String getTitel() {
	return titel;
    }

    /**
     * @param titel the titel to set
     */
    public void setTitel(String titel) {
	this.titel = titel;
    }
}