package Temperature;


public class TemperatureSystemDriver {

	/**
	 * This will display a Temperature in Fahrenheit, and in Celsius, then adds them together
	 * and shows the output back in Fahrenheit
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double fahrenheit = 40;
		double celsius = 5;
		Temperature t = new Temperature(1,fahrenheit);
		Temperature d = new Temperature(2,celsius);
		
		System.out.println("T's Fahrenheit: "+t.fahrenheit());
		System.out.println("D's Celsius: "+d.celsius());
		t.addCelsius2(celsius);
		System.out.println("T+D's new Fahrenheit: "+t.fahrenheit());
	}

}
