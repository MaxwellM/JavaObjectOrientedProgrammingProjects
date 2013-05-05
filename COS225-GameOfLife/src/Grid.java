import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Grid extends JFrame {
  
  // Grid instance variables:
  private int size;      // size of Grid
  private int boxLen;    // size of each box
  private boolean running;    // state of Grid 
  private JButton button;     // button to turn "running" on and off
  private entityGrid eg;
  
  public Grid (int size, int boxLen) {
    
    super("Conway's Life"); // frame title
    
    this.size = size;
    this.boxLen = boxLen;
    
    this.addWindowListener(new Terminator());    
    
    eg = new entityGrid(size,size,boxLen,boxLen);

    // setup Grid (JFrame)
    JPanel gridLayoutHolder = new JPanel();
    GridLayout layout = new GridLayout(size,size,0,0);
    gridLayoutHolder.setLayout(layout);    
    for (int i=0;i<size;i++)
      for (int j=0;j<size;j++)
      {
        entity e = eg.getEntity(i,j);
        e.setEntityGrid(eg);
        gridLayoutHolder.add(e);
      }

    JPanel gridPanel = new JPanel();
    gridPanel.add(gridLayoutHolder, BorderLayout.CENTER);
    
    getContentPane().add(gridPanel, BorderLayout.CENTER);
    
    // create button and set its colors    
    button = new JButton("On/Off");  
    button.setForeground(Color.red);
    button.setBackground(Color.white);

    // create and register buttons listener:
    button.addActionListener(new Switcher(this));

    // add button to Grid's (JFrames) content pane:
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout( new FlowLayout());
    buttonPanel.add(button);
    this.getContentPane().add(buttonPanel, BorderLayout.WEST);
    
    // set state "running"
    running = true;
    
    setupScheduler();
    
}
  
    // run Turtles forever on a timer.  Also update display.  This 
    // routine takes the place of the Turtle and display runner threads
    private void setupScheduler()
    {
      ActionListener Scheduler = new
         ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              // 1 iteration of life model

              if (running){

                // save previous color
                for (int i=0;i<size;i++)
                  for (int j=0;j<size;j++)
                    eg.getEntity(i,j).updatePrevColor();

                // compute new grid
                for (int i=0;i<size;i++)
                  for (int j=0;j<size;j++)
                  {
                    entity e = eg.getEntity(i,j);
                    int n = e.neighbors();
                    Color pc = e.getPrevColor();
                    /*
                     *    1. Any live cell with fewer than two live neighbours dies, 
                     *       as if caused by underpopulation.
                     *    2. Any live cell with more than three live neighbours dies, 
                     *       as if by overcrowding.
                     *    3. Any live cell with two or three live neighbours lives on 
                     *       to the next generation.
                     *    4. Any dead cell with exactly three live neighbours 
                     *       becomes a live cell.
                     */ 
                  
                    if (pc == entity.LIVING)
                      if ((n < 2) || (n > 3))
                      {
                        e.setColor(entity.DEAD);
                        e.repaint();
                      }
                    if (pc == entity.DEAD)
                      if (n == 3)
                      {
                        e.setColor(entity.LIVING);
                        e.repaint();
                      }

                  }
              }
            }  
          };

      new Timer(1, Scheduler).start();
    }      
  
    public void switchState(){
      running = !running;
    }
  
}
//end of Grid
