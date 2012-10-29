package einausgabe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Diese Klasse dient der Veranschaulichung des Verhaltens
 * einiger Klassen des Package java.io.
 */
public class EinAusgabeTest {

    /**
     * Puffergröße für byte- oder zeichenweises
     * Einlesen aus Dateien.
     */
    private static final int PUFFERGROESSE = 10;

    /**
     * Verzeichnis für Testdateien zur Ein- und Ausgabe.
     */
    private static final String VERZEICHNIS = "src/einausgabe/";

    /**
     * Zur optischen Ausagbe der Ausgaben.
     */
    private static final String TRENNER = "---------";

    /**
     * Gibt eine Anzahl von Bytes aus einem byte-Array in die
     * Anzeige aus. Es wird jeweils der byte-Wert (Zahl zwischen
     * -128 und 127) und das Zeichen (char), das durch den Wert
     * codiert wird, ausgegeben.
     *
     * @param anzeige  Fenster zur Ausgabe
     * @param puffer  byte-Array
     * @param anzahl  Anzahl der Bytes, die aus puffer ausgegeben werden
     */
    private static void gibAus(Textanzeige anzeige,
                               byte[] puffer,
                               int anzahl) {

        for (int i = 0; i < anzahl; i++) {

            /* Zeichen und Code ausgeben.
             */
            anzeige.println(puffer[i] + ":\t" + (char) puffer[i]);
        }
    }

    /**
     * Gibt eine Anzahl von Zeichen aus einem char-Array in die
     * Anzeige aus. Es wird jeweils der Unicode-Wert (Zahl zwischen
     * 0 und 65535) und das Zeichen, das durch den Wert
     * codiert wird, ausgegeben.
     *
     * @param anzeige  Fenster zur Ausgabe
     * @param puffer  char-Array
     * @param anzahl  Anzahl der Zeichen, die aus puffer ausgegeben werden
     */
    private static void gibAus(Textanzeige anzeige,
                               char[] puffer,
                               int anzahl) {

        for (int i = 0; i < anzahl; i++) {

            /* Zeichen und Code ausgeben.
             */
            anzeige.println((int) puffer[i] + ":\t" + puffer[i]);
        }
    }

    /**
     * Liest eine Datei byte-weise ein und gibt die eingelesenen
     * Bytes aus. Das Einlesen erfolgt über die Klasse
     * FileInputStream, die einen byte-weisen Zugriff auf eine
     * Datei erlaubt.
     *
     * @param dateiname  Name der Datei, die eingelesen wird
     * @throws FileNotFoundException  wird beim Erzeugen des
     *         FileInputStream ausgelöst, wenn die Datei mit
     *         dem angegebenen Namen nicht existiert.
     * @throws IOException  wird bei einem I/O-Problem ausgelöst
     */
    private static void liesBytesAusDatei(String dateiname)
        throws FileNotFoundException, IOException {

        /* Textanzeige zur Ausgabe erzeugen.
         */
        Textanzeige anzeige = new Textanzeige();

        /* Beim Konstruieren eines FileInputStream wird der
         * Dateiname übergeben. (Es gibt andere Konstruktoren,
         * bei denen die Datei nicht durch ihren Namen angegeben
         * wird.) Beim Konstruieren wird der Bytestrom der Datei
         * zum Lesen geöffnet.
         */
        FileInputStream stream = new FileInputStream(dateiname);

        int anzahl;  // enthält, wieviele Bytes tatsächlich gelesen wurden
        byte[] puffer = new byte[PUFFERGROESSE];

        /* read gibt die Anzahl der Bytes zurück, die durch die
         * Lese-Methode aus dem Bytestrom gelesen wurde. Die
         * Methode liest maximal soviele Bytes, wie aufgrund der
         * Größe des Puffers möglich ist.
         */
        anzahl = stream.read(puffer);

        /* Aus dem Bytestrom lesen, solange noch Bytes gelesen
         * werden können.
         */
        while (anzahl > 0) {
            gibAus(anzeige, puffer, anzahl);
            anzeige.println(TRENNER);  // zur Trennung der Ausgaben
            anzahl = stream.read(puffer);
        }

        /* Bytestrom schließen. Zu jedem Öffnen muss es immer ein
         * passendes Schließen geben.
         */
        stream.close();
    }

