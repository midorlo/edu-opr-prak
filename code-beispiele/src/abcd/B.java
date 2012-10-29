package abcd;

/**
 * Diese Klasse dient der Veranschaulichung von Vererbung.
 */
public class B extends A {

    public int b;  // bewusst nicht private verwendet; siehe Klasse A

    public B() {

        this.a = 0;
        this.b = 100;
    }

    @Override
    public int gibWert() {

        return b * super.gibWert();
    }

    public String gibAlsText() {

        return "B: " + (a + b);
    }
}
