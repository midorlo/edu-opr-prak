/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Enthält Konstruktor OperatorAusdruck(Ausdruck, char, Ausdruck), durch den ein
 * arithmetischer Ausdruck mit den angegebenen Teilausdrücken und dem
 * Operatorsymbol erzeugt wird.
 *
 * @author apex
 */
public class OperatorAusdruck extends Ausdruck {
    
    private int ergebnis;
    private Ausdruck erstAusdruck;

    @Override
    public String toString() {
        return "OperatorAusdruck{" + "ergebnis=" + ergebnis + ", erstAusdruck=" 
                + erstAusdruck + ", operator=" + operator + ", zweitAusdruck=" 
                + zweitAusdruck + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OperatorAusdruck other = (OperatorAusdruck) obj;
        if (this.ergebnis != other.ergebnis) {
            return false;
        }
        if (this.erstAusdruck != other.erstAusdruck && (this.erstAusdruck == null || !this.erstAusdruck.equals(other.erstAusdruck))) {
            return false;
        }
        if (this.operator != other.operator) {
            return false;
        }
        if (this.zweitAusdruck != other.zweitAusdruck && (this.zweitAusdruck == null || !this.zweitAusdruck.equals(other.zweitAusdruck))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.ergebnis;
        hash = 71 * hash + (this.erstAusdruck != null ? this.erstAusdruck.hashCode() : 0);
        hash = 71 * hash + this.operator;
        hash = 71 * hash + (this.zweitAusdruck != null ? this.zweitAusdruck.hashCode() : 0);
        return hash;
    }
    private char operator;
    private Ausdruck zweitAusdruck;
    

    public OperatorAusdruck(Ausdruck erstAusdruck, char operator, Ausdruck zweitAusdruck) {
        this.erstAusdruck = erstAusdruck;
        this.zweitAusdruck = zweitAusdruck;
        this.operator = operator;
    }
    
    public void berechneErgebnis(Variablenbelegung belegung) {
        
        switch (this.operator) {
            case '+':
                this.ergebnis = this.erstAusdruck.gibWert(belegung) + this.zweitAusdruck.gibWert(belegung);
                break;
            case '-':
                this.ergebnis = this.erstAusdruck.gibWert(belegung) - this.zweitAusdruck.gibWert(belegung);
                break;
            case '*':
                this.ergebnis = this.erstAusdruck.gibWert(belegung) * this.zweitAusdruck.gibWert(belegung);
                break;
            case '/':
                this.ergebnis = this.erstAusdruck.gibWert(belegung) / this.zweitAusdruck.gibWert(belegung);
                break;       
        }
        

    }

    @Override
    public int gibWert(Variablenbelegung belegung) {
        berechneErgebnis(belegung);
        return this.ergebnis;
    }
}
