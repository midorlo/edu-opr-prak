package listen;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

import katalog5.Buch;

/**
 * Diese Klasse dient dazu, die Anwendung von Listenklassen
 * des JDK darzustellen.
 *
 * Zu Anschauungszwecken werden Listen mit Buch-Objekten verwendet.
 * Einige Methoden basieren auf Gleichheit (equals) der enthaltenen
 * Objekte. In der Klasse Buch ist equals so definiert, dass zwei
 * Bücher gleich sind, wenn sie denselben Titel, Autor und
 * Erscheinungsjahr besitzen.
 */
public class ListenTest {

    /**
     * Stellt den Inhalt der übergebenen Collection auf
     * dem Bildschirm dar.
     *
     * @param info  Infotext, mit der die Ausgabe beginnt
     * @param c  Collection, deren Inhalt dargestellt wird
     */
    private static void gibAus(String info, AbstractCollection c) {

        System.out.println(info + " Collection:");
        System.out.println("Größe: " + c.size());
        System.out.println("Inhalt: " + c);
        System.out.println();
    }

    /**
     * Stellt den Inhalt des übergebenen Arrays auf dem Bildschirm dar.
     *
     * @param info  Infotext, mit der die Ausgabe beginnt
     * @param objekte  Array, dessen Inhalt dargestellt wird
     */
    private static void gibAus(String info, Object[] objekte) {

        System.out.println(info + " Array:");
        System.out.println("Größe: " + objekte.length);
        for (int i = 0; i < objekte.length; i++) {
            System.out.println("[" + i + "]: " + objekte[i]);
        }
        System.out.println();
    }

    /**
     * Veranschaulicht Funktionsweise von Methoden, die in den
     * Listenklassen ArrayList, Vector und LinkedList zur
     * Verfügung stehen und keinen Indexparameter besitzen.
     */
    private static void testNoIndexmethoden() {

        /* Collection erzeugen:
         * eine der folgenden drei Zeilen einkommentieren
         */
        ArrayList c = new ArrayList();
//        LinkedList c = new LinkedList();
//        Vector c = new Vector();
//        HashSet c = new HashSet();

        /* isEmpty() gibt zurück, ob eine Collection keine Elemente enthält. */
        System.out.println("ist leer: " + c.isEmpty());
        gibAus("1)", c);

        /* add(Object) fügt einer Collection ein Element hinzu. add ist
         * nicht void, kann aber wie eine void-Methode aufgerufen werden.
         * Der Rückgabewert wird dann ignoriert.
         */
        c.add(new Buch("Die große überfahrt", "Uderzo", 7.20f, 1975));
        System.out.println("ist leer: " + c.isEmpty());
        gibAus("2)", c);

        /* Dasselbe mit Ausgabe des Rückgabewerts. Der Rückgabewert gibt
         * an, ob das Element tatsächlich hinzugefügt wurde.
         */
        Buch derSeher720 = new Buch("Der Seher", "Uderzo", 7.20f, 1975);
        System.out.println("Element hinzugefügt: " + c.add(derSeher720));
        gibAus("3)", c);

        /* In Listen können gleiche Elemente doppelt eingefügt werden,
         * nicht aber in Mengen. Jetzt der Versuch, das zweite mal
         * Die große überfahrt einzufügen.
         */
        System.out.println("Element hinzugefügt: "
                           + c.add(new Buch("Die große überfahrt",
                                            "Uderzo", 8.20f, 1975)));
        gibAus("4)", c);

        /* toArray() liefert die Elemente einer Collection als Array. */
        Object[] elemente = c.toArray();
        gibAus("5)", elemente);

        /* contains(Object) gibt an, ob Collection ein Element enthält,
         * das gleich dem übergebenen Objekt ist.
         */
        System.out.println("Collection enthält: " + c.contains(derSeher720));

        /* contains(Object) basiert auf Gleichheit, nicht auf Identität.
         * Gleicher Test, aber mit neuem Buch "Der Seher".
         */
        System.out.println("Collection enthält: "
                + c.contains(new Buch("Der Seher", "Uderzo", 7.80f, 1975)));
        System.out.println();

        /* remove(Object) entfernt ein Element aus der Collection. */
        c.remove(derSeher720);
        gibAus("6)", c);

        /* remove(Object) basiert nicht auf Objektidentität, sondern
         * auf Gleichheit.
         * Zum Test wird "Der Seher" wieder hinzugefügt und remove mit einem
         * anderen, aber gleichen Buch aufgerufen.
         */
        c.add(derSeher720);
        gibAus("7)", c);
        c.remove(new Buch("Der Seher", "Uderzo", 7.80f, 1975));
        gibAus("8)", c);

        /* Was ist, wenn die Collection mehrere gleiche Elemente enthält?
         * remove entfernt das erste Vorkommen eines Elements, das gleich
         * dem übergebenen Objekt ist.
         */
        c.add(derSeher720);
        c.add(new Buch("Der Seher", "Uderzo", 7.80f, 1975));
        gibAus("9)", c);
        c.remove(new Buch("Der Seher", "Uderzo", 7.80f, 1975));
        gibAus("10)", c);

        /* Was ist, wenn ein Element, das zu löschen ist, nicht in der
         * Collection vorkommt? Dann bleibt die Collection, wie sie ist.
         * Genauso wie add, so ist auch remove eine Methode vom Typ boolean.
         * Der Rückgabewert gibt an, ob ein Element tatsächlich gelöscht
         * wurde.
         */
        System.out.println("Element gelöscht: "
                           + c.remove(new Buch("Tour de France",
                                               "Uderzo", 7.90f, 1998)));
        gibAus("11)", c);

        /* clear() entfernt alle Elemente aus der Collection. */
        c.clear();
        gibAus("12)", c);
    }

