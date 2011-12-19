/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
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
    protected int bewertung;
    protected String titel;
    protected String beschreibung;
    @ManyToOne
    protected Mitarbeiter autor;

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
     * @return the bewertung
     */
    public int getBewertung() {
	return bewertung;
    }

    /**
     * @param bewertung the bewertung to set
     */
    public void setBewertung(int bewertung) {
	this.bewertung = bewertung;
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
}
