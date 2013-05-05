import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * My TurtlePatch class that represents a spot on our TurtleGrid
 */
public class TurtlePatch implements Iterable<BumpingTurtle> {
    private Set<BumpingTurtle> bumpingTurtles;
    private double bumps;

    /**
     * New TurtlePatch
     */
    public TurtlePatch() {
        bumpingTurtles = new HashSet<BumpingTurtle>();
    }

    /**
     * Adding a Turtle to a TurtlePatch
     * @param t Individual Turtle
     */
    public void addTurtle(BumpingTurtle t) {
        bumpingTurtles.add(t);
    }

    /**
     * Removing a Turtle from a TurtlePatch
     * @param t Individual Turtle
     */
    public void delTurtle(BumpingTurtle t) {
        bumpingTurtles.remove(t);
    }

    /**
     * Increments a count counting bumps between Turtles
     */
    public void addBumps() {
        ++bumps;
    }

   /**
    * Sets bumps to 0
    */
    public void resetBumps() {
        bumps = 0.0;
    }

    /**
     * Gets number of bumps per TurtlePatch per loop
     * @return Number of bumps on each TurtlePatch
     */
    public double getNumBumps() {
        return bumps;
    }

    /**
     * Iterator on a Patch.
     */
    public Iterator<BumpingTurtle> iterator() {
        return bumpingTurtles.iterator();
    }

    /**
     * Sets the colors on the TurtleGrid
     * @return White = 1, Black = 0
     */
    public Color getColor() {
        double x = bumps;

        if (x>0.0){
            return new Color(255,255,255); }

        else{
            resetBumps();
            return new Color(0,0,0); }
    }
}