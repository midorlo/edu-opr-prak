package equals;

/*
 * Diese Klasse veranschaulicht, warum der Parameter der equals-Methode
 * vom Typ Object sein muss.
 *
 * 1. Kommentieren Sie die Methode boolean equals(Object obj) aus,
 * compilieren Sie diese Klasse und führen Sie sie aus.
 *
 * 2. Entfernen Sie die Auskommentierung der equals-Methode,
 * compilieren Sie diese Klasse und führen Sie sie aus.
 *
 * Wie sind die unterschiedlichen Ausgaben zu erkl�ren. Machen Sie
 * sich klar, welche equals-Methoden jeweils ausgeführt werden.
 *
 * Hinweis: Die hashCode-Methode ist hier nicht definiert, da sie
 * für das, was hier veranschaulicht werden soll, nicht benötigt wird.
 * Dies führt zu einem Checkstyle-Fehler.
 */
/**
 * Ein Objekt dieser Klasse repräsentiert eine ganze Zahl.
 */
public class MyInteger {

    /**
     * Zahl, die durch dieses Objekt repräsentiert wird.
     */
    private int wert;

    /**
     * Erzeugt ein Objekt dieser Klasse für die angegebene Zahl.
     *
     * @param wert  Zahl, für die dieses Objekt erzeugt wird
     */
    public MyInteger(int wert) {

        this.wert = wert;
    }

    /**
     * Gibt an, ob dieses Objekt gleich dem übergebenen Objekt ist.
     *
     * @param obj  ein beliebiges Objekt
     * @return <code>true</code> genau dann, wenn das übergebene Objekt
     *         zu dieser Klasse geh�rt und denselben Wert repräsentiert
     *         wie dieses Objekt
     */
//    @Override
//    public boolean equals(Object obj) {
//
//        System.out.print("MyInteger.equals(Object): ");
//        return (obj instanceof MyInteger)
//                && (this.wert == ((MyInteger) obj).wert);
//    }

    /**
     * Gibt an, ob dieses Objekt gleich dem übergebenen Objekt ist.
     *
     * @param myInteger  ein beliebiges MyInteger-Objekt
     * @return <code>true</code> genau dann, wenn das übergebene Objekt
     *         denselben Wert repräsentiert wie dieses Objekt
     */
//    private boolean equals(MyInteger myInteger) {
//
//        System.out.print("MyInteger.equals(MyInteger): ");
//        return this.wert == myInteger.wert;
//    }

    /**
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        MyInteger myInteger = new MyInteger(10);
        Object obj = new MyInteger(10);

        System.out.println("Ausgabe 1: " + myInteger.equals(obj));
        System.out.println("Ausgabe 2: " + myInteger.equals(myInteger));
        System.out.println("Ausgabe 3: " + obj.equals(obj));
        System.out.println("Ausgabe 4: " + obj.equals(myInteger));
    }
}
