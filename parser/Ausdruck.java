/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Enthält abstrakte Instanzmethode int gibWert(Variablenbelegung), die den Wert
 * dieses Ausdrucks basierend auf der Variablenbelegung liefert.
 *
 * @author apex
 */
public abstract class Ausdruck {

    @Override
    public String toString() {
        return "Ausdruck{" + '}';
    }

     //NOTE: skript s.96
    public abstract int gibWert(Variablenbelegung belegung);
}
