import javax.swing.*;
//@precondition:Null
//@postcondition:Takes the information and displays a JFrame.
public class TurtleTest {
  public static void main (String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add (new TurtlePanel());
    frame.pack();
    frame.setVisible(true);
  }
}
