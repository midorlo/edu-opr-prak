package abcd;

/**
 * Diese Testklasse veranschaulicht Vererbung und
 * dynamisches Binden.
 */
public class ABCDTest {

    private static void testeSuper() {

        A a = new A();
        B b = new B();

        a.erhoehe(10);
        System.out.println(a.gibWert()); 
        // Ergebnis = 20

        b.erhoehe(20);  // es wird geerbte Methode aus A ausgeführt
        System.out.println(b.gibWert()); 
        // Ergebnis = 4000
    }

    private static void testeVererbung() {

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        a.erhoehe(5);
        System.out.println(a.gibWert()); 
        // Ergebnis = 10
        System.out.println();

        b.erhoehe(5);  // geerbt von A
        System.out.println(b.gibWert());  // geerbte Methode überschrieben
        // Ergebnis = 1000
        System.out.println(b.gibAlsText()); 
        // Ergebnis = "B: 105"
        System.out.println();

        c.erhoehe(5);  // geerbte Methode überschrieben
        System.out.println(c.gibWert());  // geerbt von B
        // Ergebnis = 500
        System.out.println(c.gibWert(2)); 
        // Ergebnis = 90
        System.out.println(c.gibAlsText());  // geerbte Methode überschrieben
        // Ergebnis = "C: 45"
        System.out.println();

        d.erhoehe(5);  // geerbt von A
        System.out.println(d.gibWert());  // geerbt von A
        // Ergebnis = 10
        System.out.println();
    }

    private static void testeDynamischesBinden() {

        A a;

        a = new A();
        a.erhoehe(5);
        System.out.println(a.gibWert());
        // Ergebnis = 10
        System.out.println();

        a = new B();
        a.erhoehe(5);  // geerbte Methode aus A
        System.out.println(a.gibWert());  // überschriebene Methode aus B
        // Ergebnis = 1000
        System.out.println();

        a = new C();
        a.erhoehe(5);  // überschriebene Methode aus C
        System.out.println(a.gibWert());  // geerbte Methode aus B
        // Ergebnis = 500
        System.out.println();
    }

    /**
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        testeSuper();
        testeVererbung();
        testeDynamischesBinden();
    }
}
