
public class GridArray {
	/**
	 * This area shows the variables used to create the grid
	 * xsize/ysize = L x W of the grid, as in parameter 
	 * xboxes/yboxes = how many boxes make up the grid
	 * xboxsize/yboxsize = the size of each "patch" or grid square
	 * atZero = the center starting point
	 */
	public String [][] turtleGrid = new String [xSize][ySize];
	public static double theCenter = 55.5;
	public static int xSize = 101;
	public static int ySize = 101;
	public int yPatchSize = 10;
	public int xPatchSize = 10;
	public int xPatchNum = 10;
	public int yPatchNum = 10;
	/**
	 * Creating the array and filling it with "0s"
	 */
	public void initializeArray(){
		for(int row = 0; row<xSize; row++){
			for(int column = 0; column<ySize; column++){
				turtleGrid[row][column]="0";		
			}
		}
	}
	/**
	 * My attempt to keep the drawings in bounds!
	 * @param x1 the X value
	 * @return X in the grid!
	 */
	public double wrapAroundx(double x1){
		if(x1>=xSize){
			x1 = x1 - xSize;
		}
		else if(x1<0){
			x1 = x1 + xSize;
		}
		return x1;
	}
	/**
	 * My attempt to keep the drawings in bounds!
	 * @param y1 the Y value
	 * @return Y in the grid!
	 */
	public double wrapAroundy(double y1){
		if(y1>=ySize){
			y1 = y1 - ySize;
		}
		else if(y1<0){
			y1 = y1 + ySize;
		}
		return y1;
	}
	/**
	 * Gives number of xboxes that live in the grid
	 * @return the number of xboxes that live in the grid
	 */
	public int findxPatchSize(){
		return xSize/xPatchNum;
	}
	/**
	 * Gives the number of yboxes that live in the grid
	 * @return the number of yboxes that live in the grid
	 */
	public int findyPatchSize(){
		return ySize/yPatchNum;
	}
	/**
	 * Gives the size of the array, "L"
	 * @return the length of the grid
	 */
	public int arraySizeX(){
		return xSize;
	}
	/**
	 * Gives the size of the array, "W"
	 * @return the width of the grid
	 */
	public int arraySizeY(){
		return ySize;
	}
	/**
	 * Takes the normal layout of an array and changes it so that X=0 is in the center
	 * @param x1 The X value
	 * @return X=0 is in the center
	 */
	
	public double worldToArrayx(double x1){
		if(x1>=0){
			x1 = theCenter + x1;
		}
		else if (x1<theCenter){
			x1 = theCenter - x1;
		}
		return x1;
	}
	/**
	 * Takes the normal layout of an array and changes it so that Y=0 is in the center
	 * @param y1 the Y value
	 * @return Y=0 is in the center
	 */
	public double worldToArrayy(double y1){
		if(y1>=0){
			y1 = theCenter - y1;
		}
		else if(y1<theCenter){
			y1 = theCenter + y1;
		}
		return y1;
	}
	/**
	 * Sets the index of the grid to the array
	 * @param x X value
	 * @param y Y value 
	 * @return the grid
	 */
	public String getIndexX(int x, int y){
		return turtleGrid[x][y];
	}
}