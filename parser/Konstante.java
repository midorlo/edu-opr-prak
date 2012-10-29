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
    private int wert;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Konstante other = (Konstante) obj;
        if (this.wert != other.wert) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.wert;
        return hash;
    }

    @Override
    public String toString() {
        return "Konstante{" + "wert=" + wert + '}';
    }
    
    public Konstante(int wert) {
        this.wert = wert;
    }

    @Override
    public int gibWert(Variablenbelegung belegung) {
        return wert;
    }
}
