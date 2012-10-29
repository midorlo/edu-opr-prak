package abcd;

/**
 * Diese Klasse dient der Veranschaulichung von Vererbung.
 */
public class A {

    /*
     * Diese Variable wird als public deklariert, um den
     * Effekt der Vererbung veranschaulichen zu können.
     * Auf eine private Instanzvariable könnte in Unterklassen
     * nicht zugegriffen werden.
     */
    public int a;

    public A() {

        this.a = 0;
    }

    public void erhoehe(int summand) {

        a = a + summand;
    }

   public int gibWert() {

        return 2 * a;
    }
}
