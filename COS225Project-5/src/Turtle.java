import java.util.HashSet;
import java.util.Set;

/**
 * A turtle for a turtle graphics system.
 */
abstract class Turtle {

    private double size;
    private Heading orientation;
    private Vector2d position;
    private Set<TurtleWorld> listeners;

    /**
     * Turtle
     */
    public Turtle() {
        setHeading(new Heading());
        setPosition(new Vector2d(0.0, 0.0));
    }

  /**
   * Abstract method that makes the turtle move a randomly 300 degrees right or left
   * @param timescale Limits this function to run only 1 time a second
   */
    abstract void move(double timescale);

  /**
   * Abstract method that controls counting the collisions and resetting them
   * @param t Individual Turtle
   * @return Draws "1s" with White blocks
   */
    abstract boolean collision(Turtle t);


    /**
     * Retrieves the orientation of the turtle.
     */
    public Heading getHeading() {
        return this.orientation;
    }

    /**
     * Sets the orientation of the turtle.
     * This occurs after the actual change has taken place, so calls to
     * t.getHeading() will return the new orientation.
     */
    public void setHeading(Heading a) {
        this.orientation = a;
    }

    /**
     * Retrieves the turtle's position within global world space.
     */
    public Vector2d getPosition() {
        return this.position;
    }

    /**
     * Sets the position of the turtle.
     */
    public void setPosition(Vector2d p) {
        Vector2d old = this.position;
        this.position = p;

        if (this.listeners != null) {
            for (TurtleWorld l : this.listeners) {
                l.newTurtlePosition(this, old, p);
            }
        }
    }

    double getSize()
    {
        return this.size;
    }

    public void setSize()
    {
        this.size = (double) 5;
    }


    /**
     * listener L to the turtle and changes position/orientation.
     */
    public void addListener(TurtleWorld l) {
        if (this.listeners == null) {
            this.listeners = new HashSet<TurtleWorld>();
        }

        this.listeners.add(l);
    }

}
