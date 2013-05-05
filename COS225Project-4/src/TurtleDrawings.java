

/** A Collection of statically executable Turtle drawing methods, each invoked using a turtle
 */
public class TurtleDrawings {
//	static int prevx;
//	static int prevy;   
	/**
	 * Draw a horizontal line
	 * @param t T is for Turtle
	 * @param x1 Starting X location
	 * @param y1 Starting Y location
	 * @param dist The distance the line will be drawn
	 */
  public static void stLine(Turtle t, int x1, int y1, int dist){
	  t.pd();
	  for (int i = 0; i<= dist; i++){
		  t.setx(x1);
		  t.sety(y1);
	      t.fd(dist);
      }
      t.pu();
   }
	/**
	 * Draw a vertical line
	 * @param t T is for Turtle
	 * @param x1 Starting X location
	 * @param y1 Starting Y location
	 * @param dist The distance the line will be drawn
	 */
  public static void stLine2(Turtle t, int x1, int y1, int dist){
	  t.pd();
	  t.setHeading(180);
	  for (int i = 0; i<= dist; i++){
		  t.setx(x1);
		  t.sety(y1);
	      t.fd(dist);
      }
      t.pu();
      t.setHeading(90);
   }
  /**
   * Use the turtle to draw a "Circle".
   */ 
  public static void Circle (Turtle t, int sides, int size) {
    /** 
     * Draw a circle as a "sides" sided polygon,
     * where each side is of length "side")
     */
	  double rot = 360 / sides;
	  t.pd();
	  for(int i = 0; i <= sides; i++) {
          t.fd(size);
          t.rt(rot);
	  }
	  t.pu();
  }

  /**
   * Use the turtle to draw a Spiral of "circles".
   */  
  public static void Spiral (Turtle t, int circles, int size) {
   /** Draw the spiral as a number of circles.  Each 
     * circle is actually a 20 sided polygon, where the side of 
     * the circle is of length "size"
     */
	  double rots = 360 / circles;
	  t.pd();
      for (int i = 0; i < circles ; i++){    
              Circle(t,20,size);
              t.rt(rots);
      }
      t.pu();
  }

  /**
   * Use the turtle to draw a Spiral of 20 increasing size "circles".  
   */   
  public static void SpiralIncreasing (Turtle t, int size) {
    /**
     * Draw each circle as a 20 sided polygon, where the side of each circle is
     * of increasing length, from 0 to "size".
     */ 
	  double rots = 360 / 20;
	  t.pd();
      for (int i = 0; i < 20 ; i++){ 
              Circle(t,25,i+size);
              t.rt(rots);
      }
      t.pu();
  }

  /**
   * Use the turtle to draw a Spiral of "squares", where the sides 
   * of each square are of length "size".  
   */   
  public static void SpiralSquare (Turtle t, int size) {
    /**
     * Draw each square of length "size".  
     */    
	  t.pd();
		 for (int j = 0; j < 4; j++) {
		        t.fd(size);
		        t.rt(90);
		 }
		 t.pu();
  }

  /**
   * Use the turtle to draw a "Square", where each side
   * is of length "size".
   */     
  public static void Square(Turtle t, int size) {
    /**
     * A square is a four sided circle, where each side is of
     * length "size".
     */ 
	 t.pd();
	 for (int j = 0; j < 4; j++) {
	        t.fd(size);
	        t.rt(90);
	 }
	 t.pu();
  }
  /**
   * Use the turtle to draw a "Rectangle", with the
   * dimensions "length" and "width".
   */      
  public static void Rectangle (Turtle t, int length, int width) { 
	  t.pd();
	  for (int i = 0; i < 2; i++){
		  t.fd(length);
		  t.rt(90);
		  t.fd(width);
		  t.rt(90);
	  }
	  t.pu();
  }
 
}