import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Switcher implements ActionListener {
  
  private Grid sourceGrid;
  
  public Switcher(Grid sourceGrid){
    this.sourceGrid = sourceGrid;
  }

  public void actionPerformed (ActionEvent e) {
    Component source = (Component)e.getSource();
    Color oldForeground = source.getForeground();
    source.setForeground(source.getBackground());
    source.setBackground(oldForeground);  
    sourceGrid.switchState();
  }
  
}