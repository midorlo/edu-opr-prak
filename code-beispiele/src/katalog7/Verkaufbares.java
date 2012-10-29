package katalog7;

/**
 * Dieses Interface legt die Methoden fest, die verkaufbare Objekte
 * anbieten müssen.
 */
public interface Verkaufbares {

    /**
     * Prüft, ob dieses Objekt zum Suchbegriff passt.
     *
     * @param suchbegriff  Begriff, für den geprüft wird, ob dieses
     *        Objekt dazu passt
     * @return <code>true</code> genau dann, wenn dieses Objekt
     *         zum Suchbegriff passt
     */
    boolean passtZu(String suchbegriff);

    /**
     * Liefert textuelle Darstellung dieses Objekts zur Darstellung
     * in einem Katalog.
     *
     * @return textuelle Darstellung
     */
    String gibText();

    /**
     * Liefert den Preis dieses verkaufbaren Objekts.
     *
     * @return Preis dieses Objekts
     */
    float gibPreis();
}
