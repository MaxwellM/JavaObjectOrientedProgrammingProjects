
import java.awt.*;

/**
 * A separate class for the TurtleGrid on the JPanel
 * Will be used for the next project
 */
public class TurtleGrid {

    private double horizontalNum;                 //Horizontal number of Patches
    private double verticalNum;                   //Vertical number of Patches
    private double patchWidthSize;                //Size of an individual Patch horizontally
    private double patchHeightSize;               //Size of an individual Patch vertically
    TurtlePatch[][] theGrid;

    public TurtleGrid() {
        patchWidthSize = 10.0;
        patchHeightSize = 10.0;

        horizontalNum = 70.0;
        verticalNum = 70.0;

        theGrid = new TurtlePatch[(int) horizontalNum][(int) verticalNum];            //The Grid. A digital frontier.

        /**
         *  This initializes the TurtleGrid with multiple TurtlePatch's that store the Turtle information
         */
        for (double x = 0.0; x < horizontalNum; ++x) {
            for (double y = 0.0; y < verticalNum; ++y) {
                theGrid[((int) x)][((int) y)] = new TurtlePatch();                    //New Patch for our Grid
            }
        }
    }

    /**
     * Returns the width of the TurtleGrid
     */
    public double getWidth() {
        return horizontalNum;
    }

    /**
     * Returns the width of the TurtleGrid
     */
    public double getHeight() {
        return verticalNum;
    }

    /**
     * Retrieves the TurtlePatch at the specified index.
     * If index exceeds the bounds of the theGrid, it will
     * be wrapped to within the theGrid's bounds.
     */
    public TurtlePatch getPatch(Point index) {
        index = wrapAround(index);
        return theGrid[index.x][index.y];
    }

    /**
     * Converts TurtleWorld location coordinates to TurtleGrid space coordinates.
     */
    Point worldToGrid(Vector2d coord) {
        double x = (coord.getX() / patchWidthSize);
        double y = (coord.getY() / patchHeightSize);
        return (wrapAround(new Point((int) x, (int) y)));
    }

    /**
     * Wraps a point to within the theGrid bounds.
     */
    Point wrapAround(Point point) {
        return new Point(point.x -  (int) (Math.floor((double) point.x / horizontalNum) * horizontalNum),
                         point.y -  (int) (Math.floor((double) point.y / verticalNum) * verticalNum));
    }

}