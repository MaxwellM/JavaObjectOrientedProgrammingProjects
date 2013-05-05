package Money;

public class MoneyDriver {

	public static void main(String[] args) {
		// This will display our results in our Money program
		Money MikeM = new Money();
		MikeM.define(2, 10);

		System.out.println("MikeM's change in NICKELS: " + MikeM.totalnickels()
				+ "   DIMES: " + MikeM.totaldimes() + "   QUARTERS: "
				+ MikeM.totalquarters() + "  HALFDOLLARS: "
				+ MikeM.totalhalfdollars());
		System.out.println();

		System.out.println("Adding money to MikeM's account: ");
		MikeM.addmoney(4, 45);
		System.out.println();
		MikeM.minimum();

	}

}