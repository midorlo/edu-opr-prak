//TODO class comment
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// Fahrzeug kann nicht zweimal gebucht werden
package carsharing;

/**
 *
 * @author apex
 */
public class Fahrzeug {

    /*
     * Name, Standort, Startzeit und Endzeit der Buchung des Fahrzeugs
     */
    public String name;
    public String standort;
    public Zeitraum startzeit;
    public Zeitraum endzeit;

    /**
     * Erzeugt ein Objekt dieser Klasse
     *
     * @param name Name des Fahrzeugs
     * @param standort Standort des Fahrzeugs
     */
    public Fahrzeug(String name, String standort) {
        this.name = name;
        this.standort = standort;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fahrzeug other = (Fahrzeug) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.standort == null) ? (other.standort != null) : !this.standort.equals(other.standort)) {
            return false;
        }
        if (this.startzeit != other.startzeit && (this.startzeit == null || !this.startzeit.equals(other.startzeit))) {
            return false;
        }
        if (this.endzeit != other.endzeit && (this.endzeit == null || !this.endzeit.equals(other.endzeit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fahrzeug{" + "name=" + name + ", standort=" + standort + ", startzeit=" + startzeit + ", endzeit=" + endzeit + '}';
    }

    /**
     * Gibt den Namen des Fahrzeugs zurück
     *
     * @return Fahrzeugname
     */
    public String gibName() {
        return name;
    }

    /**
     * Gibt zugeordneten Standort zurück
     */
    public String gibStandort() {
        return standort;
    }

    /**
     * Prüft, ob Fahrzeug frei zur Buchung ist
     *
     * @param startzeit Startdatum und Startzeitpunkt der Buchung
     * @param endzeit Enddatum und Endzeitpunkt der Buchung
     * @return true, wenn Fahrzeug gebucht werden kann
     */
    public boolean istFrei(String startzeit, String endzeit) {
        /*
         * Verfügbarkeit des Fahrzeugs
         */
        // 2012/11/24 23:12

        boolean istFrei = false;

        Zeitraum testeStartzeit = new Zeitraum(startzeit);
        Zeitraum testeEndzeit = new Zeitraum(endzeit);

        /*
         * Das Fahrzeug besitzt bereits einen Buchungszeitraum
         */
        if (this.startzeit != null && this.endzeit != null) {
            /*
             * Wenn zu testende Start- und Endzeiträume vor oder nach dem
             * vorhandenen Buchungszeitraum liegen und Startzeitraum kleiner als
             * Endzeitraum ist, dann...
             */
            if ((this.startzeit.pruefeRelation(testeStartzeit.getZeitraum())
                    == this.endzeit.pruefeRelation(testeStartzeit.getZeitraum()))
                    ||
                    (this.startzeit.pruefeRelation(testeEndzeit.getZeitraum())
                    == this.endzeit.pruefeRelation(testeEndzeit.getZeitraum()))
                    && testeStartzeit.getZeitraum() < testeEndzeit.getZeitraum()) {
                /*
                 * ...setze istFrei auf true
                 */
                istFrei = true;
            }
        } else if (this.startzeit == null && this.endzeit == null)  {

            /*
             * Wenn noch kein Buchungszeitraum gesetzt wurde, dann...
             * ...setze istFrei auf true
             */

            istFrei = true;
        }

        return istFrei;
    }

    /**
     * Führt eine neue Buchung auf das Fahrzeug aus
     *
     * @param startzeit Startdatum und Startzeitpunkt der Buchung
     * @param endzeit Enddatum und Endzeitpunkt der Buchung
     */
    public void setzeBuchung(String startzeit, String endzeit) {
        this.startzeit = new Zeitraum(startzeit);
        this.endzeit = new Zeitraum(endzeit);
    }
}
