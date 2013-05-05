package Rectangle;

public class Rectangle {
	static double length;		//the Length
	static double width;		//the Width
	static double perimeter; 	//the Perimeter
	static double area;			//the Area

/**
 * The length of this Rectangle
 */
	public double length(){
		return length;
	}

	/**
	 * The Width of this Rectangle
	 */
	public double width(){
		return width;
	}
	/**
	 * 
	 * The perimeter of this Rectangle
	 */
	public double perimeter(){
		return perimeter;
	}
	/**
	 * The Area of this Rectangle
	 */
	public double area(){
		return area;
	}
	
	
	/**
	 * Create a new Rectangle
	 */
	public Rectangle (double length, double width){
		Rectangle.width = width;
		Rectangle.length = length;
		Rectangle.perimeter = width+width+length+length;
		Rectangle.area = width*length;
	}
}



