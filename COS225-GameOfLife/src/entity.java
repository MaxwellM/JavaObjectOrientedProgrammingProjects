import java.awt.*;

public class entity extends Patch {
  
  public static final Color LIVING = Color.white;
  public static final Color DEAD = Color.black;
  
  private Color prevColor;
  private int row;
  private int col;

  private entityGrid eg;
  
  public entity (int width, int height,int row,int col){
    super(width,height);
    this.row = row;
    this.col = col;
    if (Math.random() < 0.6)
      color = DEAD;
    else
      color = LIVING;
}
  
  public void setEntityGrid(entityGrid eg){
    this.eg = eg;
  }
  
  public Color getPrevColor(){
    return prevColor;
}
  
  public Color getColor(){
    return color;
  }
  
  public int ColorValue(){
    if (color == LIVING)
      return 1;
    else
      return 0;
  }

  public int prevColorValue(){
     if (prevColor == LIVING)
      return 1;
    else
      return 0;
  }   
  
  public int neighbors(){
    int rows = eg.getRows();
    int cols = eg.getCols();
    int topRow = (row+rows-1) % rows;
    int bottomRow = (row+1) % rows;
    int leftCol = (col+cols-1) % cols;
    int rightCol = (col+1) % cols;
    
    int tot = 0;
      tot += eg.getEntity(topRow, leftCol).prevColorValue();
      tot += eg.getEntity(topRow, col).prevColorValue();
      tot += eg.getEntity(topRow, rightCol).prevColorValue();
      tot += eg.getEntity(row, leftCol).prevColorValue();
      tot += eg.getEntity(row, rightCol).prevColorValue();
      tot += eg.getEntity(bottomRow, leftCol).prevColorValue();
      tot += eg.getEntity(bottomRow, col).prevColorValue();
      tot += eg.getEntity(bottomRow, rightCol).prevColorValue();
    
    return tot;
  }
  
  public void updatePrevColor(){
    prevColor = color;
  }
    
  public void setColor(Color color){
    this.color = color;
  }
}
    
  
  