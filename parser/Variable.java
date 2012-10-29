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

    @Override
    public String toString() {
        return "Variable{" + "titel=" + titel + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Variable other = (Variable) obj;
        if ((this.titel == null) 
                ? (other.titel != null) 
                : !this.titel.equals(other.titel)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.titel != null ? this.titel.hashCode() : 0);
        return hash;
    }

    private String titel;
    
    public Variable(String titel) {
         this.titel = titel;  
    }

    @Override
    public int gibWert(Variablenbelegung belegung) {
        return belegung.gibWert(this.titel);
    }


}
