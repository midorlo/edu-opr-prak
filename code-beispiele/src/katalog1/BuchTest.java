package katalog1;

/**
 * Diese Klasse enthält Methoden zum Test der Klasse Buch.
 */
public class BuchTest {

    /**
     * Testet Methode passtZu.
     */
    private static void testePasstZu() {

        Buch buch = new Buch("Asterix der Gallier", "Uderzo", 9.80f, 1965);

        // erwartet: true
        System.out.println(buch.passtZu("Gall"));

        // erwartet: false, denn "der" ist Ausschlusswort
        System.out.println(buch.passtZu("der"));

        // erwartet: false, denn kein Wort des Titel beginnt mit "Galle"
        System.out.println(buch.passtZu("Galle"));
    }

    /**
     * Ruft Testmethoden auf.
     *
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        testePasstZu();
    }
}
