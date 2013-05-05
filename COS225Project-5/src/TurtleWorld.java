import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/** 
 * TurtleWorld provides a high level drawing context for a Turtle
 */
public class TurtleWorld implements Iterable<Turtle> {

    private final GridString numString;
    private final GridString turtleGrid;
    private final Set<Turtle> bumpingTurtles;
    private boolean paused;

    public TurtleWorld() {
        paused = false;
        turtleGrid = new GridString();
        numString = new GridString();
        bumpingTurtles = new HashSet<Turtle>();
    }

    public void tick(double timediff) {

        ArrayList<Turtle> aTurtles = new ArrayList<Turtle>(bumpingTurtles);
        for (Turtle t : aTurtles) {
            t.move(timediff);
        }
        numString.display();

    }

    public GridString getTurtleGrid()
    {
        return this.turtleGrid;
    }

    public Iterator<Turtle> iterator() {
        return bumpingTurtles.iterator();
    }

    public void addTurtle(Turtle t) {
        bumpingTurtles.add(t);

        TurtlePatch p = numString.getPatch(numString.worldToGrid(t.getPosition()));
        p.addTurtle(t);

        t.addListener(this);
    }

    public void newTurtlePosition(Turtle t, Vector2d oldPosition, Vector2d newPosition) {
        TurtlePatch prevPos = numString.getPatch(numString.worldToGrid(oldPosition));
        TurtlePatch presPos = numString.getPatch(numString.worldToGrid(newPosition));

        if (!prevPos.equals(presPos)) {
            prevPos.delTurtle(t);
            presPos.addTurtle(t);
        }

        // For each turtle in the patch...
        for (Turtle turtle : presPos) {
            // ... except the one that just moved here...
            if (turtle.equals(t)) {
                continue;
            }

            // If they are colliding...
            if (turtle.collision(t)) {
                presPos.addCollision();

                //Find the collision vector (turtle ---> t)
                Vector2d cvec = Vector2d.subtract(t.getPosition(), turtle.getPosition());

                // Set the bumpingTurtles facing away from each other, like they're fighting.
                t.setHeading(cvec.heading());
                turtle.setHeading(cvec.negate().heading());
                numString.makeOne(t.getPosition());

            }
        }
    }

}
