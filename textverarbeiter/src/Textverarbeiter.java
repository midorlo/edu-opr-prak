import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Textverarbeiter {
    public static final String TRENNZEICHEN = " .,:;!?-()";
    private Wortverarbeiter wortverarbeiter;

    public Textverarbeiter(Wortverarbeiter eingabeWortverarbeiter) {
        wortverarbeiter = eingabeWortverarbeiter;
    }

    void verarbeite(Reader eingabeDatenquelle) throws IOException {
        BufferedReader zeilenLeser = new BufferedReader(eingabeDatenquelle);
        String ausgeleseneZeile = zeilenLeser.readLine();
        StringTokenizer tokenizer;

        while (ausgeleseneZeile != null) {
            tokenizer = new StringTokenizer(ausgeleseneZeile,
                Textverarbeiter.TRENNZEICHEN);
            while (tokenizer.hasMoreTokens()) {
                this.wortverarbeiter.verarbeite(tokenizer.nextToken());
            }

            ausgeleseneZeile = zeilenLeser.readLine();
            this.wortverarbeiter.verarbeiteZeilenende();
        }
    }
}
