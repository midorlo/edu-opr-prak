/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Enthält Konstruktor Variable(String), durch den eine Variable mit dem
 * angegebenen Namen erzeugt wird.
 *
 * @author apex
 */
public class Variable extends Ausdruck {

    public Variable(String titel) {
    }

    @Override
    public int gibWert(Variablenbelegung belegung) {
        return 0;
    }
}
