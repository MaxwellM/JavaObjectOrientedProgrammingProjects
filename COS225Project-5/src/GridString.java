import java.awt.*;

/**
 *  This is where the String that is displayed on the Console lives
 */
public class GridString {
  private double horizontalNum;
  private double verticalNum;
  private double patchWidthSize;
  private double patchHeightSize;
  TurtlePatch[][] theGrid;
  String [][] numString;

  public GridString() {
    horizontalNum = 40.0;
    verticalNum = 40.0;

    patchWidthSize = 10.0;
    patchHeightSize = 10.0;

    theGrid = new TurtlePatch[(int) horizontalNum][(int) verticalNum];
    numString = new String[(int) horizontalNum][(int) verticalNum];

        /**
         *  This initializes the TurtleGrid with multiple TurtlePatch's that store the Turtle information
         */
        for (int x = 0; x < horizontalNum; ++x) {
            for (int y = 0; y < verticalNum; ++y) {
              theGrid[x][y] = new TurtlePatch();
            }
        }

    /**
     *  Initializing the String with all "0's"
     */
    for (double x = 0.0; x < horizontalNum; ++x) {
      for (double y = 0.0; y < verticalNum; ++y) {
        numString[(int) x][(int) y] = "0";
      }
    }
  }

  /**
   *  Takes a Vector2d coordinate and separates it into [x,y] and converts them to a "1" in the correct location
   *    on the grid.
   */
  public void makeOne(Vector2d coord){
    int x = (int) (coord.getX() / patchWidthSize);
    int y = (int) (coord.getY() / patchHeightSize);
    numString[x][y] = "1";


  }

  /**
   *  This prints the String to the Console.
   */
  public void display() {
    for (int h = 0; h<40;h++){
      System.out.println("");
    }
    for (int i=0;i<= numString.length-1;i++){
      for (int j=0;j<= numString.length-1;j++){
        System.out.print(numString[j][i]);
      }
      System.out.println("");
    }
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
        int x = (int) (coord.getX() / patchWidthSize);
        int y = (int) (coord.getY() / patchHeightSize);
        return wrapAround(new Point(x, y));
    }

    /**
     * Wraps a point to within the theGrid bounds.
     */
    Point wrapAround(Point point) {
        return new Point(point.x - (int) (Math.floor(point.x / (double) horizontalNum) * horizontalNum),
                point.y - (int) (Math.floor(point.y / (double) verticalNum) * verticalNum));
    }

}