package Rectangle;


public class RectangleDriver {

	/**
	 * @param args
	 * @param length 
	 */
	public static void main(String[] args) {
		// This will display the results to our Rectangle program
		
		new Rectangle(10.0,10.0);
		System.out.println("Rectangle length = " + Rectangle.length);
		System.out.println("Rectangle width = " + Rectangle.width);
		System.out.println("Rectangle perimeter = " + Rectangle.perimeter);
		System.out.println("Rectangle area = "+ Rectangle.area);

	}

}
