import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.sort;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Indexierer implements Wortverarbeiter {
    private HashMap<String, HashSet<Integer>> gefundeneWoerter;
    private HashSet<String> ausschlussWoerter;
    private int zeilenIndex;

    public Indexierer(Collection ausschlussWoerter) {
        this.gefundeneWoerter = new HashMap<String, HashSet<Integer>>();
        this.ausschlussWoerter = new HashSet<String>();
        this.zeilenIndex = 1;

        Iterator<String> iterator = ausschlussWoerter.iterator();
        while (iterator.hasNext()) {
            this.ausschlussWoerter.add(iterator.next());
        }
    }
    
    public List gibWoerter() {
        ArrayList<String> rueckgabeListe =
                new ArrayList<String>(this.gefundeneWoerter.keySet());
        sort(rueckgabeListe);
        return rueckgabeListe;
    }

    public String gibZeilennummern(String gesuchtesWort) {
        String rueckgabeZeichenkette = "";
        //voher pruefen ob tatsaechlich das gesuchte Wort enthalten ist
        if (this.gefundeneWoerter.containsKey(gesuchtesWort)) {
            HashSet<Integer> zeilenListe =
                    this.gefundeneWoerter.get(gesuchtesWort);
            Iterator<Integer> iterator = zeilenListe.iterator();
            while (iterator.hasNext()) {
                rueckgabeZeichenkette += "" + iterator.next();
                if (iterator.hasNext()) {
                    rueckgabeZeichenkette += ", ";
                }
            }

        }
        
        return rueckgabeZeichenkette;
    }

    public void verarbeite(String eingabeWort) {
        if (!this.ausschlussWoerter.contains(eingabeWort)) {
            if (this.gefundeneWoerter.containsKey(eingabeWort)) {
                this.gefundeneWoerter.get(eingabeWort).add(this.zeilenIndex);
            } else {
                HashSet zeilenListe = new HashSet<Integer>();
                zeilenListe.add(this.zeilenIndex);
                this.gefundeneWoerter.put(eingabeWort, zeilenListe);
            }
        }
    }

    public void verarbeiteZeilenende() {
        this.zeilenIndex++;
    }
    
}
