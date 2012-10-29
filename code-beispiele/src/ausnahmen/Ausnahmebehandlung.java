package ausnahmen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Diese Klasse veranschaulicht allgemein wiederkehrerende "Muster"
 * bei der Behandlung von Ausnahmen.
 */
public class Ausnahmebehandlung {

    /**
     * Liest Zeichenketten von der Tastatur und gibt aus, ob es sich
     * um Darstellungen ganzer Zahlen handelt. Methode endet, wenn
     * der Text "Ende" eingegeben wird.
     *
     * @throws IOException  Ausnahme beim Lesen von Tastatur
     *         wird weitergereicht
     */
    private static void erkenneZahlen() throws IOException {

        String zeile = EinAusgabe.liesVonTastatur("Eingabe: ");
        while (!"Ende".equalsIgnoreCase(zeile)) {
            try {

                /* dargestellten Wert ermitteln
                 */
                int zahl = Integer.parseInt(zeile);

                System.out.println(zahl + " ist ein int-Wert.");

            } catch (NumberFormatException e) {

                /* keine gültige int-Darstellung
                 */
                System.out.println(zeile + " ist kein int-Wert.");
            }
            zeile = EinAusgabe.liesVonTastatur("Eingabe: ");
        }
    }

    /**
     * Liest solange von der Tastatur, bis ein gültiger Dateiname
     * eingegeben wird.
     *
     * @throws IOException  Ausnahme beim Lesen von Tastatur oder
     *         Dateizugriff wird weitergereicht
     */
    private static void liesDateiname() throws IOException {

        /* gibt an, ob Dateiname gültig ist
         */
        boolean istDateinameGueltig = false;

        String dateiname = "";

        /* Iterieren, solange Dateiname ungültig ist.
         */
        while (!istDateinameGueltig) {

            dateiname = EinAusgabe.liesVonTastatur("Eingabe: ");

            try {

                /* Versuch, auf Datei mit angegebenem Namen zuzugreifen
                 */
                FileReader reader = new FileReader(dateiname);

                /* Die folgende Anweisung wird nur erreicht, wenn ein Reader
                 * für die Eingabe erzeugt werden konnte. Dies bedeutet, die
                 * Eingabe ist der Name einer gültigen Datei.
                 */
                istDateinameGueltig = true;
                reader.close();

            } catch (FileNotFoundException e) {

                /* kein gültiger Dateiname
                 */
                System.out.println("Der Dateiname " + dateiname
                                   + " ist nicht gültig.");
            }
        }
        System.out.println("Der Dateiname " + dateiname + " ist gültig.");
    }

    /**
     * Führt die Testmethoden aus.
     *
     * @param args  wird nicht verwendet
     * @throws IOException  Ausnahme beim Lesen von Tastatur oder
     *         Dateizugriff wird weitergereicht
     */
    public static void main(String[] args) throws IOException {

        erkenneZahlen();
//        liesDateiname();
    }
}
