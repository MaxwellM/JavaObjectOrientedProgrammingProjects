import javax.swing.*;
import java.awt.*;
import java.util.*;

class Patch extends JPanel {
  
  private int width;
  private int height;
  protected Color color;
  
  public Patch (int width, int height)
    {
        color = Color.black;
        this.width = width;
        this.height = height;      
        setPreferredSize( new Dimension(width,height) );   // set size of patch
        setVisible( true );
    }

  public synchronized void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor(color);
        g.fillRect(0, 0, width, height);
    }   
  
}