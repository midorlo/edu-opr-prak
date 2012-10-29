//TODO class comment
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carsharing;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author apex
 */
public class Fahrzeugmanager {

    ArrayList<Fahrzeug> fahrzeuge = new ArrayList();
    ArrayList<Standort> standorte = new ArrayList();

    /**
     * Erzeugt Objekte dieser Klasse
     */
    public Fahrzeugmanager() {
    }

    /**
     * Eine Instanzmethode, durch die dem Fahrzeugmanager ein Fahrzeug mit einem
     * bestimmten Namen und Standort hinzugefügt wird. Falls der Fahrzeugmanager
     * bereits ein Fahrzeug mit diesem Namen verwaltet, soll kein Fahrzeug
     * hinzugefügt werden.
     *
     * @param fahrzeugname Name des Fahrzeugs
     * @param standort Standort des Fahrzeugs
     */
    public void fuegeFahrzeugHinzu(String fahrzeugname, String standort) {
        /*
         * Wenn Fahrzeug noch nicht in der Liste vorhandener Fahrzeuge ist,
         * erstelle es
         */
        if (!fahrzeuge.contains(new Fahrzeug(fahrzeugname, standort))) {
            /*
             * Neues Fahrzeug mit einem Namen und Standort
             */
            Fahrzeug fahrzeug = new Fahrzeug(fahrzeugname, standort);
            /*
             * Hinzufügen des neuen Fahrzeugs zur Liste fahrzeuge
             */
            fahrzeuge.add(fahrzeug);

            bestimmeStandort(standort, fahrzeug);
        }
    }

    /**
     * Eine Instanzmethode, durch die ein neuer Standort und zugehörige
     * Fahrzeuge bestimmt wird.
     *
     * @param standort Name des neuen Standorts
     * @param fahrzeug Zugehöriges Fahrzeug
     */
    public void bestimmeStandort(String standort, Fahrzeug fahrzeug) {
        /*
         * Iteration über alle Standorte
         */
            if (standorte.contains(new Standort(standort))) {
                standorte.get(standorte.indexOf(new Standort(standort))).fuegeFahrzeugHinzu(fahrzeug);
            } else {
                /*
                 * Erstellt einen neuen Standort und fügt diesen zur Liste aller
                 * Standorte hinzu
                 */
                Standort neuerStandort = new Standort(standort);
                standorte.add(neuerStandort);
                /*
                 * Fügt dem Standort das neue Fahrzeug hinzu
                 */
                neuerStandort.fuegeFahrzeugHinzu(fahrzeug);
            }
      //  }
    }

    /**
     * Eine Instanzmethode, die die Namen aller Fahrzeuge alphabetisch sortiert
     * zurückgibt. Die Methode liefert also eine Liste mit Zeichenketten.
     *
     * @return Alphabetisch sortierte Liste mit den Namen aller Fahrzeuge
     */
    public ArrayList gibFahrzeugnamen() {
        /*
         * Neue Liste für alle Fahrzeugnamen
         */
        ArrayList fahrzeugnamen = new ArrayList();
        /*
         * Kopiert jeden Fahrzeugnamen aus fahrzeuge in die neue Liste
         */
        for (int i = 0; i < fahrzeuge.size(); i++) {
            fahrzeugnamen.add(fahrzeuge.get(i).gibName());
        }
        /*
         * Sortiert die Fahrzeugnamensliste
         */
        Collections.sort(fahrzeugnamen);
        /*
         * Rückgabe des Fahrzeugnamens
         */
        return fahrzeugnamen;
    }

    /**
     * Eine Instanzmethode, mit der das Fahrzeug mit dem angegebenen Namen für
     * einen bestimmten Zeitraum gebucht wird. Die Angabe der Zeitpunkte erfolgt
     * im Format JJJJ/MM/TT HH:MM.
     *
     * @param fahrzeugname Name des Fahrzeugs
     * @param startzeit Startdatum und Startzeitpunkt
     * @param endzeit Enddatum und Endzeitpunkt
     * @return true, wenn das Fahrzeug in dem gewünschten Zeitrahmen verfügbar
     * ist
     */
    public boolean bucheFahrzeug(String fahrzeugname, String startzeit, String endzeit) {
        /*
         * Verfügbarkeit des Fahrzeugs
         */
        boolean istVerfuegbar = false;
        /*
         * Für alle Fahrzeuge prüfe...
         */
        for (int i = 0; i < fahrzeuge.size(); i++) {
            /*
             * ...ob Fahrzeug mit dem zu buchenden Fahrzeug übereinstimmt und
             * schon gebucht ist
             */
            if (fahrzeuge.get(i).gibName().equals(fahrzeugname)
                    && fahrzeuge.get(i).istFrei(startzeit, endzeit)) {
                /*
                 * Fahrzeug ist verfügbar
                 */
                istVerfuegbar = true;
                /*
                 * Setze neue Buchung
                 */
                fahrzeuge.get(i).setzeBuchung(startzeit, endzeit);
            }
        }
        /*
         * Rückgabe, ob Fahrzeug verfügbar
         */
        return istVerfuegbar;
    }

    /**
     * Eine Instanzmethode, die die Namen aller Fahrzeuge des angegebenen
     * Standorts alphabetisch sortiert zurückgibt, die in einem bestimmten
     * Zeitraum verfügbar sind. Ein Fahrzeug ist in einem Zeitraum verfügbar,
     * wenn es für diesen Zeitraum gebucht werden kann. Die Methode liefert also
     * eine Liste von Zeichenketten.
     *
     * @param standort Standort der Fahrzeuge
     * @param startzeit Startdatum und Startzeitpunkt
     * @param endzeit Enddatum und Endzeitpunkt
     * @return true, wenn das Fahrzeug in dem gewünschten Zeitrahmen verfügbar
     * ist
     */
    public ArrayList gibVerfuegbareFahrzeuge(String standort, String startzeit, String endzeit) {

        /*
         * Eine neue Liste für alle verfügbaren Fahrzeuge
         */
        ArrayList verfuegbareFahrzeuge = new ArrayList();
        
        /*
         * Iteration über alle Standorte
         */
        for (int i = 0; i < standorte.size(); i++) {
            /*
             * Ist Standort der gesuchte Standort?
             */
           if (standorte.get(i).gibName().equals(standort)) {
              // if (standorte.contains(new Standort(standort))) {

                /*
                 * Eine neue Liste mit allen Fahrzeugen des Standortes
                 */
                ArrayList fahrzeugeDesStandorts = standorte.get(i).getFahrzeugListe();
                /*
                 * Iteration über alle Fahrzeuge des Standorts
                 */
                for (int j = 0; j < fahrzeugeDesStandorts.size(); j++) {
                    /*
                     * Wenn Fahrzeug ein frei-verfügbares Fahrzeug ist, dann...
                     */
                    if (((Fahrzeug) fahrzeugeDesStandorts.get(j)).istFrei(startzeit, endzeit)) {
                        /*
                         * füge Fahrzeug zu der Liste verfügbarer Fahrzeuge
                         * hinzu
                         */
                        verfuegbareFahrzeuge.add(fahrzeugeDesStandorts.get(j));

                    }

                }

            }

        }
        /*
         * Gibt Liste aller verfügbaren Fahrzeuge zurück
         */
        return verfuegbareFahrzeuge;
    }
}
