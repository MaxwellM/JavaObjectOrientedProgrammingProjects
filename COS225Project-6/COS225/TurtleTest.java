import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * The TurtleTest class invokes the main program of the Turtle System.
 */
public class TurtleTest {

    static JFrame frame;                                          //JPanel used in TurtlePanel
    static JLabel stats;                                          //Stats JLabel used in TurtleWorld

    /**
     * Our Main method!
     * @param args Arg!
     */
    public static void main(String[] args) {
        frame = new JFrame("PROJECT 6");
        stats = new JLabel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        reset();
        frame.setVisible(true);
        /**
         * Repaints when the game is not Paused
         */

        boolean run = true;
        while (run) {
            frame.repaint();
            if (!run) {
                break;
            }
        }
    }

    /**
     * Resets the simulation to default
     */
    public static void reset() {
        frame.setContentPane(newTurtleWorld());
        frame.pack();
    }

    /**
     * The initial template for the simulation
     * 300 BumpingTurtles
     * @return The initial setup for the simulation to be tested
     */
    static JPanel newTurtleWorld() {
        stats.setPreferredSize(new Dimension(80,25));
        stats.setLocation(10,10);
        JPanel wholePane = new JPanel();
        wholePane.setPreferredSize(new Dimension(700,700));
        wholePane.setLayout(new BoxLayout(wholePane, BoxLayout.Y_AXIS));
        JPanel buttonPane = new JPanel();
        JPanel worldPane = new JPanel(new GridLayout(1, 1));

        TurtleWorld w = new TurtleWorld();
        TurtlePanel p = new TurtlePanel(w);
        p.setPreferredSize(new Dimension(700,700));
        worldPane.add(p);

        buttonPane.add(stats);
        buttonPane.add(new JButton(new Reset()));
        buttonPane.add(new JButton(new Pause(w)));

        wholePane.add(worldPane);
        wholePane.add(buttonPane);

        for (double x = 0.0; x < 1000.0; ++x) {
            BumpingTurtle t = new BumpingTurtle();
            t.addDecorator(new TurtleDecorator());
            t.setPosition(new Vector2d(Math.random() * 700.0, Math.random() * 700.0));
            t.setHeading(new Heading(Heading.HeadingType.DEGREES, Math.random() * 360.0));
            w.addBumpingTurtle(t);
        }

        return wholePane;
    }
}

/**
 * The Pause class will halt the simulation
 */
class Pause extends AbstractAction {

    /**
     * Toggles the Pausing of the simulation
     */
    private static long serialVersionUID = 1960415650768270478L;
    TurtleWorld tw;

    public Pause(TurtleWorld tw) {
        super("Pause", null);
        this.tw = tw;
    }

    /**
     * Toggles the Pausing method
     * @param e Toggling on or off
     */
    public void actionPerformed(ActionEvent e) {
        tw.setPaused(tw.isPaused());
    }
}

/**
 * The Reset class will clear the world and recall the TurtleTest class
 */
class Reset extends AbstractAction {

    /**
     * Restarts the TurtleWorld simulation
     */
    private static long serialVersionUID = 8825227190121839934L;

    public Reset() {
        super("Reset", null);
    }

    public void actionPerformed(ActionEvent e) {
        TurtleTest.reset();
    }
}
