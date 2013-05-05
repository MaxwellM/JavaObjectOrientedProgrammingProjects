import javax.swing.JFrame;


/** 
 * TurtleWorld provides a high level drawing context for a Turtle
 */
public class TurtleWorld {

  /**
   * Instance Variables
   */
GridArray t = new GridArray();
  JFrame frame;
  TurtlePanel tPanel;


  /**
   * Constructor for a TurtleWorld "context".
   */
  public TurtleWorld(){
    /**
     * A swing JFrame and TurtlePanel (JPanel) 
     * are created and initially painted
     */
	t.initializeArray();				//This creates the array and fills it with 0's
    frame = new JFrame();
    tPanel = new TurtlePanel();
    frame.getContentPane().add (tPanel);
    frame.pack();
    frame.setVisible(true);
    
  }
  
  
  /**
   * Draw a line on the TurtleWorld "context".
   */
  public void  doDrawLine(double x1, double y1, double x2, double y2){	  
  // A point.
  if ((int)(x1-x2)==0){
	  if ((int)(y1-y2)==0){
		  t.turtleGrid[(int) t.wrapAroundx(x1)][(int) t.wrapAroundy(y1)] = "1"; //wraps the coordinate "if" needed
	  }
  //Vertical line.
	  else{
		  if(y1>y2){
			  double y = y2;
			  y2 = y1;
			  y1 = y;
		  }
		  for(int j=(int)y1;j<=(int)y2;j++){
			  t.turtleGrid[(int) t.wrapAroundx(x1)][(int) t.wrapAroundy(j)] = "1"; //wraps the coordinate "if" needed
		  }
		  
		  
	  }
  }
  // Line at an angle.
  else{
	  if ((int)(y1-y2)!=0){
		  int m = (int)((y1-y2)/(x1-x2));
		  int b = (int)(y1-m*x1);
		  for(int i=(int)x1;i<=(int)x2;i++){
			  int y = m*i+b;
			  t.turtleGrid[(int)t.wrapAroundx(i)][(int) t.wrapAroundy(y)] = "1"; //wraps the coordinate "if" needed
		  }
	  }
  // Horizontal line.
	  else{
		  if(x1>x2){
			  double x = x2;
			  x2 = x1;
			  x1 = x;
		  }
		  for(int x=(int)x1;x<=(int)x2;x++){
			  
			  t.turtleGrid[(int) t.wrapAroundx(x)][(int) t.wrapAroundy(y1)] = "1"; //wraps the coordinate "if" needed
		  }
	  }
	  
  }
      
	  tPanel.doDrawLine(x1,y1,x2,y2);
}
  /**
   * This method prints out the array
   */
  
  public void display() {
	  for (int i=0;i<=t.turtleGrid.length-1;i++){
		    for (int j=0;j<=t.turtleGrid.length-1;j++){
			    System.out.print(t.turtleGrid[j][i]);
  		  }
	  	  System.out.println("");
	  }
}
}