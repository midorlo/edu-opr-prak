
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author apex
 */
public class ParserTest {

    Ausdruck sollAusdruck;
    Parser parser = new Parser();

    @Test
    public void testParse() {
        // (a + 1) * 5
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(new Variable("a"), '+', new Konstante(1)),
                '*',
                new Konstante(5));
        
        Assert.assertEquals(sollAusdruck, parser.parse("(a + 1) * 5"));

        // (b * 13) + 5
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(new Variable("b"), '*', new Konstante(13)),
                '+',
                new Konstante(5));

        Assert.assertEquals(sollAusdruck, parser.parse("(b * 13) + 5"));

        // ((a + 1) / (b - 23)) + 42
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(
                new OperatorAusdruck(new Variable("a"), '+', new Konstante(1)),
                '/',
                new OperatorAusdruck(new Variable("b"), '-', new Konstante(23))),
                '+',
                new Konstante(42));

        Assert.assertEquals(sollAusdruck, parser.parse("((a + 1) / (b - 23)) + 42"));

        // 205 * ((a - 1) + b)
        sollAusdruck = new OperatorAusdruck(
                new Konstante(205),
                '*',
                new OperatorAusdruck(
                new OperatorAusdruck(new Variable("a"), '-', new Konstante(1)),
                '+',
                new Variable("b")));

        Assert.assertEquals(sollAusdruck, parser.parse("205 * ((a - 1) + b)"));

        // (2300 / 23) * 567
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(
                new Konstante(2300), '/', new Konstante(23)),
                '*',
                new Konstante(567));

        Assert.assertEquals(sollAusdruck, parser.parse("(2300 / 23) * 567"));

        // ((a * 1) + 5) / 12
        sollAusdruck = new OperatorAusdruck(
                new OperatorAusdruck(
                new OperatorAusdruck(
                new Variable("a"), '*', new Konstante(1)),
                '+',
                new Konstante(5)),
                '/',
                new Konstante(5));

        Assert.assertEquals(sollAusdruck, parser.parse("((a * 1) + 5) / 12"));
    }
}
