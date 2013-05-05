/**
 * A Basic Turtle for a Turtle Graphics system.
 */


public class BasicTurtle {

  /**
   * Instance variables
   */      
  private double tHeading;
  private double x;
  private double y;
  GridArray TA;

  // Constructors:
 
  /**
   * Using a TurtleWorld drawing "context", create a new Turtle 
   * with heading due north (0 degrees), and position at the origin (0,0)
   */  
  public BasicTurtle() {
    tHeading = 0;
    x = 0;
    y = 0;
  }

  /**
   * Using a TurtleWorld drawing "context", create a new Turtle 
   * with specified heading and position.
   */ 
  public BasicTurtle (double inith, double x, double y) {
    tHeading = inith;
    this.x = x;
    this.y = y;
  }

  /**
   * Using a TurtleWorld drawing "context", create a new Turtle
   * with specified heading and position at the origin (0,0)
   */ 
  public BasicTurtle (double inith) {
    tHeading = inith;
    x = 0;
    y = 0;
  }

  /**
   * Using a TurtleWorld drawing "context", create a new Turtle
   * with heading due north (0 degrees) and specified position
   */ 
  public BasicTurtle (double x, double y) {
    tHeading = 0;
    this.x = x;
    this.y = y;
  }

  // Commands:
  
  /**
   * Reset the Turtle to x-coordinate position. 
   */ 
  public void setx (double x) {
	  this.x=x;
	  
  }

  /**
   * Reset the Turtle to y-coordinate position. 
   */ 
  public void sety (double y) {
	  this.y=y;
  }  
  
    /**
   * Reset the Turtle to tHeading. 
   */ 
  public void setHeading (double tHeading) {
	  this.tHeading=tHeading;
  }

  
  /**
   * Turn right offset degrees. The Turtle heading is changed but the
   * Turtle position stays the same.  
   * offset can be any positive or negative value.  
   * The calculation is done % 360 degrees.
   * rt is exactly the opposite of lt.
   */ 
  public void rt (double offset) {
	  tHeading += offset;
	  	while(tHeading>360)
	  	{
	  		tHeading -= 360;
	  	}
  }

  /**
   * Turn left offset degrees. The Turtle heading is changed but the
   * Turtle position stays the same.  
   * offset can be any positive or negative value.  
   * The calculation is done % 360 degrees.
   * lt is exactly the opposite of rt.
   */
  public void lt (double offset) {
	  tHeading -= offset;
	  	while(tHeading<0)
	  	{
	  		tHeading += 360;
	  	}

  }

  /**
   * Move forward dist steps.  fd is exactly the opposite of bk.  The Turtle position
   * is changed but the Turtle heading stays the same.
   */  
  public void fd (double dist) {
	  if (this.x >GridArray.theCenter){
		  this.x=-GridArray.theCenter;
	  }
	  
	  if (this.x < -GridArray.theCenter){
		  this.x=GridArray.theCenter;
	  }
	  
	  if (this.y >GridArray.theCenter){
		  this.y=-GridArray.theCenter;
	  }
	  
	  if (this.y < -GridArray.theCenter){
		  this.y=GridArray.theCenter;
	  }
	  
	  double tempAngle;
		 if (tHeading <= 90) {
			 tempAngle = 90 - tHeading;
			 this.x += Math.cos(Math.toRadians(tempAngle))*dist;
		 } else if (tHeading <=180) {
			 tempAngle = tHeading - 90;
			 this.x += Math.cos(Math.toRadians(tempAngle))*dist;
		 } else if (tHeading <=270) {
			 tempAngle = 270 - tHeading;
			 this.x -= Math.cos(Math.toRadians(tempAngle))*dist;
		 } else {
			 tempAngle = tHeading - 270;
			 this.x -= Math.cos(Math.toRadians(tempAngle))*dist;
		 }
		 
		 if (tHeading <= 90) {
			 tempAngle = 90 - tHeading;
			 this.y -= Math.sin(Math.toRadians(tempAngle))*dist;
		 } else if (tHeading <=180) {
			 tempAngle = tHeading - 90;
			 this.y += Math.sin(Math.toRadians(tempAngle))*dist;
		 } else if (tHeading <=270) {
			 tempAngle = 270 - tHeading;
			 this.y += Math.sin(Math.toRadians(tempAngle))*dist;
		 } else {
			 tempAngle = tHeading - 270;
			 this.y -= Math.sin(Math.toRadians(tempAngle))*dist;
		 }
	 }
  


     
 
 
  /**
   * Move backward dist steps.  bk is exactly the opposite of fd.  The Turtle position
   * is changed but the Turtle heading stays the same.
   */   
  public void bk (double dist) {
	  fd(-dist);

  }

  // Queries:
  
  /**
   * Current heading of this Turtle in degrees, 0 to < 360, with 0 due north.
   */ 
  public double heading () {
    return this.tHeading;
  }

  /**
   * Current x position of the Turtle.
   */ 
  public double xcor () {
    return this.x;
  }

  /**
   * Current y position of the Turtle.
   */ 
  public double ycor () {
    return this.y;
  }
  
  
}