    /**
     * Liest eine Datei zeichenweise ein und gibt die eingelesenen
     * Zeichen aus. Das Einlesen erfolgt über die Klasse
     * InputStreamReader, die einen zeichenweisen Zugriff auf eine
     * Datei erlaubt.<br/>
     *
     * Die Klasse InputStreamReader stützt sich intern auf die
     * Klasse FileInputStream ab und wandelt Bytes in Zeichen um.
     * Durch Angabe eines sogenannten "Encoding" kann angegeben
     * werden, wie Zeichen durch Bytes codiert sind. Hier wird das
     * Encoding UTF-8 verwendet.<br/>
     *
     * Diese Methode liefert nur dann eine für den Benutzer
     * verständliche Ausgabe, wenn die angegebene Datei tatsächlich
     * nach UTF-8 codiert ist.
     *
     * @param dateiname  Name der Datei, die eingelesen wird
     * @throws FileNotFoundException  wird beim Erzeugen des
     *         FileInputStream ausgelöst, wenn die Datei mit
     *         dem angegebenen Namen nicht existiert.
     * @throws IOException  wird bei einem I/O-Problem ausgelöst
     */
    private static void liesCharsAusDatei(String dateiname)
        throws FileNotFoundException, IOException {

        /* Textanzeige zur Ausgabe erzeugen.
         */
        Textanzeige anzeige = new Textanzeige();

        /* Beim Konstruieren des InputStreamReader wird ein
         * Objekt der Klasse FileInputStream übergeben, auf die
         * sich der Reader intern abstützt. Das Encoding wird
         * als zweiter Parameter angegeben.
         */
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(dateiname), "UTF-8");

        int anzahl;  // enthält, wieviele Zeichen tatsächlich gelesen wurden
        char[] puffer = new char[PUFFERGROESSE];

        /* read gibt die Anzahl der Zeichen zurück, die durch die
         * Lese-Methode aus dem Zeichenstrom gelesen wurde. Die
         * Methode liest maximal soviele Zeichen, wie aufgrund der
         * Größe des Puffers möglich ist.
         */
        anzahl = reader.read(puffer);

        /* Aus dem Zeichenstrom lesen, solange noch Zeichen gelesen
         * werden können.
         */
        while (anzahl > 0) {
            gibAus(anzeige, puffer, anzahl);
            anzeige.println(TRENNER);  // zur Trennung der Ausgaben
            anzahl = reader.read(puffer);
        }

