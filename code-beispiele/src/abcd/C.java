package abcd;

/**
 * Diese Klasse dient der Veranschaulichung von Vererbung.
 */
public class C extends B {

    public C() {

        this.a = 50;
        this.b = 0;
    }

    @Override
    public void erhoehe(int summand) {

        b = b + summand;
    }

    public int gibWert(int faktor) {

        return (a - b) * faktor;
    }

    @Override
    public String gibAlsText() {

        return "C: " + (a - b);
    }
}
