import java.awt.*;

public class TurtleDrawings {

	static int prevx;
	static int prevy;
	
  /**
   * Use the turtle to draw a "Circle" (actually a "sides" sided polygon,
   * where each side is of length "side")
   */      
  public static void Circle (Graphics g, Turtle t, int sides, int size) {  
	int angle = (((sides-2) * 180) / sides);
	for (int i = 0; i < sides; i++) {
		prevx = (int) t.xcor();
		prevy = (int) t.ycor();
		t.fd(size);
		t.rt(180-angle);
		g.drawLine((int)prevx,(int)prevy,(int)t.xcord,(int)t.ycord);       
		}
	} 
  public static void Spiral (Graphics g, Turtle t, int circles, int size) {
	  int tempsize = size/circles;
	  int circlecount = circles;
	  int anglecount = 360/circles;
	  while(circlecount>=0){
		  Circle(g, t, 20, tempsize);
		  circlecount-=1;
		  t.setHeading(t.heading + anglecount);
	  }
	  
  }
  public static void SpiralIncreasing (Graphics g, Turtle t, int size) {
	  int counter = 20;
	  int tempsize = size/counter;
	  int anglecount = 360/counter;
	  while(counter>=0){
		  Circle(g, t, 20, tempsize);
		  t.setHeading(t.heading+anglecount);
		  tempsize -=2;
		  counter-=1;
	  }
	  
  }
  public static void SpiralSquare (Graphics g, Turtle t, int size) {
	  int counter = 20;
	  while(counter >= 0){
		 Square(g,t,size);
		 t.setHeading(t.heading() + 100);
		 counter-=1;
	  }
  } 
  public static void Square(Graphics g, Turtle t, int size) {
	    for (int i = 0; i < 4; i++) {
	        t.rt(90);
	        prevx = (int) t.xcor();
	        prevy = (int) t.ycor();
	        t.fd(size);
	        g.drawLine((int)prevx,(int)prevy,(int)t.xcord,(int)t.ycord); 
	    }
  }
}