package katalog7;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse dient dazu, die Verwendung der Schnittstellen
 * Comparable und Comparator zu veranschaulichen.
 */
public class CompareTest {

    /**
     * Gibt die Elemente einer Liste aus.
     * System.out.println(liste) wäre kürzer, dann werden aber
     * alle Elemente in einer Zeile ausgegeben.
     *
     * @param liste  Liste, deren Elemente ausgegeben werden
     */
    private static void gibAus(List liste) {

        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i));
        }
    }

    /**
     * Erzeugt eine Liste mit vier Büchern.
     *
     * @return Bücherliste
     */
    private static List erzeugeBuecherliste() {

        ArrayList buecher = new ArrayList();

        buecher.add(new Buch("Tränen zum Abschied", "Billi Groman",
                             2.55f, 2004));
        buecher.add(new Buch("Der Bergdoktor am Abgrund der Liebe",
                             "B. Lödsinn", 2.95f, 2004));
        buecher.add(new Buch("Ein Abschied mit Tränen", "Billi Groman",
                             2.65f, 2004));
        buecher.add(new Buch("Tränen im Knopfloch", "Helge Schneider",
                             12.85f, 2004));

        return buecher;
    }

    /**
     * Sortiert eine Liste von Büchern nach deren
     * natürlicher Ordnung.
     */
    private static void testBuecherAlphabetisch() {

        List buecher = erzeugeBuecherliste();

        Collections.sort(buecher);
        gibAus(buecher);
    }

    /**
     * Sortiert eine Liste von Büchern nach ihrem Preis.
     */
    private static void testBuecherNachPreis() {

        List buecher = erzeugeBuecherliste();

        Collections.sort(buecher, new Preisvergleicher());
        gibAus(buecher);
    }

    /**
     * Sortiert eine Liste von Büchern vorrangig nach
     * ihrem Autor und bei gleichem Autor nach ihrem Preis.
     */
    private static void testBuecherNachAutorUndPreis() {

        List buecher = erzeugeBuecherliste();

        /* Erzeuge Objekt einer Comparator-Klasse, durch die
         * zwei Bücher verglichen werden können. Ein Buch ist
         * "kleiner" als ein anderes, wenn sein Autor alphabetisch
         * vor dem anderen Autor steht. Bei gleichem Autor entscheidet
         * der kleinere Preis.
         */
        Comparator vergleicher = new Comparator() {

            @Override
            public int compare(Object obj1, Object obj2) {

                Buch buch1 = (Buch) obj1;
                Buch buch2 = (Buch) obj2;

                int vergleichswert =
                        buch1.gibAutor().compareTo(buch2.gibAutor());
                if (vergleichswert == 0) {
                    vergleichswert = (int) Math.signum(buch1.gibPreis()
                                                       - buch2.gibPreis());
                }
                return vergleichswert;
            }
        };

        Collections.sort(buecher, vergleicher);
        gibAus(buecher);
    }

    /**
     * Ruft Testmethoden auf.
     *
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        testBuecherAlphabetisch();
        testBuecherNachPreis();
        testBuecherNachAutorUndPreis();
    }
}
