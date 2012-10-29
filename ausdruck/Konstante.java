/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Enthält Konstruktor Konstante(int), durch den ein konstanter Ausdruck mit dem
 * angegebenen Wert erzeugt wird.
 *
 * @author apex
 */
public class Konstante extends Ausdruck {

    public Konstante(int wert) {
    }

    @Override
    public int gibWert(Variablenbelegung belegung) {
        return 0;
    }
}
