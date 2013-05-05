public class entityGrid {
  
  private entity [][] entities;
  private int rows;
  private int cols;
  
  public entityGrid (int rows, int cols, int width, int height){
    entities = new entity [rows][cols];
    for (int i=0;i<rows;i++)
      for (int j=0;j<cols;j++)
        entities[i][j] = new entity(width,height,i,j);
    this.rows = rows;
    this.cols = cols;
  }
  
  public entity getEntity(int row, int col){
    return entities[row][col];
  }
  
  public int getRows(){
    return rows;
  }
  
  public int getCols(){
    return cols;
  }
  
}
    