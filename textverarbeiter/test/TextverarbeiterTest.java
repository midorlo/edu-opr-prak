import java.io.StringReader;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

class MockupWortverarbeiter implements Wortverarbeiter {
    public ArrayList<String> verarbeiteteWoerter;
    public int zeilenIndex;

    public MockupWortverarbeiter() {
        this.zeilenIndex = 1;
        this.verarbeiteteWoerter = new ArrayList<String>();
    }

    public void verarbeite(String eingabeWort) {
        this.verarbeiteteWoerter.add(eingabeWort);
    }

    public void verarbeiteZeilenende() {
        this.zeilenIndex++;
    }
}

public class TextverarbeiterTest {
    @Test
    public void testVerarbeite() throws Exception {
        Textverarbeiter instanz;
        MockupWortverarbeiter mockupWortverarbeiter;
        Indexierer indexierer;
        StringReader datenQuelle;
        ArrayList<String> sollWortListe;
        ArrayList<String> ausschlussWortliste;

        //Test1
        sollWortListe = new ArrayList<String>();
        sollWortListe.add("Wir");
        sollWortListe.add("sind");
        sollWortListe.add("toll");
        sollWortListe.add("Und");
        sollWortListe.add("Fahren");
        sollWortListe.add("gerne");
        sollWortListe.add("NachHause");
        sollWortListe.add("Toll");
        sollWortListe.add("wa");

        mockupWortverarbeiter = new MockupWortverarbeiter();

        instanz = new Textverarbeiter(mockupWortverarbeiter);
        datenQuelle = new StringReader(
                "Wir sind toll.Und   Fahren gerne-NachHause!Toll wa?");
        instanz.verarbeite(datenQuelle);

        assertEquals(2, mockupWortverarbeiter.zeilenIndex);
        assertEquals(sollWortListe, mockupWortverarbeiter.verarbeiteteWoerter);

        //Test2
        sollWortListe = new ArrayList<String>();
        sollWortListe.add("Wir");
        sollWortListe.add("sind");
        sollWortListe.add("toll");
        sollWortListe.add("Und");
        sollWortListe.add("Fahren");
        sollWortListe.add("gerne");
        sollWortListe.add("Nach");
        sollWortListe.add("Hause");
        sollWortListe.add("Toll");
        sollWortListe.add("wa");

        mockupWortverarbeiter = new MockupWortverarbeiter();

        instanz = new Textverarbeiter(mockupWortverarbeiter);
        datenQuelle = new StringReader(
                "Wir\n\n\n sind\n toll!?-;..Und\n\n\n   Fahren gerne-Nach\nHause\n!\nToll wa?\n\n");
        instanz.verarbeite(datenQuelle);

        assertEquals(13, mockupWortverarbeiter.zeilenIndex);
        assertEquals(sollWortListe, mockupWortverarbeiter.verarbeiteteWoerter);

        //Test3 (Verbundstest um zu prüfen ob die Komponenten auch zusammen arbeiten
        sollWortListe = new ArrayList<String>();
        sollWortListe.add("Wir");
        sollWortListe.add("sind");
        sollWortListe.add("Und");
        sollWortListe.add("gerne");
        sollWortListe.add("Nach");
        sollWortListe.add("Hause");
        sollWortListe.add("toll");
        sollWortListe.add("wa");
        java.util.Collections.sort(sollWortListe);

        ausschlussWortliste = new ArrayList<String>();
        ausschlussWortliste.add("Fahren");

        indexierer = new Indexierer(ausschlussWortliste);

        instanz = new Textverarbeiter(indexierer);
        datenQuelle = new StringReader(
                "Wir\n\n\n sind\n toll!?-;..Und\n\n\n   Fahren gerne-Nach\nHause\n!\ntoll wa?\n\n");
        instanz.verarbeite(datenQuelle);

        assertEquals(sollWortListe, indexierer.gibWoerter());
        assertEquals("1", indexierer.gibZeilennummern("Wir"));
        assertEquals("9", indexierer.gibZeilennummern("Hause"));
        assertEquals("5, 11", indexierer.gibZeilennummern("toll"));
    }
}