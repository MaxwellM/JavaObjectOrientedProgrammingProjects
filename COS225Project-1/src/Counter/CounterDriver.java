package Counter;

public class CounterDriver {
	static Counter counter = new Counter();
	/**
	 * This displays the counter results!
	 */
	public static void main(String[] args) {
		System.out.println("Our limit is 5, lets start counting..");
		System.out.println(" ");
		System.out.println("Starting Count:");
		System.out.println(counter.currentCount());
		counter.incrementCount();
		System.out.println(counter.currentCount());
		counter.incrementCount();
		System.out.println(counter.currentCount());
		counter.incrementCount();
		System.out.println(counter.currentCount());
		System.out.println(" ");
		System.out.println("Before reset:");
		System.out.println(counter.currentCount());
		counter.reset();
		System.out.println(" ");
		System.out.println("After reset:");
		System.out.println(counter.currentCount());
		System.out.println(" ");
		System.out.println("After unreset:");
		counter.unreset();
		System.out.println(counter.currentCount());
		System.out.println(" ");
		System.out.println("Going to increment above our limit to autoreset: ");
		System.out.println(counter.currentCount());
		counter.incrementCount();
		System.out.println(counter.currentCount());
		counter.incrementCount();
		System.out.println(counter.currentCount());
		counter.incrementCount();
		System.out.println("This should reset: " +counter.currentCount());
	}
}
