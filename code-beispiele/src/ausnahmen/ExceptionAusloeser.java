package ausnahmen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Die Klasse dient der Darstellung von Situationen, die zu
 * Ausnahmen der Klassen Error, RuntimeException und Exception
 * (bzw. Unterklassen dieser Klassen) führen können.
 */
public class ExceptionAusloeser {

    /** Löst NullPointerException aus. */
    public static void testNull1() {

        Integer[] feld = new Integer[10];
        System.out.println(feld[0].intValue());
    }

    /**
     * Löst NullPointerException aus, jedoch nicht direkt
     * in dieser Methode, sondern im Konstruktor der
     * Klasse StringTokenizer.
     */
    public static void testNull2() {

        StringTokenizer st = new StringTokenizer(null);
    }

    /** Löst ArrayIndexOutOfBoundsException aus. */
    public static void testArrayIndex() {

        int[] feld = new int[10];
        int a = feld[10];
    }

    /** Löst IndexOutOfBoundsException aus. */
    public static void testListenindex() {

        ArrayList l = new ArrayList();
        Object o = l.get(0);
    }

    /** Löst StringIndexOutOfBoundsException aus. */
    public static void testStringIndex() {

        String s = "Gelsenkirchen";
        char ch = s.charAt(13);
    }

    /** Löst ClassCastException aus. */
    public static void testCast() {

        ArrayList l = new ArrayList();
        l.add(new Integer(1));
        Float f = (Float) l.get(0);
    }

    /**
     * Löst IllegalArgumentException aus.
     * Eine Zusicherung ist verletzt.
     */
    public static void testArgumente() {

        ArrayList l = new ArrayList(-5);
    }

    /**
     * Löst OutOfMemoryError aus;
     * es werden fortlaufend Objekte erzeugt,
     * die in einer Liste aufgesammelt werden.
     */
    public static void testSpeicher() {

        ArrayList l = new ArrayList();

        while (true) {
            l.add(new Integer(1));
        }
    }

    /** Löst StackOverflowError aus. */
    public static void testRekursion() {

        testRekursion();
    }

    /**
     * Löst FileNotFoundException aus, wenn die Datei C:/datei.txt
     * nicht vorhanden ist.
     *
     * @throws FileNotFoundException  wird geworfen, wenn die Datei
     *         C:/datei.txt nicht vorhanden ist
     */
    public static void testFile() throws FileNotFoundException {

        BufferedReader reader =
                new BufferedReader(new FileReader("C:/datei.txt"));
    }

    /**
     * Führt die Testmethoden dieser Klasse aus.
     *
     * @param args  wird nicht verwendet
     * @throws FileNotFoundException  Ausnahme beim Lesen einer
     *         Datei wird weitergereicht
     */
    public static void main(String[] args) throws FileNotFoundException {

//        testNull1();
        // Ergebnis = NullPointerException
//        testNull2();
        // Ergebnis = NullPointerException
//        testArrayIndex();
        // Ergebnis = ArrayIndexOutOfBoundsException
//        testListenindex();
        // Ergebnis = IndexOutOfBoundsException
//        testStringIndex();
        // Ergebnis = StringOutOfBoundsException
//        testCast();
        // Ergebnis = ClassCastException
//        testArgumente();
        // Ergebnis = IllegalArgumentException
//        testSpeicher();
        // Ergebnis = OutOfMemoryEror
//        testRekursion();
        // Ergebnis = StackOverflowError
//        testFile();
        // Ergebnis = FileNotFoundException
    }
}
