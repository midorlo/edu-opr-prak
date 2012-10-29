package ausnahmen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Klasse mit statischen Methoden zur Ein-/Ausgabe.
 */
public class EinAusgabe {

    /**
     * Zeigt übergebenen Führungstext an und liest Eingabe
     * von der Tastatur. Eingabe wird als Ergebnis geliefert.
     *
     * @param prompt  Führungstext
     * @return Eingabe von der Tastatur
     * @throws IOException  Ausnahme beim Lesen von Tastatur
     *         wird weitergereicht
     */
    public static String liesVonTastatur(String prompt) throws IOException {

        System.out.print(prompt);
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
