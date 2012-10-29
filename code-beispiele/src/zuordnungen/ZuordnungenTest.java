package zuordnungen;

import java.util.HashMap;

/**
 * Diese Klasse dient dazu, die Anwendung der Klasse HashMap
 * des JDK darzustellen. Die Anwendung der Klasse HashMap
 * ist sehr ähnlich.
 */
public class ZuordnungenTest {

    /**
     * Stellt den Inhalt der übergebenen Zuordnung auf
     * dem Bildschirm dar.
     *
     * @param zuordnung  Zuordnung, deren Inhalt dargestellt wird
     */
    public static void gibAus(HashMap zuordnung) {

        System.out.println("Größe: " + zuordnung.size());
        System.out.println("Inhalt: " + zuordnung);
        System.out.println();
    }

    /**
     * Veranschaulicht Methoden, die in der Zuordnungsklasse
     * HashMap zur Verfügung stehen.
     */
    private static void testHashMap() {

        /* Gleiche Zeichenketten mit unterschiedlicher
         * Identität erzeugen. */
        String table1 = new String("table");
        String table2 = new String("table");

        /* HashMap erzeugen */
        HashMap zuordnung = new HashMap();

        /* isEmpty() gibt zurück, ob eine HashMap keine Elemente enthält. */
        System.out.println("ist leer: " + zuordnung.isEmpty());
        gibAus(zuordnung);

        /* put(Object, Object) fügt der HashMap einen Eintrag mit
         * einem Schlüssel und einem Wert hinzu. Falls bereits
         * ein Eintrag mit gleichem(!) Schlüssel existiert, wird er
         * durch den neuen Eintrag ersetzt. Die Methode ist nicht void.
         * Der ersetzte Eintrag wird von der Methode zurückgegeben, oder
         * null, wenn noch kein Eintrag mit dem Schlüssel existierte.
         */
        System.out.println("ersetzter Eintrag: "
                           + zuordnung.put(table1, "Tisch"));
        gibAus(zuordnung);

        System.out.println("ersetzter Eintrag: "
                           + zuordnung.put(table2, "Tisch, Tabelle"));
        gibAus(zuordnung);

        /* put(object, Object) kann auch wie eine void-Methode
         * aufgerufen werden.
         */
        zuordnung.put("mouse", "Maus");
        gibAus(zuordnung);

        /* containsKey(Object) gibt zurück, ob HashMap einen
         * Schlüssel enthält, der gleich(!) dem übergebenen
         * Objekt ist.
         */
        System.out.println("enthält Schlüssel " + table1 + ": "
                           + zuordnung.containsKey(table1));
        System.out.println("enthält Schlüssel Mouse: "
                           + zuordnung.containsKey("Mouse"));
        System.out.println();

        /* containsValue(Object) gibt zurück, ob HashMap einen
         * Wert enthält, der gleich(!) dem übergebenen
         * Objekt ist.
         */
        System.out.println("enthält Wert " + table1 + ": "
                           + zuordnung.containsValue(table1));
        System.out.println("enthält Wert Maus: "
                           + zuordnung.containsValue(new String("Maus")));
        System.out.println();

        /* get(Object) liefert den Wert zu einem Schlüssel. Enthält
         * die Tabelle keinen Eintrag zu dem angegebenen Schlüssel,
         * wird null zurückgegeben.
         */
        System.out.println("Wert zu Schlüssel " + table1 + ": "
                           + zuordnung.get(table1));
        System.out.println("Wert zu Schlüssel Mouse: "
                           + zuordnung.get("Mouse"));
        System.out.println();

        /* remove(Object) entfernt einen Eintrag zum angegebenen
         * Schlüssel. Falls die HashMap keinen passenden Eintrag
         * enthält, bleibt sie unverÄndert. Die Methode liefert als
         * Ergebnis den entfernten Wert(!).
         */
        System.out.println("Entfernter Eintrag: "
                           + zuordnung.remove(table1));
        gibAus(zuordnung);

        System.out.println("Entfernter Eintrag: "
                           + zuordnung.remove("Mouse"));
        gibAus(zuordnung);
    }

    /**
     * Veranschaulicht Anwendung von Objekten "eigener" Klassen
     * als Schlüssel von Zuordnungen.
     */
    private static void testDatumAlsSchluessel() {

        HashMap veranstaltungen = new HashMap();

        Datum d = new Datum(1, 1, 2005);
        veranstaltungen.put(d, "Neujahrsfest");

        veranstaltungen.put(new Datum(30, 4, 2005), "Tanz in den Mai");

        System.out.println(veranstaltungen.get(d));

        System.out.println(veranstaltungen.get(new Datum(30, 4, 2005)));
    }

    /**
     * Führt die Testmethoden aus.
     *
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        testHashMap();
        testDatumAlsSchluessel();
    }
}
