package model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Kommentar extends AbstractBeitrag implements Serializable {
    
    public String toString() {
        return titel + ": " + beschreibung;
    }
    
}