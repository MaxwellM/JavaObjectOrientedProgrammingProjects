import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  My TurtlePatch class that represents a spot on our TurtleGrid
 */
public class TurtlePatch implements Iterable<Turtle> {
    private final Set<Turtle> bumpingTurtles;
    private int collisions;

  /**
   * New TurtlePatch
   */
    public TurtlePatch() {
        bumpingTurtles = new HashSet<Turtle>();
    }

  /**
   * Adding a Turtle to a TurtlePatch
   * @param t Individual Turtle
   */
    public void addTurtle(Turtle t) {
        bumpingTurtles.add(t);
    }

  /**
   * Removing a Turtle from a TurtlePatch
   * @param t Individual Turtle
   */
    public void delTurtle(Turtle t) {
        bumpingTurtles.remove(t);
    }

  /**
   * Increments a count counting "collisions" between Turtles
   */
    public void addCollision() {
        ++collisions;
    }

  /**
   * Clears the collisions count to 0
   */
    void resetCollisions() {
        collisions = 0;
    }

    /**
     * Iterator  on a patch.
     */
    public Iterator<Turtle> iterator() {
        return bumpingTurtles.iterator();
    }

  /**
   * Sets the colors on the TurtleGrid
   * @return White = 1, Black = 0
   */
    public Color getColor() {
        int x = getCollisionCount();

        if (x>0){
          return new Color(255,255,255); }

        else{
          resetCollisions();
          return new Color(0,0,0); }
    }

  /**
   * Retrieves the number of collisions per TurtlePatch per loop
   * @return Number of collision on each TurtlePatch
   */
    int getCollisionCount() {
        return collisions;
    }
}
