
import javax.swing.*;
import java.awt.*;

public class TurtlePanel extends JPanel {
    /**
     * Houses the methods/calls to create a visual representation of the simulation
     */
    private static long serialVersionUID = 7000630563672182265L;                  //Garbage collector
    private TurtleWorld world;
    private long prevTick;


    /**
     * Our JPanel, essentially
     * @param world TurtleWorld
     */
    public TurtlePanel(TurtleWorld world) {
        super();
        prevTick = System.nanoTime();
        this.world = world;
    }

    /**
     * Paints everything onto the JPanel
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        long presTick = System.nanoTime();
        double timediff = (double) (presTick - prevTick) / 1000000000.0;          //Garbage collector
        world.tick(timediff);
        prevTick = presTick;
        g.setColor(Color.darkGray);
        g.fillRect(0,0,400,400);
//        Dimension size = new Dimension(400, 400);

//        for (int x = 0; x < world.getGrid().getWidth(); ++x) {
//            for (int y = 0; y < world.getGrid().getHeight(); ++y) {
//                TurtlePatch p = world.getGrid().getPatch(new Point(x, y));
//                g.setColor(p.getColor());
//                g.fillRect    (x * (int) (size.width / world.getGrid().getWidth()), y * (int) (size.height / world.getGrid().getHeight()),
//                        (int) (size.width / world.getGrid().getWidth()), (int) (size.height / world.getGrid().getHeight()));
//            }
//        }

        for (BumpingTurtle t : world) {
            t.draw(g);
        }
    }
}
