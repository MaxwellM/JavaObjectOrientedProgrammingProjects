/**
 * A turtle for a turtle graphics system.
 **/

public class Turtle {

  /**
   * Instance variables
   */
	
	public double xcord;
	public double ycord;
	public double heading;

  // Constructors:
 
  /**
   * Creates a new Turtle with heading due north (0 degrees), and position at the origin (0,0)
   * @Precondition: Null 
   * @Postcondition: Turtle is instantiated with default values of position (0,0) and heading north of 0.
   **/  
	
  public Turtle() {
	  xcord = 0;
	  ycord = 0;
	  heading = 0;
  }

  /**
   * Creates a new Turtle with specified heading and position
   * @Precondition: Null 
   * @Postcondition: Turtle is instantiated with specified position and heading 
   **/ 
  
  public Turtle (double inith,double x, double y) {
	  heading = inith %360;
	  xcord = x;
	  ycord = y;
	 
  }

  /**
   * Creates a new Turtle with specified heading and position at the origin (0,0)
   * @Precondition: Null
   * @Postcondition: Turtle is instantiated with specified heading and position (0,0)
   **/ 
  
  public Turtle (double inith) {
	  heading = inith %360;
  }

  /**
   * Creates a new Turtle with heading due north (0 degrees) and specified position
   * @Precondition: Null
   * @Postcondition: Turtle is instantiated with specified position and heading due north (0 degrees) 
   **/ 
  
  public Turtle (double x, double y) {
	  xcord = x;
	  ycord = y;
  }

  // Commands:

  /**
   * Resets the turtle to x position. 
   * @Precondition: Null
   * @Postcondition: Turtle's x-coordinate is changed to specified value
   **/ 
  
  public void setx (double x) {
	  xcord = x;
  }

  /**
   * Resets the turtle to y position. 
   * @Precondition: Null
   * @Postcondition: Turtle's y-coordinate is changed to specified value
   **/ 
  
  public void sety (double y) {
	  ycord = y;
  }  
  
   /**
   * Resets the turtle to tHeading. 
   * @Precondition: Null
   * @Postcondition: Turtle's heading is changed to specified value
   **/ 
  
  public void setHeading (double tHeading) {
	  heading = tHeading %360;
	  if (heading < 0) 
		   heading = heading + 360;
  }

  /**
   * Turns right offset degrees. The turtles heading is changed but the turtle position stays the same.  
   * @Precondition: Null
   * @Postcondition: The turtles heading is changed right specified value, but the turtle position stays the same. 
   **/ 
  
  public void rt (double offset) { 
	   heading = (heading + offset) % 360;
	   if (heading < 0) 
		   heading = heading + 360;
  }
  
  /**
   * Turns left offset degrees. The turtles heading is changed but the turtle position stays the same.  
   * @Precondition: Null
   * @Postcondition: The turtles heading is changed left specified value, but the turtle position stays the same. 
   **/ 
  
  public void lt (double offset) {
	  rt(-offset);
  }

  /**
   * Move forward dist steps.  fd is exactly the opposite of bk.  The turtle position
   * is changed but the turtle heading stays the same.
   * @Precondition: Some specified heading and some distance to travel
   * @Postcondition: The turtle will move forward that distance.
   **/  
  
  // 0 degrees is north
  // 90 degrees is east
  // 180 degrees is south
  // 270 degrees is west
  
  public void fd (double dist) { 
      xcord = xcord + (dist * Math.cos(Math.toRadians(heading)));
      ycord = ycord + (dist * Math.sin(Math.toRadians(heading)));
  }

  /**
   * Move backward dist steps.  bk is exactly the opposite of fd.  The turtle position
   * is changed but the turtle heading stays the same.
   * @Precondition: Some specified heading and some distance to travel
   * @Postcondition: The turtle will back forward that distance.
   **/   
  
  public void bk (double dist) {
	  fd(-dist);
  }

  // Queries:

  /**
   * Current heading of this turtle in degrees, 0 to < 360, with 0 due north.
   * @Precondition: Null
   * @Postcondition: The heading of the turtle is returned. 
   **/ 
  
  public double heading () {
    return heading;
  }

  /**
   * Current x position of the turtle.
   * @Precondition: Null
   * @Postcondition: The x coordinate of the turtle is returned
   **/ 
  
  public double xcor () {
    return xcord;
  }

  /**
   * Current y position of the turtle.
   * @Precondition: Null
   * @Postcondition: The y coordinate of the turtle is returned
   **/ 
  
  public double ycor () {
    return ycord;
  }
  
  
}
