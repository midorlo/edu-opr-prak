//TODO class comment
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carsharing;

import java.util.ArrayList;

/**
 *
 * @author apex
 */
public class Standort {

    /*
     * Name des Standorts
     */
    public String name;
    /*
     * Liste mit allen zugeordneten Fahzeugen
     */
    public ArrayList<Fahrzeug> fahrzeugListe = new ArrayList();

    /**
     * Erzeugt ein Objekt dieser Klasse
     *
     * @param name Name des Standorts
     */
    public Standort(String name) {
        /*
         * Setzt den Namen des Standortes
         */
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Standort other = (Standort) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Standort{" + "name=" + name + ", fahrzeugListe=" + fahrzeugListe + '}';
    }
    
    public String getIdent() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }

    /**
     * Liefert den Namen des Standortes
     *
     * @return Name des Standortes
     */
    public String gibName() {
        return this.name;
    }

    /**
     * Fügt dem Standort ein neues Fahrzeug hinzu
     *
     * @param fahrzeug
     */
    public void fuegeFahrzeugHinzu(Fahrzeug fahrzeug) {
        /*
         * Wenn Fahrzeug noch nicht in Fahrzeugliste des Standorts, füge es
         * hinzu
         */
        if (!fahrzeugListe.contains(fahrzeug)) {
            this.fahrzeugListe.add(fahrzeug);
        }
    }

    /**
     * Gibt alle Fahrzeuge des Standorts zurück
     *
     * @return alle Fahrzeuge des Standorts
     */
    public ArrayList<Fahrzeug> getFahrzeugListe() {
        return fahrzeugListe;
    }

}
