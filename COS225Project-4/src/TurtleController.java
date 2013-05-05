

/**
 * Controller object for the TurtleGraphics system
 */
public class TurtleController {
  
  /**
   * instance variables
   */
  private Turtle t;
  private TurtleWorld TW;
  
  /**
   * Construct a TurtleController object
   */
  public TurtleController(){
    /**
     * A TurtleController object is created with a Turtle
     * and an associated TurtleWorld context.
     */
    TW = new TurtleWorld();
    t = new Turtle(TW,90,0,0);
    
  }
  
  /**
   * The drawStuff method completely draws a series of turtle 
   * shapes.
   */ 
  public void drawStuff(){
    /* 
     * This method uses a Turtle to draw it's own Turtle shapes
     */
      TurtleDrawings.stLine(t,-54,0,100);
      TW.doDrawLine(50, 0, 50, 100);
      TW.doDrawLine(0, 100, 100, 0);
      t.setx(40);
      t.sety(40);
      TurtleDrawings.Square(t,10);
      t.setx(10);
      t.sety(-15);
      TurtleDrawings.Circle(t,40,1);
      t.setHeading(90);
      t.setx(40);
      t.sety(20);
      TurtleDrawings.Rectangle(t,30,10);
    TW.display();
  }

}