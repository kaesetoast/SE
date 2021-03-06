/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nielsgarve
 */
@MappedSuperclass
public abstract class AbstractBeitrag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected long id;
    @Temporal(TemporalType.DATE)
    protected Date datum;
    protected float bewertung;
    private int bewertungAnzahl;
    protected String titel;
    protected String beschreibung;
    @ManyToOne
    protected Mitarbeiter autor;
    @OneToMany(cascade = CascadeType.REMOVE)
    private Collection<Kommentar> myKommentare;

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
     * @author Philipp
     * @return the bewertung
     */
    public float getBewertung() {
	if (bewertungAnzahl > 0) {
	    return bewertung / bewertungAnzahl;
	}
	return bewertung;
    }

    /**
     * @author philipp
     * @param bewertung the bewertung to set
     */
    public void setBewertung(float bewertung) {
	this.bewertung += bewertung;
        this.bewertungAnzahl++;
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

    /**
     * @return the beschreibung
     */
    public String getBeschreibung() {
	return beschreibung;
    }

    /**
     * @param beschreibung the beschreibung to set
     */
    public void setBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
    }

    /**
     * @return the autor
     */
    public Mitarbeiter getAutor() {
	return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Mitarbeiter autor) {
	this.autor = autor;
    }

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
     * @return the bewertungAnzahl
     */
    public int getBewertungAnzahl() {
	return bewertungAnzahl;
    }

    /**
     * @author philipp
     * @param bewertungAnzahl the bewertungAnzahl to set
     */
    public void setBewertungAnzahl(int bewertungAnzahl) throws IllegalAccessException {
	throw new IllegalAccessException("bewertungsAnzahl must not be set manually.");
    }
}
