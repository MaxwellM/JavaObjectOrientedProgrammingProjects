package Counter;

/**
 * 
 * A simple integer counter
 * This will show all of the functions of the counter
 * The limit is 5, if it goes above it will reset to 0
 * It has the ability to increment by 1
 * It has the ability to reset to 0 on command
 * It has the ability to unreset and return to the prior count
 *
 */
public class Counter {

	private int mylimit; //Upper limit of our counter
	private int count; //current count
	private int oldcount; //variable to store the current count
						  //before it gets reset
	
	//Constructors:
	
	/**
	 * Create a new Counter initialized to 0
	 */
	public Counter () {
		mylimit = 5;
		count = 0;
		oldcount = 0;
	}
	
	//Queries:	
	
	/**
	 * The number of items counted
 	*/
	public int currentCount() {
		return count;
	}
	
	//Commands:
	
	/**
	 * Increment count by 1
	 */
	public void incrementCount () {
		if (count >= mylimit){
			reset();
		}
		else
			count = count +1;
	}
	
	/**
	 * Reset count to 0
	 */
	public void reset () {
		oldcount = count;
		count = 0;
	}
	
	public void unreset (){
		count = oldcount;
	}
}
