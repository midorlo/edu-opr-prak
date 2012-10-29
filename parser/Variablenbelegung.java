
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Enthält Konstruktor Variablenbelegung(), durch den eine Variablenbelegung
 * erzeugt wird, in der zunächst keiner Variablen ein Wert zugeordnet ist.
 * Enthält Instanzmethode void belege(String, int), durch die einer Variablen
 * (1.Parameter) ein Wert (2. Parameter) zugeordnet wird. Ein evtl. vorhandener
 * alter Wert wird dabei überschrieben. Enthält Instanzmethode int
 * gibWert(String), die den Wert liefert, der der angegebenen Variable
 * zugeordnet ist.
 *
 * @author apex
 */
public class Variablenbelegung {

    public HashMap<String, Integer> variablen;
    
    public Variablenbelegung() {
        variablen = new HashMap <String, Integer>();
    }

    public void belege(String var, int wert) {
        this.variablen.put(var, wert);
    }

    public int gibWert(String var) {
        return this.variablen.get(var);
    }
}
