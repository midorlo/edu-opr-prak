
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author apex
 */
public class AusdruckTest {

    Ausdruck sollAusdruck;
    Variablenbelegung belegung;
    
    @Test
    public void testGibWert() {
        
        belegung = new Variablenbelegung();
        
        belegung.belege("a", 5);
        
        // (a + 1) * 5
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(new Variable("a"), '+', new Konstante(1)),
                '*',
                new Konstante(5));

        Assert.assertEquals(30, sollAusdruck.gibWert(belegung));
        
        belegung.belege("b", 7);
        
        // (b * 13) + 5
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(new Variable("b"), '*', new Konstante(13)),
                '+',
                new Konstante(5));

        Assert.assertEquals(96, sollAusdruck.gibWert(belegung));
        
        belegung.belege("a", 59);
        belegung.belege("b", 53);
        
        // ((a + 1) / (b - 23)) + 42
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(
                new OperatorAusdruck(new Variable("a"), '+', new Konstante(1)),
                '/',
                new OperatorAusdruck(new Variable("b"), '-', new Konstante(23))),
                '+',
                new Konstante(42));

        Assert.assertEquals(44, sollAusdruck.gibWert(belegung));
        
        belegung.belege("a", 5);
        belegung.belege("b", 4);
        
        // 205 * ((a - 1) + b)
        sollAusdruck = new OperatorAusdruck(
                new Konstante(205),
                '*',
                new OperatorAusdruck(
                new OperatorAusdruck(new Variable("a"), '-', new Konstante(1)),
                '+',
                new Variable("b")));

        Assert.assertEquals(1640, sollAusdruck.gibWert(belegung));
        
        // (2300 / 23) * 567
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(
                new Konstante(2300), '/', new Konstante(23)),
                '*',
                new Konstante(567));

        Assert.assertEquals(56700, sollAusdruck.gibWert(belegung));
        
        belegung.belege("a", 5);
        
        // ((a * 1) + 6) / 12
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(
                new OperatorAusdruck(
                new Variable("a"), '*', new Konstante(1)),
                '+',
                new Konstante(5)),
                '/',
                new Konstante(5));

        Assert.assertEquals(1, sollAusdruck.gibWert(belegung));
    }
}
