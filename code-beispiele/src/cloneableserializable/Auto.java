package cloneableserializable;

import katalog7.Verkaufbares;

/**
 * Ein Objekt dieser Klasse repräsentiert ein Auto.
 */
public class Auto extends Motorfahrzeug
        implements Cloneable, Verkaufbares {

    /** Preis dieses Autos. */
    private float preis;

    /**
     * Erzeugt ein neues Objekt dieser Klasse mit den angegebenen Daten.
     *
     * @param bezeichnung  Bezeichnung dieses Autos
     * @param leistung  Leistung dieses Autos in kW
     * @param baujahr  Baujahr dieses Autos (vierstellig)
     * @param preis  Preis dieses Autos
     */
    public Auto(String bezeichnung, int leistung, int baujahr, float preis) {

        super(bezeichnung, leistung, baujahr);
        this.preis = preis;
    }

    /**
     * Prüft, ob dieses Auto zum Suchbegriff passt. Es passt, wenn
     * seine Bezeichnung den Suchbegriff enthält.
     *
     * @param suchbegriff  Begriff, für den geprüft wird,
     *         ob dieses Auto dazu passt
     * @return <code>true</code> genau dann, wenn dieses Auto
     *         zum Suchbegriff passt
     */
    @Override
    public boolean passtZu(String suchbegriff) {

        return (this.bezeichnung.indexOf(suchbegriff) >= 0);
    }

    /**
     * Liefert textuelle Darstellung dieses Autos.
     *
     * @return Bezeichnung dieses Autos, Leistung, Baujahr und Preis
     */
    @Override
    public String gibText() {

        return this.bezeichnung + ", "
               + this.leistung + "kW, "
               + "Baujahr " + this.baujahr
               + ", " + this.preis + "€";
    }

    /**
     * Liefert den Preis dieses Autos.
     *
     * @return Preis dieses Autos
     */
    @Override
    public float gibPreis() {

        return preis;
    }

    /**
     * Erzeugt eine Kopie dieses Autos.
     *
     * @return Kopie dieses Autos
     */
    @Override
    public Object clone() {

        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {

            /* Diese Klasse unterstützt Clonen. Deshalb kann diese
             * Ausnahme nicht auftreten. Falls sie doch auftritt,
             * wird ein Error geworfen, der ein unbekanntes Problem
             * in der JVM anzeigt.
             */
            throw new InternalError();
        }
    }
}
