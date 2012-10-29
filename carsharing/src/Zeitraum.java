/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carsharing;

/**
 *
 * @author apex
 */
public class Zeitraum {

    /*
     * Bestandteile des übergebenen Textausdruckes für einen Zeitraum Jahr, Tag,
     * Monat, Stunde, Minute, Vollständiges Datum, Vollständige Zeit,
     * Vollständiger Zeitraum
     */
    public long jahr;
    public long tag;
    public long monat;
    public long stunde;
    public long minute;
    public long datum;
    public long uhrzeit;
    public long zeitraum;

    /**
     * Erzeugt ein Objekt dieser Klasse Hierbei wird ein Textausdruck für einen
     * Zeitraum in dessen Bestandteile zerlegt und den Instanzvariablen
     * zugeordnet
     *
     * @param zeitraum Textausdruck im Format JJJJ/MM/TT SS:MM, z.B. 2012/05/21
     * 23:12
     * 201205212321
     * 2012/05/23 14:05
     * 2009/04/12 09:15
     */
    public Zeitraum(String zeitraum) {
        this.jahr = new Long(zeitraum.substring(0, 4));
        this.monat = new Long(zeitraum.substring(5, 7));
        this.tag = new Long(zeitraum.substring(8, 10));
        this.stunde = new Long(zeitraum.substring(11, 13));
        this.minute = new Long(zeitraum.substring(14, 16));
        this.datum =
                new Long((zeitraum.substring(0, 4)
                + zeitraum.substring(5, 7)
                + zeitraum.substring(8, 10)));
        this.uhrzeit =
                new Long((zeitraum.substring(11, 13)
                + zeitraum.substring(14, 16)));
        this.zeitraum =
                new Long((zeitraum.substring(0, 4)
                + zeitraum.substring(5, 7)
                + zeitraum.substring(8, 10)
                + zeitraum.substring(11, 13)
                + zeitraum.substring(14, 16)));
    }

    /**
     * Liefert den vollständigen Zeitraum als Wert zurück
     *
     * @return vollständiger Zeitraum als Wert
     */
    public long getZeitraum() {
        return zeitraum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zeitraum other = (Zeitraum) obj;
        if (this.jahr != other.jahr) {
            return false;
        }
        if (this.tag != other.tag) {
            return false;
        }
        if (this.monat != other.monat) {
            return false;
        }
        if (this.stunde != other.stunde) {
            return false;
        }
        if (this.minute != other.minute) {
            return false;
        }
        if (this.datum != other.datum) {
            return false;
        }
        if (this.uhrzeit != other.uhrzeit) {
            return false;
        }
        if (this.zeitraum != other.zeitraum) {
            return false;
        }
        return true;
    }
    
    /**
     * Liefert das vollständige Datum als Wert zurück
     *
     * @return vollständige Datum als Wert
     */
    public long getDatum() {
        return datum;
    }

    /**
     * Liefert die vollständige Uhrzeit als Wert zurück
     *
     * @return vollständige Uhrzeit als Wert
     */
    public long getUhrzeit() {
        return uhrzeit;
    }

    /**
     * Liefert das Jahr als Wert zurück
     *
     * @return Jahr als Wert
     */
    public long getJahr() {
        return jahr;
    }

    /**
     * Liefert die Minuten als Wert zurück
     *
     * @return Minuten als Wert
     */
    public long getMinute() {
        return minute;
    }

    /**
     * Liefert den Monat als Wert zurück
     *
     * @return Monat als Wert
     */
    public long getMonat() {
        return monat;
    }

    /**
     * Liefert die Stunden als Wert zurück
     *
     * @return Stunden als Wert
     */
    public long getStunde() {
        return stunde;
    }

    /**
     * Liefert den Tag als Wert zurück
     *
     * @return Tag als Wert
     */
    public long getTag() {
        return tag;
    }

    /**
     * Prüft, ob der übergebene Zeitraum vor oder nach einem schon bestehenden
     * Zeitraum liegt
     *
     * @param testeZeitraum zu testender Zeitraum
     * @return Position des Zeitraums
     */
    public long pruefeRelation(long testeZeitraum) {

        /*
         * -1: fehlerhafte Auswertung
         */
        long status = -1;

        if (testeZeitraum < this.zeitraum) {
            /*
             * 0: Zeitraum liegt vor dem bestehenden Zeitraum
             */
            status = 0;
        }

        if (testeZeitraum > this.zeitraum) {
            /*
             * 1: Zeitraum liegt nach dem bestehenden Zeitraum
             */
            status = 1;
        }

        return status;
    }
}
