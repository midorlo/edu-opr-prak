package cloneableserializable;

/**
 * Diese Klasse dient der Veranschaulichung der Methode clone
 * und der Schnittstelle Cloneable.
 */
public class CloneTest {

    /**
     * Gibt textuelle Beschreibung der Kopie eines Autos aus.
     */
    private static void kopiereAuto() {

        Auto auto = new Auto("Ente", 16, 1962, 2000);
        System.out.println(auto.gibText());

        Auto autoKopie = (Auto) auto.clone();
        System.out.println(autoKopie.gibText());

        System.out.println(auto == autoKopie);
    }

    /**
     * Ruft Testmethoden auf.
     *
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        kopiereAuto();
    }
}
