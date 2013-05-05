import java.awt.*;
import java.util.*;
import java.util.Queue;

/**
 * TurtleWorld provides a high level drawing context for a Turtle
 */
public class TurtleWorld implements TurtleRecognizer, Iterable<BumpingTurtle> {

    private TurtleGrid turtleGrid;
    private Set<BumpingTurtle> bumpingTurtles;
    private Queue<BumpingTurtle> turtlesToRemove;
    private java.util.List<Point> collisions;
    private boolean paused;
    private double timeElapsed;

    /**
     * Method for our BumpingTurtle heading
     * @param t BumpingTurtle
     * @param prevHeading old heading
     * @param presHeading new heading
     */
    public void bumpingTurtleHeading(BumpingTurtle t, Heading prevHeading, Heading presHeading) {

    }

    /**
     * Method for our BumpingTurtles when they bump
     * @param t1 BumpingTurtle number 1
     * @param t2 BumpingTurtle number 2
     */
    public void bumpingTurtleBump(BumpingTurtle t1, BumpingTurtle t2) {

    }

    /**
     * New TurtleWorld with set values
     */
    public TurtleWorld() {
        paused = false;
        turtleGrid = new TurtleGrid();
        bumpingTurtles = new HashSet<BumpingTurtle>();
        turtlesToRemove = new LinkedList<BumpingTurtle>();
    }

    /**
     * Our synchronizing method to keep our loop under control
     * @param timediff Time frame to redraw
     */
    public void tick(double timediff) {
        timeElapsed += timediff;
        BumpingTurtle rem = null;
        while ((rem = turtlesToRemove.poll()) != null) {
            deleteBumpingTurtle(rem);
        }
        if (paused || bumpingTurtles.isEmpty()) {
            return;
        }
        Iterable<BumpingTurtle> aTurtles = new ArrayList<BumpingTurtle>(bumpingTurtles);
        int numSick = 0;
        for (BumpingTurtle t : aTurtles) {
            t.isSick();
            t.move(timediff);
            if (t.getSick()) {
                numSick += 1;
            }
            TurtleTest.stats.setText("Sick = " + numSick);
        }
    }

    /**
     * Gets our TurtleGrid setup
     * @return this.TurtleGrid
     */
    public TurtleGrid getTurtleGrid() {
        return this.turtleGrid;
    }

    /**
     * Gets our TurtlePatch setup for our TurtleGrid
     * @param loc Position
     * @return turtleGrid Patch
     */
    public TurtlePatch getPatch(Vector2d loc)
    {
        return turtleGrid.getPatch(turtleGrid.worldToGrid(loc));
    }

    /**
     * The Iterator for our BumpingTurtle class
     * @return bumpingTurtles, a set, with an iterator
     */
    public Iterator<BumpingTurtle> iterator() {
        return bumpingTurtles.iterator();
    }

    /**
     * Adds a BumpingTurtle on a Patch
     * @param t BumpingTurtle
     */
    public void addBumpingTurtle(BumpingTurtle t) {
        bumpingTurtles.add(t);

        TurtlePatch p = turtleGrid.getPatch(turtleGrid.worldToGrid(t.getPosition()));
        p.addTurtle(t);

        t.addListener(this);
    }

    /**
     * Removes a BumpingTurtle from a Patch
     * @param t BumpingTurtle
     */
    public void removeBumpingTurtle(BumpingTurtle t) {
        turtlesToRemove.add(t);
    }

    /**
     * Returns how much time has passed
     * @return timeElapsed
     */
    public double getTimeElapsed()
    {
        return this.timeElapsed;
    }

    /**
     * Returns the count of how many BumpingTurtles live in our world
     * @return bumpingTurtle size
     */
    public int bumpingTurtleCount() {

        return bumpingTurtles.size();
    }

    /**
     * Removes a BumpingTurtle from a Patch, and the listener attached to it
     * @param t BumpingTurtle
     */
    private void deleteBumpingTurtle(BumpingTurtle t) {
        t.delListener(this);

        TurtlePatch p = turtleGrid.getPatch(turtleGrid.worldToGrid(t.getPosition()));
        p.delTurtle(t);

        bumpingTurtles.remove(t);
    }

    /**
     * Returns the paused state, is it paused or not
     * @return !paused
     */
    public boolean isPaused() {
        return !paused;
    }

    /**
     * Pauses the game, and maintains the current state
     * @param p paused
     */
    public void setPaused(boolean p) {
        paused = p;
    }

    public TurtleGrid getGrid()
    {
        return this.turtleGrid;
    }

    /**
     * Method to handle when a BumpingTurtle moves onto a new location
     * @param t BumpingTurtle
     * @param oldPosition old position
     * @param newPosition new position
     */
    public void newBumpingTurtlePos(BumpingTurtle t, Vector2d oldPosition, Vector2d newPosition) {
        TurtlePatch prevPos = turtleGrid.getPatch(turtleGrid.worldToGrid(oldPosition));
        TurtlePatch presPos = turtleGrid.getPatch(turtleGrid.worldToGrid(newPosition));

        if (!prevPos.equals(presPos)) {
            prevPos.delTurtle(t);
            presPos.addTurtle(t);
        }

        for (BumpingTurtle turtle : presPos) {
            if (turtle.equals(t)) {
                continue;
            }

            if (turtle.collision(t)) {
                //presPos.addBumps();
                t.collidedWith(turtle);
                turtle.collidedWith(t);

                if (!t.getSick()){
                    t.setSick();
                }
                t.setSickColor();

                Vector2d cvec = Vector2d.subtract(t.getPosition(), turtle.getPosition());

                t.setHeading(cvec.heading());
                turtle.setHeading(cvec.negate().heading());
            }
        }
    }
}