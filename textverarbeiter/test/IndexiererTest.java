import java.util.ArrayList;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class IndexiererTest {

    @Test
    public void testGibWoerter() {
        Indexierer instanz;
        ArrayList<String> sollErgebnis;
        HashSet<String> ausschlussWoerter;

        //Test1
        ausschlussWoerter = new HashSet<String>();
        ausschlussWoerter.add("groß");
        ausschlussWoerter.add("sehr");
        ausschlussWoerter.add("und");
        ausschlussWoerter.add("wunderschoen");
        
        instanz = new Indexierer(ausschlussWoerter);

        sollErgebnis = new ArrayList<String>();
        sollErgebnis.add("Alle");
        sollErgebnis.add("Heim");
        sollErgebnis.add("bauen");
        sollErgebnis.add("das");
        sollErgebnis.add("eigene");


        instanz.verarbeite("Alle");
        instanz.verarbeite("bauen");
        instanz.verarbeite("das");
        instanz.verarbeite("eigene");
        instanz.verarbeite("Heim");
        instanz.verarbeite("sehr");
        instanz.verarbeite("groß");
        instanz.verarbeite("und");
        instanz.verarbeite("wunderschoen");

        assertEquals(sollErgebnis, instanz.gibWoerter());
    }

    @Test
    public void testGibZeilennummern() {
        Indexierer instanz;
        HashSet<String> ausschlussWoerter;

        //Test2
        ausschlussWoerter = new HashSet<String>();
        ausschlussWoerter.add("Ja");
        ausschlussWoerter.add("das");
        ausschlussWoerter.add("ist");
        ausschlussWoerter.add("Gut");

        instanz = new Indexierer(ausschlussWoerter);


        instanz.verarbeite("Mama");
        instanz.verarbeite("sucht");
        instanz.verarbeite("Papa");
        instanz.verarbeite("Papa");
        instanz.verarbeiteZeilenende();
        instanz.verarbeite("sucht");
        instanz.verarbeite("Mama");
        instanz.verarbeite("Ja");
        instanz.verarbeite("das");
        instanz.verarbeite("ist");
        instanz.verarbeite("gut");

        assertEquals("1, 2", instanz.gibZeilennummern("Mama"));
        assertEquals("1", instanz.gibZeilennummern("Papa"));
        assertEquals("1, 2", instanz.gibZeilennummern("sucht"));

        assertEquals("", instanz.gibZeilennummern("Ja"));
        assertEquals("", instanz.gibZeilennummern("das"));
        assertEquals("", instanz.gibZeilennummern("ist"));
        assertEquals("2", instanz.gibZeilennummern("gut"));
    }
}