    /**
     * Diese Methode veranschaulicht Methoden, in denen per Index
     * auf eine Liste zugegriffen wird.
     */
    private static void testIndexmethoden() {

        /* Collection erzeugen:
         * eine der folgenden drei Zeilen einkommentieren
         */
        ArrayList c = new ArrayList();
//        LinkedList c = new LinkedList();
//        Vector c = new Vector();

        /* Zunächst ein Element hinzufügen. */
        c.add(new Buch("Die große überfahrt", "Uderzo", 7.20f, 1975));
        gibAus("1)", c);

        /* add(int, Object) fügt ein Objekt an der angegebenen Stelle
         * in die Collection ein. Dahinter stehende Elemente rücken
         * eine Indexposition hoch. add(int, Object) ist void.
         */
        c.add(0, new Buch("Der Seher", "Uderzo", 7.20f, 1975));
        gibAus("2)", c);

        /* Durch add(int, Object) kann natürlich auch hinten ein
         * Element hinzugefügt werden.
         */
        c.add(2, new Buch("Tour de France", "Uderzo", 6.90f, 1970));
        gibAus("3)", c);

        /* Durch add(int, Object) dürfen aber keine "Indexlücken"
         * entstehen. Hier würde eine Lücke für Index 3 entstehen.
         */
//        c.add(4, new Buch("Streit um Asterix", "Uderzo", 7.90, 1979));
//        gibAus("4)", c);

        /* get(int) liefert das Element an der angegebenen Indexposition.
         * Bei unzulässigem Index kommt es zu einem Fehler.
         */
        System.out.println("Element an Position 2: " + c.get(2));
        System.out.println();

        /* remove(int) entfernt das Element an der angegebenen
         * Indexposition. Dahinter stehende Elemente rücken eine
         * Indexposition herunter. Das entfernte Element wird als
         * Ergebnis der Methode zurückgegeben.
         */
        System.out.println("entferntes Element: " + c.remove(0));
        gibAus("5)", c);

        /* set(int, Object) ersetzt das Element an der angegebenen
         * Indexposition durch ein anderes. Das ersetzte Elemente
         * wird als Ergebnis der Methode zurückgegeben.
         */
        System.out.println("ersetztes Element: " + c.set(0, new Buch(
                "Asterix und der Kupferkessel", "Uderzo", 6.50f, 1969)));
        gibAus("6)", c);
    }

    /**
     * Führt die Testmethoden aus.
     *
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        testNoIndexmethoden();
        testIndexmethoden();
    }
}
