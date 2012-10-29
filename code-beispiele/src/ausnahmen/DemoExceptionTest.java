package ausnahmen;

/**
 * Die Methoden dieser Klassen zeigen das Werfen und Fangen
 * einer DemoException.
 */
public class DemoExceptionTest {

    /*
     * Die Methoden dieser Klasse sind statisch. Das Werfen und
     * Behandeln von Ausnahmen funktioniert völlig gleich auch
     * bei Instanzmethoden.
     */

    /**
     * Gibt den übergebenen Wert auf dem Bildschirm aus,
     * wenn dieser gerade ist.
     *
     * @param n  eine Zahl
     * @throws DemoException  wird geworfen, wenn n ungerade ist
     */
    private static void m2(int n) throws DemoException {

        if (n % 2 == 1) {
            throw new DemoException("Parameter ist ungerade.", n);
        } else {
            System.out.println(n);
        }
    }

    /**
     * Gibt den übergebenen Wert auf dem Bildschirm aus,
     * wenn dieser gerade ist.
     *
     * @param zahl  eine Zahl
     */
    private static void m1(int zahl) {

        try {
            m2(zahl);

            /* Wenn diese Ausgabeanweisung ausgeführt wird, weiß man,
             * dass der Aufruf von m2 nicht versagt hat.
             */
            System.out.println("m2 hat nicht versagt. Die Zahl war gerade.");

        } catch (DemoException e) {

            /* An dieser Stelle weiß man, dass der Aufruf von m2
             * im try-Block versagt hat.
             */
            System.out.println("m2 hat versagt. Die Zahl wahr ungerade.");

            /* Für jede Ausnahme steht die Methode getMessage() zur Verfügung.
             * Diese Methode ist in der Klasse Throwable definiert.
             */
            System.out.println(e.getMessage());

            /* Zugriff auf spezielle Information zu dieser Ausnahme.
             */
            System.out.println("Ursache des Versagens: " + e.gibZahl());
        }
    }

    /**
     * Aufruf der Testmethode.
     *
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        m1(90);
        // Ergebnis = 90 + "\n" + "m2 hat nicht versagt. Die Zahl war gerade."
        System.out.println("\n");
        m1(81);
        // Ergebnis = "Parameter ist ungerade." + "\n" +
        //            "m2 hat versagt. Die Zahl wahr ungerade." + "\n" +
        //            "Ursache des Versagens: " + 81
    }
}
