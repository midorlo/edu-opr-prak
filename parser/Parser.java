import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Parser zum parsen von Termausdruecken.
 */
public class Parser {

    /** Konstante fuer Rechenzeichen + .*/
    private static final char PLUS = '+';
    /** Konstante fuer Rechenzeichen - .*/
    private static final char MINUS = '-';
    /** Konstante fuer Rechenzeichen * .*/
    private static final char MAL = '*';
    /** Konstante fuer Rechenzeichen / .*/
    private static final char GETEILT = '/';
    /** Regex Ausdruck fuer eine Konstante. */
    private static final String KONSTANTE = "[0-9]+";
    /** Regex Ausdruck fuer eine Variable. */
    private static final String VARIABLE = "[a-zA-Z][a-zA-Z0-9]*";
    /** Konstante fuer ( .*/
    private static final char KLAMMER_AUF = '(';
    /** Konstante fuer ) .*/
    private static final char KLAMMER_ZU = ')';
    /** Trennzeichen fuer das Zerlegen des Terms. */
    private static final String TRENNZEICHEN = "+-*/ ()";
    /** Konstante fuer ein Leerzeichen. */
    private static final char LEERZEICHEN = ' ';
    /** Fehlermeldung fuer unerwartetes Ende. */
    private static final String MELDUNG_UNERWARTETES_ENDE = "unerwartetes Ende";
    /** Fehlermeldung fuer ungueltiges Token. */
    private static final String MELDUNG_UNGUELTIGES_TOKEN
            = "ungueltiges Token ";
    /** Liste in der alle Tokens gespeichert werden. */
    private List<String> tokens;
    /** Die Anzahl der Toekens die eingelesen wurden. */
    private int tokenAnzahl;


    /**
     * Erzeugt ein Parser Objekt.
     */
    public Parser() {
    }

    /**
     * Parst den uerbergeben Term.
     * @param term Term als String
     * @return erzeugter Operatorausdruck
     * @throws ParseException Fehler beim Parsen
     */
    public Ausdruck parse(String term) throws ParseException {
        Ausdruck geparsterAusdruck;
        /* Dafuer sorgen das die Liste auf jeden Fall leer ist, also wird sie
         * erst hier initialsiert und nicht im Konstruktor */
        this.tokens = new LinkedList<String>();
        StringTokenizer tokenizer = new StringTokenizer(term, TRENNZEICHEN,
                                                            true);

        while (tokenizer.hasMoreTokens()) {
            String element = tokenizer.nextToken();
            if (element.charAt(0) != LEERZEICHEN) {
                this.tokens.add(element);
            }
        }
        this.tokenAnzahl = this.tokens.size();
        
//        if (this.tokenAnzahl == 0) {
//            throw new ParseException(MELDUNG_UNERWARTETES_ENDE, 0);
//        }

        geparsterAusdruck = parseAusdruck();


        /* Der Parser lief ohne Probleme durch, jedoch sind noch Tokens
         * vorhanden, dies ist dann jedoch ein Token, welches nicht folgen darf
         */
        if (!this.tokens.isEmpty()) {
            throw new ParseException(MELDUNG_UNGUELTIGES_TOKEN 
                                         + this.tokens.get(0),
                                    this.tokenAnzahl - this.tokens.size() + 1);
        }

        return geparsterAusdruck;
    }


    /**
     * Abschnitt des Parsers, der einen Ausdruck parst.
     * @return gibt einen OperatorAusdruck zurueck.
     * @throws ParseException Fehler beim Parsen.
     */
    private Ausdruck parseAusdruck() throws ParseException {
        Ausdruck ausdruckLinks;
        char operator;
        Ausdruck ausdruckRechts;

        ausdruckLinks = parseSummand();

        while (!this.tokens.isEmpty() && (this.tokens.get(0).charAt(0) == PLUS
                                       || this.tokens.get(0).charAt(0)
                                             == MINUS)) {
            operator = this.tokens.remove(0).charAt(0);

//            if (!this.tokens.isEmpty()) {
                ausdruckRechts = parseSummand();
//            } else {
//                throw new ParseException(MELDUNG_UNERWARTETES_ENDE, 0);
//            }

            ausdruckLinks = new OperatorAusdruck(ausdruckLinks, operator, 
                                                 ausdruckRechts);

        }

        return ausdruckLinks;
    }


    /**
     * Abschnitt des Parsers, der einen Summanden parst.
     * @return gibt einen OperatorAusdruck zurueck.
     * @throws ParseException Fehler beim Parsen.
     */
    private Ausdruck parseSummand() throws ParseException {
        Ausdruck ausdruckLinks;
        char operator;
        Ausdruck ausdruckRechts;

        ausdruckLinks = parseFaktor();

        while (!this.tokens.isEmpty() && (this.tokens.get(0).charAt(0) == MAL
                                       || this.tokens.get(0).charAt(0)
                                             == GETEILT)) {
            operator = this.tokens.remove(0).charAt(0);

//            if (!this.tokens.isEmpty()) {
                ausdruckRechts = parseFaktor();
//            } else {
//                throw new ParseException(MELDUNG_UNERWARTETES_ENDE, 0);
//            }

            ausdruckLinks = new OperatorAusdruck(ausdruckLinks, operator,
                                                 ausdruckRechts);
        }

        return ausdruckLinks;
    }

    /**
     * Abschnitt des Parsers, der einen Faktor parst.
     * @return gibt einen einzelnen Ausdruck zurueck.
     * @throws ParseException Fehler beim Parsen.
     */
    private Ausdruck parseFaktor() throws ParseException {
        Ausdruck rueckgabe;

        if(!this.tokens.isEmpty()) {
            String aktuellesToken = this.tokens.remove(0);
            if (aktuellesToken.matches(KONSTANTE)) {
                rueckgabe = new Konstante(Integer.parseInt(aktuellesToken));
            } else if (aktuellesToken.matches(VARIABLE)) {
                rueckgabe = new Variable(aktuellesToken);
            } else if (aktuellesToken.charAt(0) == KLAMMER_AUF) {
                rueckgabe = parseAusdruck();
                if (this.tokens.isEmpty()) {
                    throw new ParseException(MELDUNG_UNERWARTETES_ENDE, 0);
                } else if (this.tokens.get(0).charAt(0) != KLAMMER_ZU) {
                    throw new ParseException(MELDUNG_UNGUELTIGES_TOKEN
                                                + this.tokens.get(0),
                                           this.tokenAnzahl - this.tokens.size()
                                                + 1);
                } else {
                    /* Es war eine Klammer, also entfernen */
                    this.tokens.remove(0);
                }
            } else {
                throw new ParseException(MELDUNG_UNGUELTIGES_TOKEN
                        + aktuellesToken, this.tokenAnzahl - this.tokens.size());
            }
        } else {
            throw new ParseException(MELDUNG_UNERWARTETES_ENDE, 0);
        }
        return rueckgabe;
    }
    
}
