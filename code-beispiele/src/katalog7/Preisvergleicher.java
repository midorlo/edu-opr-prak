package katalog7;

import java.util.Comparator;

/**
 * Comparator, der den Preis zweier Objekte der Schnittstelle
 * Verkaufbares vergleicht.
 */
public class Preisvergleicher implements Comparator {

    /**
     * Vergleicht zwei Objekte der Schnittstelle Verkaufbares
     * bzgl. ihrer Preise. Wirft eine ClassCastException, wenn
     * die Objekte nicht die Schnittstelle erfüllen.
     *
     * @param obj1  erstes Objekt
     * @param obj2  zweites Objekt
     * @return -1, falls der Preis des ersten Objekts kleiner
     *         als der des zweiten ist; 0, falls die Preise gleich
     *         sind; sonst 1
     */
    @Override
    public int compare(Object obj1, Object obj2) {

        Verkaufbares verkaufbares1 = (Verkaufbares) obj1;
        Verkaufbares verkaufbares2 = (Verkaufbares) obj2;

        return (int) Math.signum(verkaufbares1.gibPreis()
                                 - verkaufbares2.gibPreis());
    }
}
