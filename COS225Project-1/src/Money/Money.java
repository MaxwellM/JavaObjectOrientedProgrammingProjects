package Money;
public class Money {

	public int halfdollars, quarters, dimes, nickels, totalchange, dollars;

	Money() {

		totalchange = 0;
		dollars = 0;

	}

	// postCONDITION Displays the current balance
	public void minimum() {
		int x = dollars;
		int y = totalchange;

		System.out.println("Least amount of individual change to have $"
				+ dollars + "." + totalchange);
		System.out.println("Nickels: " + totalnickels());

		//removenickels();

		System.out.println("Dimes: " + totaldimes());

		//removedimes();

		System.out.println("Quarters: " + totalquarters());

		//removequarters();

		System.out.println("Halfdollars: " + totalhalfdollars());

		//removehalfdollars();

		System.out.println();

		dollars = x;
		totalchange = y;

	}

	// preCONDITION "totalchange" and "dollars" are defined
	// postCONDITION "totalchange" and "dollars" are set
	public void define(int x, int y) {
		totalchange = y;
		dollars = x;
	}

	public int addchange(int x) {
		totalchange = (totalchange + x);
		while (totalchange >= 100) {
			totalchange -= 100;
			totalchange = x;
		}
		return x;
	}

	// preCONDITION Current "totalchange" and "dollars"
	// postCONDITION Computes the change in "totalchange" and dollars"
	public void addmoney(int x, int y) {
		dollars = (dollars + x);
		totalchange = (totalchange + y);
		while (totalchange >= 100) {
			totalchange -= 100;
			dollars += 1;
		}
		System.out.println("Increased by $" + x + "." + y);
	}

	// postCONDITION Takes away the nickels
	public void removenickels() {
		nickels = totalnickels();
		while (nickels >= 20) {
			nickels -= 20;
			dollars -= 1;
		}
		totalchange -= (nickels * 5);
	}

	// postCONDITION Takes away the dimes
	public void removedimes() {
		dimes = totaldimes();
		while (dimes >= 10) {
			dimes -= 10;
			dollars -= 1;
		}
		totalchange -= (dimes * 10);
	}

	// postCONDITION Takes away the quarters
	public void removequarters() {
		quarters = totalquarters();
		while (quarters >= 4) {
			quarters -= 4;
			dollars -= 1;
		}
		totalchange -= (quarters * 25);
	}

	// postCONDITION Takes away the halfdollars
	public void removehalfdollars() {
		halfdollars = totalhalfdollars();
		while (halfdollars >= 2) {
			halfdollars -= 2;
			dollars -= 1;
		}
		totalchange -= (halfdollars * 50);
	}

	// postCONDITION Tells how many nickels
	public int totalnickels() {
		nickels = (20 * dollars) + (totalchange / 5);
		return nickels;
	}

	// postCONDITION Tells how many dimes
	public int totaldimes() {
		dimes = (10 * dollars) + (totalchange / 10);
		return dimes;
	}

	// postCONDITION Tells how many quarters
	public int totalquarters() {
		quarters = (4 * dollars) + (totalchange / 25);
		return quarters;
	}

	// postCONDITION Tells how many halfdollars
	public int totalhalfdollars() {
		halfdollars = (2 * dollars) + (totalchange / 50);
		return halfdollars;
	}
}
