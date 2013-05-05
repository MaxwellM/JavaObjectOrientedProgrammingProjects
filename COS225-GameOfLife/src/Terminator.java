import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//implements window events to close a window
class Terminator extends WindowAdapter {

 public void windowClosing(WindowEvent e) {
  Window w = e.getWindow();
  w.dispose();
 }

 public void windowClosed(WindowEvent e) {
  System.exit(0);
 }
 
}
