/**
 * A Turtle for a Turtle Graphics system.
 */


public class Turtle extends BasicTurtle {

  /**
   * Instance variables
   */      
  private TurtleWorld TW;
  private double tHeading;
  private double x;
  private double y;
  private boolean penDown;

  // Constructors:
 
  /**
   * ensure: create a new Turtle with: 
   *      TurtleWorld drawing context TW,
   *      heading due north (0 degrees), 
   *      position at the origin (0,0), and 
   *      and pen in "up" position
   */  
  public Turtle(TurtleWorld TW) {
	super();
    this.TW = TW;
    tHeading = 0;
    x = GridArray.theCenter;
    y = GridArray.theCenter;
    penDown = false;
  }

  /**
   * ensure: create a new Turtle with: 
   *      TurtleWorld drawing context TW,
   *      heading inith degrees to the right of due north, 
   *      position at (x,y), and 
   *      and pen in "up" position
   */ 
  public Turtle (TurtleWorld TW, double inith, double x, double y) {
    super(inith,x,y);
	this.TW = TW;
    tHeading = inith;
    this.x = x+GridArray.theCenter;
    this.y = y+GridArray.theCenter;
	penDown = false;
  }

  /**
   * ensure: create a new Turtle with: 
   *      TurtleWorld drawing context TW,
   *      heading inith degrees to the right of due north, 
   *      position at the origin (0,0), and 
   *      and pen in "up" position
   */ 
  public Turtle (TurtleWorld TW, double inith) {
    super(inith);
	this.TW = TW;
    tHeading = inith;
    x = GridArray.theCenter;
    y = GridArray.theCenter;
	penDown = false;
  }

  /**
   * ensure: create a new Turtle with: 
   *      TurtleWorld drawing context TW,
   *      with heading due north (0 degrees),  
   *      position at (x,y), and 
   *      and pen in "up" position
   */ 
  public Turtle (TurtleWorld TW, double x, double y) {
    super(x,y);
	this.TW = TW;
    tHeading = 0;
    this.x = x+GridArray.theCenter;
    this.y = y+GridArray.theCenter;
  }

  // Commands:

   /**
   * ensure: set the pen down. 
   */ 
  public void pd () {
    penDown = true;
  } 
  
   /**
   * ensure: set the pen up. 
   */ 
  public void pu () {
    penDown = false;
  }
  
  /**
   * ensure: The Turtle is at the x-coordinate position. 
   */ 
  public void setx (double x) {
    this.x = x+GridArray.theCenter;
  }

  /**
   * ensure: The Turtle is at the y-coordinate position.  
   */ 
  public void sety (double y) {
    this.y = y+GridArray.theCenter;
  }  
  
    /**
   * ensure: the Turtle has heading tHeading. 
   */ 
  public void setHeading (double tHeading) {
    this.tHeading = tHeading;
  }

  
  /**
   * require: offset can be any positive or negative value (No restriction).
   * ensure: the Turtle heading is set to offset degrees to the right
   *         of its previous heading, mod 360.
   *         (The Turtle position is unchanged).   
   */ 
  public void rt (double offset) {
	 tHeading = (tHeading + offset) % 360.0;
  }

  /**
   * require: offset can be any positive or negative value (No restriction).
   * ensure: the Turtle heading is set to offset degrees to the left
   *         of its previous heading, mod 360.  
   *         (The Turtle position is unchanged).   
   */
  public void lt (double offset) {
	  tHeading = (tHeading - offset) % 360.0;
  }

  /**
   * ensure: Move dist steps in the direction Turtle.heading().
   *         (The Turtle heading is unchanged).  
   */  
  public void fd (double dist) {
//  double tHeading;
    double prevY = ycor();
    double prevX = xcor();
    super.fd(dist);

    
    // Increase the x
    this.x += (Math.sin(this.tHeading * 0.0174532925) * dist);
  
  	// Decrease the y
  	this.y -= (Math.cos(this.tHeading * 0.0174532925) * dist);
    
    if (penDown)
      TW.doDrawLine((int)prevX,(int)prevY,(int)xcor(),(int)ycor());    
  }
 
  /**
   * ensure: Move dist steps in the direction opposite of Turtle.heading().
   *         (The Turtle heading is unchanged).  
   */   
  public void bk (double dist) {
	  fd(-dist);
  }

  // Queries:

  /**
   * ensure: Return status of pen.
   */ 
  public boolean isPenDown () {
    return penDown;
  }
  
  /**
   * ensure: Current heading of this Turtle in degrees, 0 to < 360, with 0 due north.
   */ 
  public double heading () {
    return tHeading;
  }

  /**
   * ensure: Current x position of the Turtle.
   */ 
  public double xcor () {
    return x;
  }

  /**
   * ensure: Current y position of the Turtle.
   */ 
  public double ycor () {
    return y;
  }
  
  
}