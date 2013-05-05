import java.util.Vector;

/**
 * A list of "Lines" ((x1,y1,x2,y2) pairs of points).<br>
 * These lines are drawn into the TurtlePanel and used by the
 * TurtlePanel's paintComponent method to refresh the TurtlePanel
 */
public class LineList {
  
  /** instance variable
   */
  private Vector<Line> lines;
  
  /**
   * construct a new LineList
   */
  public LineList(){
    lines = new Vector<Line>();
  }
  
  /**
   * Add a Line to the LineList
   */
  public void add(Line l){
    lines.add(l);
  }
  
  /**
   * Return the ith item in the LineList, 
   * 0 <= i <= LineList.size()
   */
  public Line item(int i){
    return lines.elementAt(i);
  }
  
  /**
   * Return the number of Lines in the LineList
   */
  public int size(){
    return lines.size();
  }
  
}