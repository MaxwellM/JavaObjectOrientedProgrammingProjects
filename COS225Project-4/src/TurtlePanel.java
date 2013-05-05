import java.awt.*;
import javax.swing.*;

/** 
 * The Turtle Panel Class is actually a swing jPanel, and 
 * instantiates a turtle and invokes (through 
 * paintComponent invoked automatically from the GUI) the drawing AND 
 * painting of turtle shapes.
 */
public class TurtlePanel extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/** instance variables
   */
  private LineList LL;

    /**
   * Create a new TurtlePanel 
   */    
  public TurtlePanel() {
    /**
     * Initialize a LineList to keep track of total 
     * Lines displayed on TurtlePanel
     */
    LL = new LineList();
  }
  
  /**
   * Draw a line on the TurtlePanel
   */
  public  void doDrawLine(double x1, double y1, double x2, double y2){
    /** 
     * Add a newly drawn line to the Linelist and
     * instruct paintComponent to repaint TurtlePanel
     */
    Line L = new Line(x1,y1,x2,y2);
    LL.add(L);
    
    /** 
     * In order to see the drawing unfolding,
     * slow down the main thread before invoking
     * repaint on the paintComponent of the GUI thread
     */
    for (int i=0;i<10000000;i++)
      continue;
    repaint();
  }
  
  /**
   * Repaint all lines drawn on the TurtlePanel
   */
  public  void paintComponent (Graphics g) {
    /** invoke the underlying JPanel paintComponent method,
     * then repaint all Lines previously drawn to the paintPanel
     */ 
    super.paintComponent(g);      
    
    Line L;
    for (int i = 0; i<LL.size();i++){
      L = LL.item(i);
      g.drawLine((int)L.x1,(int)L.y1,(int)L.x2,(int)L.y2);
    }
    
  }


  
  /**
   * getPreferredSize is mandatory and used by
   * the system to set the size of the visual
   * TurtlePanel, in this case 101x101 pixels.
   */   
  public Dimension getPreferredSize () {
    return new Dimension(GridArray.xSize,GridArray.ySize);
  }

  /**
   * getMinimumSize is mandatory and used by
   * the system to set the minimum size of the visual
   * TurtlePanel.
   */    
  public Dimension getMinimumSize () {
    return this.getPreferredSize();
  }
}
