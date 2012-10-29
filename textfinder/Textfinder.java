
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author apex
 */
public class Textfinder {

    private HashMap<String, Integer> woerter;

    /**
     * 
     * @param data
     * @param laenge
     * @throws IOException 
     */
    public Textfinder(InputStream data, int laenge) throws IOException {

        this.woerter = new HashMap<String, Integer>();

        int symbol = data.read();

        while (symbol != -1) {

            StringBuilder wort = new StringBuilder();

            while (istValide(symbol)) {

                wort.append((char) symbol);
                symbol = data.read();

            }

            if (wort.length() >= laenge) {
                if (!woerter.containsKey(wort.toString())) {
                    woerter.put(wort.toString(), 1);
                } else {
                    this.woerter.put(wort.toString(), 
                            this.woerter.get(wort.toString()).intValue() + 1);
                }
            }

            symbol = data.read();

        }

    }

    /**
     * 
     * @return 
     */
    public Set gibWoerter() {
        return this.woerter.keySet();
    }

    /**
     * 
     * @param wort
     * @return 
     */
    public int gibHaeufigkeit(String wort) {
        int ergebnis = 0;

        if (woerter.containsKey(wort)) {
            ergebnis = woerter.get(wort);
        }

        return ergebnis;

    }

    /**
     * 
     * @param symbol
     * @return 
     */
    private boolean istValide(int symbol) {
        boolean ergebnis = false;

        if ((symbol >= 'a' && symbol <= 'z')
                || (symbol >= 'A' && symbol <= 'Z')
                || (symbol >= '0' && symbol <= '9')) {
            ergebnis = true;
        }

        return ergebnis;
    }
}
