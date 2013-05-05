import java.util.*;

public class LanguageTester {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Recognizer r = new LanguageVector();
		
		r.nextChar('a');

		r.nextChar('a');

		r.nextChar('a');

		r.nextChar('b');


		if (r.isIn()){
			System.out.println("string is in L");
			System.out.println("# of A's = "+r.A());
			System.out.println("# of B's = "+r.B());
		}
		else{
			System.out.println("string is not in L");
			System.out.println("# of A's = "+r.A());
			System.out.println("# of B's = "+r.B());
		}
		System.out.println("String = "+r.test());
		//System.out.println("End of test");
		r.reset();
		
		
		System.out.println(' ');
		r.nextChar('b');

		r.nextChar('b');

		r.nextChar('b');

		r.nextChar('a');


		if (r.isIn()){
			System.out.println("string is in L");
			System.out.println("# of A's = "+r.A());
			System.out.println("# of B's = "+r.B());
		}
		else{
			System.out.println("string is not in L");
			System.out.println("# of A's = "+r.A());
			System.out.println("# of B's = "+r.B());
		}
		System.out.println("String = "+r.test());
		//System.out.println("End of test");
		r.reset();
		
		System.out.println(' ');
		r.nextChar('a');

		r.nextChar('a');

		r.nextChar('b');

		r.nextChar('b');


		if (r.isIn()){
			System.out.println("string is in L");
			System.out.println("# of A's = "+r.A());
			System.out.println("# of B's = "+r.B());
		}
		else{
			System.out.println("string is not in L");
			System.out.println("# of A's = "+r.A());
			System.out.println("# of B's = "+r.B());
		}
		System.out.println("String = "+r.test());
		//System.out.println("End of test");
		r.reset();
		
		
		System.out.println(' ');
		r.nextChar('b');

		r.nextChar('b');

		r.nextChar('b');

		r.nextChar('b');


		if (r.isIn()){
			System.out.println("string is in L");
			System.out.println("# of A's = "+r.A());
			System.out.println("# of B's = "+r.B());
		}
		else{
			System.out.println("string is not in L");
			System.out.println("# of A's = "+r.A());
			System.out.println("# of B's = "+r.B());
		}
		System.out.println("String = "+r.test());
		//System.out.println("End of test");
		r.reset();
		System.out.println(' ');
		System.out.println("End of tests");
	}
}
