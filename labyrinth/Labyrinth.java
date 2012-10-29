package labyrinth;

import java.util.Random;
import util.Punkt;

/**
 * Ein Objekt dieser Klasse dient der Erzeugung eines Labyrinths.
 *
 * @author Benjamin Schuermann, 201020367
 * @version 0.5rc, 06.04.2012
 */
public class Labyrinth {

    /**
     * Konstanten zur Richtungsbestimmung im Raster
     */
    private static final int LINKS = 0;
    private static final int HOCH = 1;
    private static final int RECHTS = 2;
    private static final int RUNTER = 3;
    /**
     * Mögliche Richtungen vom Endpunkt eines jeden Wandelements Hoch(-1,0),
     * Runter(1,0), Rechts(0,1), Links(0,-1)
     */
    private static final Punkt[] RICHTUNG = {new Punkt(-1, 0), new Punkt(0, -1),
        new Punkt(1, 0), new Punkt(0, 1)};
    /**
     * Breite, Höhe, Länge des Labyrinths
     */
    private int breite;
    private int hoehe;
    private int laenge;
    /**
     * Index des nächst freien Punkts
     */
    private int wandIndex = 0;
    /**
     * Startpunkte, Endpunkte von Wandelementen
     */
    private Punkt[] startpunkte;
    private Punkt[] endpunkte;
    /**
     * Belegte Punkte
     */
    private boolean[][] istBelegt;
    /**
     * Aktuell gewählter Punkt
     */
    private Punkt aktuellerPunkt;

    /**
     * Erzeugt ein Labyrinth aus der Größe Breite x Höhe
     *
     * @param breite Breite, des zu erzeugenden Labyrinths
     * @param hoehe Höhe, des zu erzeugenden Labyrinths
     */
    public Labyrinth(int breite, int hoehe) {

        /*
         * Setze Breite, Höhe und Länge des Labyrinths
         */
        this.breite = breite;
        this.hoehe = hoehe;
        this.laenge = (breite + 1) * (hoehe + 1);

        /*
         * Bestimme Größen der Arrays für Start-und Endpunkte
         */
        startpunkte = new Punkt[laenge];
        endpunkte = new Punkt[laenge];

        /*
         * Bestimme Größe des istBelegt Arrays
         */
        istBelegt = new boolean[breite + 1][hoehe + 1];

        /*
         * Erzeuge Außenwand
         */
        erzeugeAussenwand();

        /*
         * Erzeuge Labyrinth
         */
        erzeugeLabyrinth();
    }

    /**
     * Erzeugt die Außenwände des Labyrinths
     */
    public void erzeugeAussenwand() {

        for (int i = 0; i <= breite - 1; i++) {

            /*
             * Erzeuge Obere Aussenwand
             */
            erzeugeWand(i, 0, RECHTS);

            /*
             * Erzeuge Untere Aussenwand
             */
            erzeugeWand(i, hoehe, RECHTS);

        }

        for (int i = 0; i <= hoehe - 1; i++) {

            /*
             * Erzeuge Linke Aussenwand
             */
            erzeugeWand(0, i, RUNTER);

            /*
             * Erzeuge Rechte Aussenwand
             */
            erzeugeWand(breite, i, RUNTER);

        }

    }

    /**
     * Erzeugt ein neues Wandelement
     *
     * @param x x-Koordinate des Startpunkts
     * @param y y-Koordinate des Startpunkts
     * @param richtung Richtung, in welche die Wand gezogen werden soll
     */
    public void erzeugeWand(int x, int y, int richtung) {

        /*
         * Erzeuge Startpunkt
         */
        startpunkte[wandIndex] = new Punkt(x, y);

        /*
         * Erzeuge Endpunkt
         */
        endpunkte[wandIndex] = startpunkte[wandIndex].addiere(RICHTUNG[richtung]);

        /*
         * Füge Startpunkt zum Array istBelegt hinzu
         */
        istBelegt[x][y] = true;

        /*
         * Füge Endpunkt zum Array istBelegt
         */
        istBelegt[x + RICHTUNG[richtung].gibX()][y + RICHTUNG[richtung].gibY()] = true;

        /*
         * Erhöhe Anzahl der Wandelemente
         */
        wandIndex++;

    }

    /**
     * Generiert ein neues Labyrinth, innerhalb der Außenwände
     */
    public void erzeugeLabyrinth() {

        /*
         * Erzeuge Zufallsgenerator
         */
        Random random = new Random();

        while (wandIndex < laenge) {

            /*
             * Wähle beliebigen Punkt aus
             */
            aktuellerPunkt = endpunkte[(int) (Math.random() * wandIndex)];

            /*
             * Wähle beliebige RIchtung
             */
            int richtung = random.nextInt(4);

            /*
             * Setze nächste Koordinate
             */
            int naechstesX = aktuellerPunkt.addiere(RICHTUNG[richtung]).gibX();
            int naechstesY = aktuellerPunkt.addiere(RICHTUNG[richtung]).gibY();

            /*
             * Prüfe auf möglichen Punkt
             */
            if (pruefeAusserhalb(naechstesX, naechstesY)) {

                /*
                 * Erzeuge neue Wand
                 */
                erzeugeWand(aktuellerPunkt.gibX(), aktuellerPunkt.gibY(), richtung);

            }

        }

    }

    /**
     * Prüft, ob Zielpunkt ein möglicher Punkt ist
     *
     * @param naechstesX x-Koordinate des Zielpunkts
     * @param naechstesY y-Koordinate des Zielpunkts
     * @return Rückgabe, ob Zielpunkt ein möglicher Punkt ist
     */
    public boolean pruefeAusserhalb(int naechstesX, int naechstesY) {

        /*
         * Rückgabewert, ob Punkt außerhalb möglicher Punkte liegt
         */
        boolean istAusserhalb = true;

        /*
         * Prüfung, ob Punkt noch innerhalb des Feldes liegt
         */
        if (naechstesX < 0 || naechstesX > breite
                || naechstesY < 0 || naechstesY > hoehe) {

            istAusserhalb = false;

        } else {

            /*
             * Prüfung, ob Punkt schon belegt ist
             */
            istAusserhalb = !istBelegt[naechstesX][naechstesY];

        }

        return istAusserhalb;

    }

    /**
     * Liefert die Anzahl aller Wandelemente des Labyrinths
     *
     * @return Rückgabe der Anzahl an Wandelementen
     */
    public int gibAnzahlWandelemente() {

        return wandIndex;

    }

    /**
     * Gibt die Höhe des Labyrinths zurück
     *
     * @return Rückgabe der Höhe des Labyrinths
     */
    public int gibHoehe() {

        return this.hoehe;

    }

    /**
     * Gibt die Breite des Labyrinths zurück
     *
     * @return Rückgabe der Breite des Labyrinths
     */
    public int gibBreite() {

        return this.breite;

    }

    /**
     * Gibt den Startpunkt eines Wandelements zurück
     *
     * @param anfang Gewählter Startpunkt
     * @return Rückgabe des Startpunkts
     */
    public Punkt gibStartpunkt(int anfang) {

        return startpunkte[anfang];

    }

    /**
     * Gibt den Endpunkt eines Wandelements zurück
     *
     * @param ende Gewählter Endpunkt
     * @return Rückgabe des Endpunkts
     */
    public Punkt gibEndpunkt(int ende) {

        return endpunkte[ende];

    }
}
