package einausgabe;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * Ein Objekt dieser Klasse dient der Anzeige von Text
 * in einem separaten Fenster.
 */
public class Textanzeige extends JFrame {

    /** Horizontale Anfangsgröße des Fensters. */
    private static final int FENSTERGROESSE_X = 750;

    /** Vertikale Anfangsgröße des Fensters. */
    private static final int FENSTERGROESSE_Y = 500;

    /** Abstand zwischen Text und Fensterrahmen. */
    private static final int PADDING = 10;

    /** Schriftgröße der Anzeige. */
    private static final int SCHRIFTGROESSE = 20;
    
    /** Komponente zur Darstellung des Texts. */
    private JTextArea textArea;

    /** Erzeugt ein Objekt dieser Klasse. */
    public Textanzeige() {

        super("Textanzeige");

        /* Erzeugt die Komponenten dieses Frame. */
        initComponents();

        /* Exit beim Schließen dieses Frame. */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(FENSTERGROESSE_X, FENSTERGROESSE_Y);
        this.setVisible(true);
    }

    /** Initialisiert die Komponenten dieses Frame. */
    private void initComponents() {

        textArea = new JTextArea();
        textArea.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        textArea.setFont(new Font("Monospaced", Font.BOLD, SCHRIFTGROESSE));
        textArea.setLineWrap(true);  // mit automatischen Umbrüchen

        /* textArea scrollbar */
        this.getContentPane().add(new JScrollPane(textArea));
    }

    /**
     * Gibt ein Zeichen aus.
     *
     * @param ch  Zeichen, das ausgegeben wird
     */
    public void print(char ch) {

        this.textArea.append(Character.toString(ch));
    }

    /**
     * Gibt ein Zeichen mit anschließendem Zeilenumbruch aus.
     *
     * @param ch  Zeichen, das ausgegeben wird
     */
    public void println(char ch) {

        this.println(Character.toString(ch));
    }

    /**
     * Gibt eine Zeichenkette aus.
     *
     * @param str  Zeichenkette, das ausgegeben wird
     */
    public void print(String str) {

        this.textArea.append(str);
    }

    /**
     * Gibt eine Zeichenkette mit anschließendem Zeilenumbruch aus.
     *
     * @param str  Zeichenkette, das ausgegeben wird
     */
    public void println(String str) {

        this.textArea.append(str + "\n");
    }
}
