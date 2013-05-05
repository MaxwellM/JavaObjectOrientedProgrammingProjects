package Temperature;

public class Temperature {
	//Our Temperature class
	double fahr, addCelsiusAmount;
	//When calling temperature, first is type(F-or-C), then the degree.
	public Temperature(int tempType,double temp){
		if (tempType == 1)
			fahr = temp;
		else
			fahr = (9./5)*temp+32;
	}
	//Farhenheit is defaulted to 32
	public Temperature(){
		fahr = 32;
	}
	//When calling fahrenheit, it returns the degree in F
	public double fahrenheit(){
		return fahr;
	}
	//When calling celsius, it returns the degreee in C
	public double celsius(){
		return (fahr-32)*(5./9);
	}
	//Sets the celsius temperature
	public void setCelsius(double temp){
		fahr = (9./5)*temp+32;
	}
	//Adds celsius
	//precondition:
	//postcondition: NewtemperatureObject.celsius() == 
	//				 OldtemperatureObject.celsius + temp:
	public void addCelsius(double temp){
		fahr = fahr + (9./5)*temp;
	}
	//Adds celsius
	public void addCelsius2(double addCelsiusAmount){
		fahr = fahr + addCelsiusAmount*(9./5);
	}
}
