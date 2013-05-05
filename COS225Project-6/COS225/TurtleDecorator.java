
import java.awt.*;

/**
 * TurtleDecorator is the template used to draw EACH Turtle on the JPanel
 */
public class TurtleDecorator implements TurtleDriver {

    /**
     * The Draw method used to draw a Turtle
     * @param g Graphics
     * @param t BumpingTurtle
     */
    public void draw(Graphics g, BumpingTurtle t) {
        g.setColor(t.getColor());                                               //Sets the Color for each Turtle

        Vector2d pos = t.getPosition();                                         //Sets the position to draw the Turtle on the JPanel
        g.drawOval((int) pos.getX() - (int) (t.getSize() / 2.0),                //This is the body of the Turtle
                (int) pos.getY() - (int) (t.getSize() / 2.0),
                (int) t.getSize(), (int) t.getSize());

        Vector2d head = new Vector2d(t.getHeading(), (t.getSize() * 0.75));     //This is the head of the Turtle, points where he is facing
        g.drawLine((int) pos.getX(), (int) pos.getY(), (int) head.getX() + (int) pos.getX(), (int) head.getY() + (int) pos.getY());
    }
}

