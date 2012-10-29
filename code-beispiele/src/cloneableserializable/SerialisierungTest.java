package cloneableserializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * Diese Klasse dient der Veranschaulichung der Serialisierung
 * von Objekten.
 */
public class SerialisierungTest {

    /**
     * Liefert einen Katalog mit Büchern und Autos.
     *
     * @return Katalog mit Büchern und Autos
     */
    private static Katalog erzeugeKatalog() {

        Katalog katalog = new Katalog();

        katalog.fuegeHinzu(
                new Buch("Asterix der Gallier", "Uderzo", 9.80f, 1965));
        katalog.fuegeHinzu(
                new Buch("Asterix bei den Goten", "Uderzo", 9.80f, 1968));
        katalog.fuegeHinzu(
                new Buch("Asterix in Helvetien", "Uderzo", 9.80f, 1977));
        katalog.fuegeHinzu(
                new Buch("Die große überfahrt", "Uderzo", 9.80f, 1983));
        katalog.fuegeHinzu(
                new Auto("VW Käfer", 23, 1962, 2500.0f));

        return katalog;
    }

    /**
     * Veranschaulicht das Serialisieren und Deserialisieren von Objekten.
     *
     * @param args  wird nicht verwendet
     *
     * @throws ClassNotFoundException wird geworfen, wenn ein Klassenname
     *         im serialisierten Byte-Strom unbekannt ist
     * @throws IOException wird geworfen bei Problemen mit Einlesen
     *         des serialisierten Byte-Stroms
     */
    public static void main(String[] args)
        throws ClassNotFoundException, IOException {

        File verzeichnis = new File("src/cloneableserializable");
        File datei = new File(verzeichnis, "Objekte.ser");

        FileOutputStream fos = new FileOutputStream(datei);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        /* Verschiedene Objekte serialisieren.
         */
        os.writeObject("Asterix der Gallier");
        os.writeObject(erzeugeKatalog());
        os.writeObject(new int[]{100, 101, 102, 103});

        os.close();

        FileInputStream fis = new FileInputStream(datei);
        ObjectInputStream is = new ObjectInputStream(fis);

        /* Objekte wieder deserialisieren.
         */
        String s = (String) is.readObject();
        Katalog k = (Katalog) is.readObject();
        int[] a = (int[]) is.readObject();

        is.close();

        System.out.println("String: " + s);
        System.out.println("Katalog: " + k.gibArtikelliste());
        System.out.println("int-array: " + Arrays.toString(a));
    }
}