        /* Zeichenstrom schließen. Zu jedem Öffnen muss es immer ein
         * passendes Schließen geben.
         */
        reader.close();
    }

    /**
     * Liest eine Datei zeilenweise ein und gibt die eingelesenen
     * Zeilen aus. Das Einlesen erfolgt über die Klasse
     * BufferedReader, die sich intern auf InputStreamReader
     * abstützt. BufferedReader ist eine Bequemlichkeitsklasse,
     * die komfortablere Methoden als lediglich das Einlesen in
     * ein Puffer-Array zur Verfügung stellt.
     *
     * @param dateiname  Name der Datei, die eingelesen wird
     * @throws FileNotFoundException  wird beim Erzeugen des
     *         FileInputStream ausgelöst, wenn die Datei mit
     *         dem angegebenen Namen nicht existiert.
     * @throws IOException  wird bei einem I/O-Problem ausgelöst
     */
    private static void liesZeilenAusDatei(String dateiname)
        throws FileNotFoundException, IOException {

        /* Textanzeige zur Ausgabe erzeugen.
         */
        Textanzeige anzeige = new Textanzeige();

        /* Beim Konstruieren des BufferedReader wird ein Objekt
         * der Klasse InputStreamReader übergeben, auf die sich
         * der BufferedReader intern abstützt.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(dateiname), "UTF-8"));

        String zeile = reader.readLine();  // erste Zeile einlesen

        /* Aus dem Zeichenstrom lesen, solange noch Zeilen gelesen
         * werden können. Kann keine weitere Zeile mehr gelesen
         * werden, liefert readLine() null.
         */
        while (zeile != null) {
            anzeige.println(zeile);
            zeile = reader.readLine();
        }

        /* BufferedReader schließen. Zu jedem Öffnen muss es immer ein
         * passendes Schließen geben.
         */
        reader.close();
    }

    /**
     * Liest einen String zeilenweise ein und gibt die eingelesenen
     * Zeilen aus. Das Einlesen erfolgt über die Klasse BufferedReader,
     * die sich intern auf StringReader abstützt.<br/>
     *
     * Diese Methode veranschaulicht, dass durch einen BufferedReader
     * nicht nur Dateien gelesen werden können. Durch Austausch des
     * Readers, der beim Konstruieren des BufferedReader übergeben
     * wird, ist ein Zugriff auf andere Datenquellen möglich. Hier
     * wird ein StringReader übergeben, durch den auf einen String
     * als Datenquelle zugegriffen wird.<br/>
     *
     * Diese Methode unterscheidet sich von <CODE>liesZeilenAusDatei</CODE>
     * nur durch die Zeile, in der der BufferedReader erzeugt wird.
     *
     * @param text  String, aus dem gelesen wird
     * @throws IOException  wird bei einem I/O-Problem ausgelöst
     */
    private static void liesZeilenAusString(String text)
        throws IOException {

        /* Textanzeige zur Ausgabe erzeugen.
         */
        Textanzeige anzeige = new Textanzeige();

        /* Beim Konstruieren des BufferedReader wird ein Objekt
         * der Klasse StringReader übergeben, auf die sich
         * der BufferedReader intern abstützt.
         */
        BufferedReader reader = new BufferedReader(new StringReader(text));

        String zeile = reader.readLine();  // erste Zeile einlesen

        /* Aus dem Zeichenstrom lesen, solange noch Zeilen gelesen
         * werden können. Kann keine weitere Zeile mehr gelesen
         * werden, liefert readLine() null.
         */
        while (zeile != null) {
            anzeige.println(zeile);
            zeile = reader.readLine();
        }

        /* BufferedReader schließen. Zu jedem Öffnen muss es immer ein
         * passendes Schließen geben.
         */
        reader.close();
    }

    /**
     * Liest aus einer zeichenorientierten Datenquelle zeilenweise
     * und gibt die eingelesenen Zeilen aus.<br/>
     *
     * Diese Methode veranschaulicht, dass das Einlesen aus
     * einer Datenquelle völlig von der Datenquelle entkoppelt
     * werden kann. Es wird ein Reader übergeben, von dem hier
     * nicht bekannt ist, auf welche Datenquelle tatsächlich
     * zugegriffen wird. Diese Entscheidung liegt einzig bei
     * dem Aufrufer der Methode. Übergibt er ein Objekt der
     * Klasse StringReader, wird auf einen String zugegriffen.
     * Übergibt er ein Objekt der Klasse InputStreamReader
     * (die intern auf einen FileInputStream zugreift), dann
     * wird aus einer Datei gelesen.<br/>
     *
     * Diese Methode unterscheidet sich von <CODE>liesZeilenAusDatei</CODE>
     * nur durch die Zeile, in der der BufferedReader erzeugt wird.
     *
     * @param einReader  Objekt einer Unterklasse von
     *        <CODE>Reader</CODE>, durch die die Datenquelle
     *        festgelegt wird
     * @throws IOException  wird bei einem I/O-Problem ausgelöst
     */
    private static void liesZeilenAusReader(Reader einReader)
        throws IOException {

        /* Textanzeige zur Ausgabe erzeugen.
         */
        Textanzeige anzeige = new Textanzeige();

        BufferedReader reader = new BufferedReader(einReader);

        String zeile = reader.readLine();  // erste Zeile einlesen

        /* Aus dem Zeichenstrom lesen, solange noch Zeilen gelesen
         * werden können. Kann keine weitere Zeile mehr gelesen
         * werden, liefert readLine() null.
         */
        while (zeile != null) {
            anzeige.println(zeile);
            zeile = reader.readLine();
        }

        /* BufferedReader schließen. Zu jedem Öffnen muss es immer ein
         * passendes Schließen geben.
         */
        reader.close();
    }

    /**
     * Schreibt eine Folge von Bytes in eine Datei.
     *
     * @param bytes  Array mit Bytes, die geschrieben werden
     * @param dateiname  Name der Datei, in die geschrieben wird
     * @throws FileNotFoundException  wird beim Erzeugen des
     *         FileOutputStream ausgelöst, wenn die Datei mit
     *         dem angegebenen Namen nicht angelegt werden kann
     * @throws IOException  wird bei einem I/O-Problem ausgelöst
     */
    private static void schreibeBytesInDatei(byte[] bytes, String dateiname)
        throws FileNotFoundException, IOException {

        /* Beim Konstruieren eines FileOutputStream wird der
         * Dateiname übergeben. (Es gibt andere Konstruktoren,
         * bei denen die Datei nicht durch ihren Namen angegeben
         * wird.) Beim Konstruieren wird die Datei zum Schreiben geöffnet.
         */
        FileOutputStream stream = new FileOutputStream(dateiname);

        /* write schreibt alle Bytes des übergebenen Arrays in den Strom. */
        stream.write(bytes);

        /* Bytestrom schließen. Zu jedem Öffnen muss es immer ein
         * passendes Schließen geben.
         */
        stream.close();
    }

    /**
     * So wie <CODE>Reader</CODE> die Oberklasse aller Klassen
     * ist, durch die zeichenweise aus Datenquellen gelesen werden
     * kann, so ist <CODE>Writer</CODE> die Oberklasse aller
     * Klassen, durch die zeichenweise in Datensenken geschrieben
     * werden kann.<br/>
     *
     * Diese Methode schreibt die Zeichen eines String in eine
     * Datensenke, die durch den übergebenen Writer angegeben wird.
     * Analog zu BufferedReader ist PrintWriter eine
     * Bequemlichkeitsklasse. Sie bietet Methoden print und println,
     * durch die skalare Werte und Objekte geschrieben werden können.
     *
     * @param s  Zeichenkette, die in Writer geschrieben wird
     * @param einWriter  Objekt einer Unterklasse von
     *        <CODE>Writer</CODE>, durch die die Datensenke
     *        festgelegt wird
     */
    private static void schreibeInWriter(String s, Writer einWriter) {

        PrintWriter writer = new PrintWriter(einWriter);

        writer.println(s);  // s in Datensenke schreiben

        /* Zeichenstrom schließen. Zu jedem Öffnen muss es immer ein
         * passendes Schließen geben.
         */
        writer.close();
    }

    /**
     * Aufrufe der Methoden zur Veranschaulichung des Verhaltens
     * von Klassen zur Ein- und Ausgabe.
     *
     * @param args  wird nicht verwendet
     * @throws FileNotFoundException  wird ausgelöst, wenn eine
     *         Datei mit einem bestimmten Namen nicht geöffnet
     *         werden kann
     * @throws IOException  wird bei einem I/O-Problem ausgelöst
     */
    public static void main(String[] args)
        throws FileNotFoundException, IOException {

        Reader reader;
        StringWriter writer;

        String text = "Das Reh springt hoch, das Reh springt weit,\n"
                + "warum auch nicht - es hat ja Zeit.\n"
                + "  (Heinz Erhardt)";

        // ---------------- Lesen aus Datenquellen ----------------

//        liesBytesAusDatei(VERZEICHNIS + "SeiteD.html");
//        liesBytesAusDatei(VERZEICHNIS + "SeiteRU.html");

//        liesCharsAusDatei(VERZEICHNIS + "SeiteRU.html");
//        liesCharsAusDatei(VERZEICHNIS + "SeiteD.html");

//        liesZeilenAusDatei(VERZEICHNIS + "SeiteRU.html");

        /* String zeilenweise einlesen und gesamte Zeichenfolge in einem
         * Fenster anzeigen.
         */
//        liesZeilenAusString(text);

        /* Aus einem Reader zeilenweise lesen und gesamte Zeichenfolge
         * in einem Fenster anzeigen. Beim Aufruf muss durch übergabe
         * des Reader die tatsächliche Datenquelle festgelegt werden.
         */
//        reader = new StringReader(text);
//        liesZeilenAusReader(reader);

        /* Das gleiche, jetzt aber mit einem Reader für eine Datei.
         * Kommentieren Sie jeweils eine der beiden folgenden
         * Zuweisungen aus.
         */
//        reader = new InputStreamReader(new FileInputStream(
//                VERZEICHNIS + "SeiteD_Umlaute_UTF-8.html"), "UTF-8");
//        reader = new InputStreamReader(new FileInputStream(
//                VERZEICHNIS + "SeiteD_Umlaute_ISO.html"), "ISO-8859-1");
//        liesZeilenAusReader(reader);

        /* Für den zeichenweisen Zugriff auf eine Datei unter
         * Verwendung des Standard-Encodings gibt es die Klasse
         * FileReader. Das Erzeugen eines FileReader entspricht
         * dem Erzeugen eines InputStreamReader für einen
         * FileInputStream mit Standard-Encoding.
         */
//        reader = new FileReader(VERZEICHNIS + "SeiteD_Umlaute_UTF-8.html");
//        liesZeilenAusReader(reader);

        /* Etwas ähnliches, jetzt aber mit einem Reader, durch den auf die
         * Tastatur als Datenquelle zugegriffen wird. System.in enthält
         * einen InputStream zum byte-weisen Einlesen von der Tastatur.
         * Dieser InputStream wird einem InputStreamReader übergeben.
         */
//        reader = new InputStreamReader(System.in);
//        liesZeilenAusReader(reader);


        // ---------------- Schreiben in Datensenken ----------------

        /* Eine Folge von Bytes über einen FileOutputStream in eine
         * Datei schreiben. Die Byte-Folge enthält die Codes für die
         * Ziffern 0 bis 9.
         */
//        schreibeBytesInDatei(new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57},
//                VERZEICHNIS + "Bytefolge.txt");

        /* Ein FileOutputStream ermöglicht die byteweise Ausgabe
         * in eine Datei (vgl. FileInputStream).
         * Ein OutputStreamWriter ermöglicht die Ausgabe von
         * Zeichen (vgl. InputStreamReader).
         * Für die Konvertierung von Zeichen in Bytes wird ein Encoding
         * angegeben. Deutsche Umlaute werden im Encoding UTF-8 durch
         * 2 Byte dargestellt.
         */
//        schreibeInWriter("Umlaute sind äöüß.",
//                new OutputStreamWriter(new FileOutputStream(
//                    VERZEICHNIS + "Zeichenfolge_ISO.txt"), "ISO-8859-1"));
//        schreibeInWriter("Umlaute sind äöüß.",
//                new OutputStreamWriter(new FileOutputStream(
//                    VERZEICHNIS + "Zeichenfolge_UTF-8.txt"), "UTF-8"));

        /* Zum zeichenweisen Schreiben in eine Datei unter
         * Verwendung des Standard-Encodings gibt es die Klasse
         * FileWriter. Das Erzeugen eines FileWriter entspricht
         * dem Erzeugen eines OutputStreamWriter für einen
         * FileOutputStream mit Standard-Encoding.
         */
//        schreibeInWriter("Umlaute sind äöüß.",
//                new FileWriter(VERZEICHNIS + "Zeichenfolge.txt"));

        /* Soll eine Methode, die einen Writer als Parameter besitzt,
         * zur Ausgabe auf den Bildschirm genutzt werden, muss dafür ein
         * entsprechender Writer erzeugt werden.
         * System.out enthält einen PrintStream, durch den die Ausgabe von
         * Bytes möglich ist. Mit diesem PrintStream als Parameter wird
         * ein Writer erzeugt, der der Methode schreibeInWriter übergeben
         * wird. Dadurch erfolgt die Ausgabe auf den Bildschirm.
         */
//        schreibeInWriter("Umlaute sind äöüß.",
//                new OutputStreamWriter(System.out));

        /* Ein StringWriter ermöglicht die Ausgabe in einen StringBuffer
         * (vgl. StringReader).
         */
//        writer = new StringWriter();
//        schreibeInWriter("Umlaute sind äöüß.", writer);
//        System.out.println(writer.toString());
    }
}
