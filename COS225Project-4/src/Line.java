/**
 * A "Line" is pair of points, (x1,y1) and (x2,y2), in a 2-dimensional
 * real plane.
 */
public class Line{
  
  /**
   * Public instance variables
   */
  public double x1;
  public double y1;
  public double x2;
  public double y2;
  
  /**
   * Construct a Line from 4 double values representing a pair of points, 
   * (x1,y1) and (x2,y2)
   */
  public Line(double x1, double y1, double x2, double y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
  
}