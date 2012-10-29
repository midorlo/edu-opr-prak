package cloneableserializable;

import java.io.Serializable;

/**
 * Ein Objekt dieser Klasse repräsentiert ein Motorfahrzeug.
 */
public class Motorfahrzeug implements Serializable {

    /** Bezeichnung dieses Fahrzeugs. */
    protected String bezeichnung;

    /** Leistung dieses Fahrzeugs. */
    protected int leistung;

    /** Baujahr dieses Fahrzeugs. */
    protected int baujahr;

    /**
     * Erzeugt ein neues Objekt dieser Klasse mit den angegebenen Daten.
     *
     * @param bezeichnung  Bezeichnung dieses Fahrzeugs
     * @param leistung  Leistung dieses Fahrzeugs in kW
     * @param baujahr  Baujahr dieses Fahrzeugs (vierstellig)
     */
    public Motorfahrzeug(String bezeichnung, int leistung, int baujahr) {

        this.bezeichnung = bezeichnung;
        this.leistung = leistung;
        this.baujahr = baujahr;
    }
}
